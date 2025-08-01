package com.amar.utilityClasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import static com.amar.utilityClasses.playwrightFactory.screanShort;

public class listnerClass extends baseClass implements ITestListener {

	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	String path;

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		 System.out.println("******Scuite get stated*******");
		String reportsPath = System.getProperty("user.dir") + "./ExtendRepots/report.html";
		sparkReporter = new ExtentSparkReporter(reportsPath);
		sparkReporter.config().setDocumentTitle("Amar-ceremic-Test");
		sparkReporter.config().setReportName("End to end ");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "AmarCeramicTest");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("Username", System.getProperty("user.name"));

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestStart(result);
		System.out.println(result.getMethod().getMethodName() + ": stated!");
		test = extent.createTest(result.getMethod().getMethodName());
		test.assignAuthor("Anil");
		test.assignAuthor("regration");
		test.assignDevice("windows");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSuccess(result);
		System.out.println(result.getMethod().getMethodName() + ": passed!");
		extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, "Test Case Pass :" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// System.out.println(result.getMethod().getMethodName()+": failed!");
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, "Test Case Pass :" + result.getMethod().getMethodName());

		path = System.getProperty("user.dir") + "./screanShots/" + result.getMethod().getMethodName()
				+ System.currentTimeMillis() + ".png";
		test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screanShort(path)).build());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSkipped(result);
		System.out.println(result.getMethod().getMethodName() + ": skipped!");
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, "Test Case Pass :" + result.getMethod().getMethodName());

		test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screanShort(path)).build());

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		System.out.println("******Scuite get ended*******");
		extent.flush();
	}

}
