package com.atmecs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.ValidatingData;
import com.atmecs.constants.YatraFlightBookingLocators;
import com.atmecs.helpers.CommonUtility;

public class ErrorMessage {
	YatraFlightBookingLocators locators = new YatraFlightBookingLocators();
	List<WebElement> flightDetails = new ArrayList<>();
	ValidatingData data = new ValidatingData();

	public void isFlightTimingCorrect(WebDriver driver) {
		flightDetails = CommonUtility.getElementsList(driver,
				YatraFlightBookingLocators.getLocators("loc.errormsg.txt"));
		for (int initial = 0; initial < flightDetails.size(); initial++) {
			String element = flightDetails.get(initial).getText();
			if (initial == 0) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("Email address is required."),
						"message is not dispalyed");
			} else if (initial == 1) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("Mobile number is required."),
						"message is not dispalyed");
			} else if (initial == 2) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("Required."),
						"message is not dispalyed");
			} else if (initial == 3) {
				Assert.assertEquals(element, ValidatingData.getValidatingData("First\r\n" + 
						"							name is required."),
						"message is not dispalyed");
			}
		}
		System.out.println("Flight timings are correct");
		}
	}
}
