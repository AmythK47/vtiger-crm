package genericUtility;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility {
	
	public String readDataFromPropertiesFile(String Key) throws Exception
	{
		// 1. open the properties file in read mode
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");

		// 2. create the object of properties class
		Properties p = new Properties();

		// 3. load the file which is under read mode
		p.load(fis);
		
		//return the value
		return p.getProperty(Key);
	}

}
