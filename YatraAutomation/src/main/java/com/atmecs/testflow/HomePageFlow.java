package com.atmecs.testflow;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

public class HomePageFlow {
	public static void cityInput(WebDriver driver, String fromCity, String toCity) throws InterruptedException {
		BasicConfigurator.configure();

		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.roundTrip"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.inputbox.departFrom"));
		CommonUtility.clickAndSendText(driver, YatraFlightBookingLocators.getLocators("loc.inputbox.departFrom"), 5,
				fromCity);
		Thread.sleep(2000);
		CommonUtility.action(driver);
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.inputbox.goingTo"));
		CommonUtility.clickAndSendText(driver, YatraFlightBookingLocators.getLocators("loc.inputbox.goingTo"), 2,
				toCity);
		Thread.sleep(2000);
		CommonUtility.action(driver);
	}

	public static void dateInput(WebDriver driver) {
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.departureDate"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.departureDateOption"));
		// return wala validation
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.returnDate"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.returnDateOption"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.travellerClass"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.adultPlus"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.child"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.businessClass"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.cbox.noStop"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.searchFlights"));
	}
}
