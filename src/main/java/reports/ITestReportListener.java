package reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ITestReportListener implements ITestListener {


	public void onStart(ITestContext context) {
		System.out.println("Test Suite " + context.getName() + " started. ");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println(("Test Suite " + context.getName() + " ended"));
		ExtentTestConfig.getTest().log(Status.INFO, "Test finished.");
		ExtentTestConfig.endTest();
		ExtentReportManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		String testClassName = result.getMethod().getTestClass().getName().split("tests.")[1];
		ExtentTestConfig.startTest(testClassName+" -> "+result.getMethod().getMethodName());
		ExtentTestConfig.getTest().log(Status.INFO, "Started "+result.getMethod().getDescription()+" Test");
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestConfig.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentTestConfig.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		ExtentTestConfig.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
