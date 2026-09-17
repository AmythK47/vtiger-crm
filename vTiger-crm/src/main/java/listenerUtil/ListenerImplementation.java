package listenerUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseClass;
import threadLocalClass.ThreadLocalClass;

public class ListenerImplementation implements ITestListener , ISuiteListener
{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite)
	{
		String suiteName = suite.getName();
		Reporter.log("SUITE STARTED ---> "+ suiteName);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		spark = new ExtentSparkReporter("./AdvancedReports/report"+"_"+time+".html");
		spark.config().setDocumentTitle("vTiger");
		spark.config().setReportName(suiteName);
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("DEVICE", "ASUS TUF F15");

		
	}
	
	@Override
	public void onFinish(ISuite suite)
	{
		Reporter.log("SUITE COMPLETED ---> "+ suite.getName());
		report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult res)
	{
		String name = res.getMethod().getMethodName();
		test = report.createTest(name);  
		ThreadLocalClass.setTest(test);
		test.log(Status.INFO, name+" ----> STARTED");
	
	}
	
	@Override
	public void onTestFailure(ITestResult res)
	{
		String name = res.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		TakesScreenshot tks = (TakesScreenshot)BaseClass.sdriver;
		String filepath = tks.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(filepath , name+"_"+time);
		
		test.log(Status.FAIL, name+" ----> FAILED");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult res)
	{
		String name = res.getMethod().getMethodName();
		test.log(Status.PASS, name+" ----> SUCCESSFULL");
		
	}
	
	@Override
	public void onTestSkipped(ITestResult res)
	{
		String name = res.getMethod().getMethodName();
		test.log(Status.SKIP, name+" ----> SKIPPED");
	}
	


}
