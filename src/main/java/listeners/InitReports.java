package listeners;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import utilities.MyExtentReports;
/**
 * @author YugandharReddyGorrep
 *
 */
public class InitReports extends TestListenerAdapter
{
	/**
	 * @description: Calling initialization of extent reports.
	 * 
	 * @throws Exception
	 */
	public InitReports() throws IOException
	{
		MyExtentReports extentReports=new MyExtentReports(); // Initialization of -Extent reports and ATU Reports
		extentReports.initExtentReports();
		
	}
}
