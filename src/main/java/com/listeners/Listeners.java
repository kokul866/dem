package com.listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reports.Extentreport;
import com.utils.Utilities;

public class Listeners implements ITestListener {
	WebDriver driver;
	ExtentReports e=Extentreport.extent();
    ExtentTest et;
    ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		et=e.createTest(result.getMethod().getMethodName());
		tl.set(et);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().log(Status.PASS,"TEST PASSED");
	}

	public void onTestFailure(ITestResult result) {
		Date d = new Date();
	    d.toString();
	    SimpleDateFormat s = new SimpleDateFormat("M/dd/yyyy hh:mm:ss");
	    String date=s.format(d); 
		tl.get().fail(result.getThrowable());
		String testcasename=result.getMethod().getMethodName();
		 driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
		}
		try {
			tl.get().addScreenCaptureFromPath(Utilities.getscreenshot(driver,testcasename),testcasename.concat(date));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stu
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		e.flush();
 	}
	
}
