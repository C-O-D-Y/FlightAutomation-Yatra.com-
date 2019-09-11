package com.atmecs.pages;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

//Validating the selection of the flights is correct or not

public class SelectFlights {

	YatraFlightBookingLocators locaters = new YatraFlightBookingLocators();

	/**
	 * In this method i'm validating the functionality of redirecting the page is
	 * correct.
	 * 
	 * @param driver
	 */
	public void isRedirectionCorrect(WebDriver driver) {

		WebElement element = (WebElement) CommonUtility.getElementsList(driver,
				YatraFlightBookingLocators.getLocators("loc.selectFlightPageTitle"));
		String title = element.getText();
		Assert.assertEquals(title, "Yatra.com | Mumbai to Bangalore flights", "Redirection is not on the correct page");
		System.out.println("Redirection is on the correct page");
	}

	/**
	 * In this method i'm validating the functionality of button is displayed or not
	 * 
	 * @param driver
	 * @param xpath
	 */
	public static boolean isButtonDisplayed(WebDriver driver, String xpath) {
		BasicConfigurator.configure();
		boolean selected = false;
		selected = CommonUtility.isSelected(driver, YatraFlightBookingLocators.getLocators(xpath));
		Assert.assertEquals(selected, true, "Flight is not selected correctly");
		System.out.println("Flight is selected correctly");
		return selected;
	}
}
