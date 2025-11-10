package genericutilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listnerimplementations implements ITestListener,ISuiteListener  {
public ExtentReports report;
public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		Javautility jlib = new Javautility();
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report_"+jlib.getcurrentdateandtime()+".html");
		spark.config().setDocumentTitle("CRM Reports");
		spark.config().setReportName("NINZA_CRM_Report");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "chrome");
		
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("report backup");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testcasename = result.getMethod().getMethodName();
		test=report.createTest(testcasename);
		test.log(Status.INFO,testcasename+"Execution started");
		//System.out.println(testcasename+"Execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testcasename = result.getMethod().getMethodName();
		test.log(Status.PASS,testcasename+"Execution success");
	//	System.out.println(testcasename+" Execution success");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcasename = result.getMethod().getMethodName();
		test.log(Status.FAIL,testcasename+"Execution failed");
		//System.out.println(testcasename+"Execution failed");
		Javautility jlib = new Javautility();
	TakesScreenshot ts = (TakesScreenshot)Baseclass.sdriver;
	 String src = ts.getScreenshotAs(OutputType.BASE64);
	 test.addScreenCaptureFromBase64String(src);
	
	//File dest = new File("./Errorshots/"+testcasename+jlib.getcurrentdateandtime()+".png");
	//try {
	//	FileHandler.copy(src, dest)	;
	//} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	//}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testcasename = result.getMethod().getMethodName();
		test.log(Status.SKIP, testcasename+"Execution skipped");
	//	System.out.println(testcasename+"Execution skipped");
		
		
	}
	

	
}
