package base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import jxl.read.biff.BiffException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestBaseReport {

	

	

	

	protected static ExtentReports extent;
	protected static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	protected static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public ExtentTest parent;
	public ExtentTest child;

	@BeforeSuite
	public void beforeSuite_ExtentReport() {

		extent = ExtentManager.createInstance("test-output/SmartReport.html");
		extent.setSystemInfo("Host Name", "Automation Server");
		extent.setSystemInfo("Environment", "Pre Production");
		extent.setSystemInfo("Java Version", "Java 8");
		extent.setSystemInfo("User Name", "Sita");

	}

	@BeforeClass
	public synchronized void beforeClass_ExtentReport() {

		parent = extent.createTest(getClass().getName());
		parentTest.set(parent);
	}

	@BeforeMethod
	public void initClient_ExtentReport(Method method) throws BiffException, IOException {

		child = ((ExtentTest) parentTest.get()).createNode(method.getName());

		test.set(child);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown_ExtentReport(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			((ExtentTest) test.get()).fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {

			((ExtentTest) test.get()).skip(result.getThrowable());

		} else {

			((ExtentTest) test.get()).pass("Test passed");
		}

		extent.flush();

	}

}
