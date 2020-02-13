package verify;

import java.io.File;
import java.io.IOException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;


public class SoftAssertions {
	static SoftAssert softAssert = new SoftAssert();
	public static void fail(String file, ExtentTest test) throws IOException{
		test.log(Status.FAIL, "fail()-Exception"+test.addScreenCaptureFromPath(file));
		softAssert.fail();
	}
}
