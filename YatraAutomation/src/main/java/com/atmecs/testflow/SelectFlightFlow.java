package com.atmecs.testflow;

import org.openqa.selenium.WebDriver;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

public class SelectFlightFlow {
	public static void sortingFlights(WebDriver driver) {
		boolean visibility = CommonUtility.isElementVisible(driver,
				YatraFlightBookingLocators.getLocators("loc.btn.departure.SortBydeparture"));
		System.out.println(visibility);
		if (visibility == true) {
			CommonUtility.clickElement(driver,
					YatraFlightBookingLocators.getLocators("loc.btn.departure.SortBydeparture"));
		}
	}

	public static void selectingFlights(WebDriver driver) {
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.return.SortByprice"));
		CommonUtility.clickElement(driver, YatraFlightBookingLocators.getLocators("loc.btn.bookNow"));
	}
}
