package com.atmecs.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.utils.ReadPropertiesFile;

public class YatraFlightBookingLocators {
	static Properties homePageProperty;

	public YatraFlightBookingLocators() {
		try {
			homePageProperty = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_HOME);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static String getLocators(String key) {
		String value = homePageProperty.getProperty(key);
		return value;
	}
}
