package listenerUtil;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImplementation implements IRetryAnalyzer {

	int count = 0;
	int upperLimit = 4;
	@Override
	public boolean retry(ITestResult result) {
		if(count<upperLimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
