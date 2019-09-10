package com.atmecs.testScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.extentReports.Extent;

public class TestBase1 extends Extent {
	WebDriver driver;

	@Test(priority = 0)
	@Parameters("selectBrowser")

	public void loginflight1(String selectBrowser) {

		switch (selectBrowser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "./lib/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
}