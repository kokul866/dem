package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.Constants;

public class Extentreport {
	static ExtentReports report;
public static ExtentReports extent() {
	ExtentSparkReporter e=new ExtentSparkReporter(Constants.reportpath);
	e.config().setDocumentTitle("GTPL BANK");
    report=new ExtentReports();
    report.attachReporter(e);
    return report;
	
	
}
}
