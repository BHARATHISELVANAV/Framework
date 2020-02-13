package utilities;

import java.io.InputStream;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

public class InitTests {
	
	public static SoftAssert softAssert = new SoftAssert();

	Properties props = new Properties();
	public static InputStream input;
	public static String BASEURL = null;
	public static String USERNAME = null;
	public static String PASSWORD = null;
	
	public static String BROWSER_TYPE = null;
	public static String dir_path = null;
	
	public InitTests() {
		try {
			ClassLoader loader = this.getClass().getClassLoader();
			input = loader.getResourceAsStream("config/testdata.properties");
			props.load(input);
			BASEURL = props.getProperty("url");
			USERNAME = props.getProperty("uname");
			PASSWORD = props.getProperty("pwd");
			BROWSER_TYPE = props.getProperty("browserType");
			dir_path = System.getProperty("user.dir");
			
		}
		catch(Exception e) {
			System.out.println("Got exceptions in init chrome");
		}
	}
	
	
	
	
}
