package com.atmecs.extentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.atmecs.constants.FilePath;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports(FilePath.EXTENT_REPORT_FILE, true);
		extent.loadConfig(new File(FilePath.EXTENT_CONFIG));
	}

	public static String getScreenshot(WebDriver driver, String testname) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = FilePath.FAILED_SCREENSHOT_FILE + testname + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterTest
	public void tearDown(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			logger.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
			// extent report

			String screenshotPath = Extent.getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath)); // to add screenshot in extent
			// report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		}

		extent.endTest(logger); // ending test and ends the current test and prepare to create html report
		driver.quit();
	}

	@AfterTest
	public void endReport() {

		extent.flush();
		extent.close();
	}

}
