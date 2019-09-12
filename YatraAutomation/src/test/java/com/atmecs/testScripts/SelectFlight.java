package com.atmecs.testScripts;

import org.testng.annotations.Test;

import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.dataProvider.CityDataProvider;
import com.atmecs.helpers.CommonUtility;
import com.atmecs.pages.SelectFlights;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;
import com.atmecs.testflow.SelectFlightFlow;

public class SelectFlight extends TestBase {
	SelectFlights select = new SelectFlights();

	@Test(priority = 1, dataProvider = "cityinput", dataProviderClass = CityDataProvider.class)
	public void checkRedirection(String fromCity, String toCity) {
		try {
			HomePageFlow.cityInput(driver, fromCity, toCity);
		} catch (InterruptedException e) {
			System.out.println("System Interrupted! please try again");
		}
	}

	@Test(priority = 2)
	public void checkSortingButtonFunctionality() {
		HomePageFlow.dateInput(driver);
		CommonUtility.explicitWait(driver, YatraFlightBookingLocators.getLocators("loc.btn.departure.SortBydeparture"));
		select.isRedirectionCorrect(driver);
		SelectFlightFlow.sortingFlights(driver);
		CommonUtility.scrollDownPage(driver, 0, 600);
		select.isButtonDisplayed(driver, YatraFlightBookingLocators.getLocators("loc.rbtn.returnFlight"));
		SelectFlightFlow.selectingFlights(driver);
	}
}
