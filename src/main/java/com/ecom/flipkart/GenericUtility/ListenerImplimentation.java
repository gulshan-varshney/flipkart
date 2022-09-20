package com.ecom.flipkart.GenericUtility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class ListenerImplimentation  implements ITestListener{


	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test = report.createTest(methodname);

	}

	public void onTestSuccess(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		test.pass(methodname+" is Passed ");
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.skip(methodname+" is Skipped ");

	}




	public void onStart(ITestContext context) {

		ExtentSparkReporter spark = new ExtentSparkReporter("./extent-output/report.html");
		spark.config().setDocumentTitle("VTiger Report");
		spark.config().setReportName("Extent Report of VTiger");
		spark.config().setTheme(Theme.DARK);


		report = new  ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("Reporter Name", "Swatantra Singh");
		report.setSystemInfo("Platform Name", " Windows 10");
		report.setSystemInfo("Browser Name", "Chrome");
		report.setSystemInfo("Browser Version", "103.0.5060.114");

	}

	public void onFinish(ITestContext context) {

		report.flush();
	}

	public void onTestFailure(ITestResult result) {

		String testname = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		String date = new Date().toString().replaceAll(":", "-");
		String picname = testname+date+".PNG";


		try {
			File dest = new File("./screenshot/"+picname);
			FileUtils.copyFile(src, dest);
			String path = dest.getAbsolutePath();
			test.addScreenCaptureFromPath(path);
		}
		catch(Exception e) {
			System.out.println(" Screen shot not taken ");
		}

		test.fail(testname+" is Failed ");
		test.fail(result.getThrowable());
		test.addScreenCaptureFromPath("./screenshot/"+picname);

	}
}