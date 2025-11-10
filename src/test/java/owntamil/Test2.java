package owntamil;

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

import genericutilities.Javautility;

public class Test2 implements ITestListener,ISuiteListener {
ExtentReports  report;
ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		
		Reporter.log("execution starts");
		Javautility jlib = new Javautility();
	ExtentSparkReporter spark = new ExtentSparkReporter("./extentsreports/report_"+jlib.getcurrentdateandtime()+".html");
	spark.config().setDocumentTitle("a");
	spark.config().setReportName("abh");
	spark.config().setTheme(Theme.DARK);
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo(null, null);
	}

	@Override
	public void onFinish(ISuite suite) {
	report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testcasename = result.getMethod().getMethodName();
		 test = report.createTest(testcasename);
		test.log(Status.INFO, testcasename+"exec stars");
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcasename = result.getMethod().getMethodName();
		test.log(Status.FAIL,testcasename+"fails");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	
	

}
