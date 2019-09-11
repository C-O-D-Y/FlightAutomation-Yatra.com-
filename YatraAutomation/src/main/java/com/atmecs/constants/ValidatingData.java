package com.atmecs.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.utils.ReadPropertiesFile;

public class ValidatingData {
	static Properties Property;

	public ValidatingData() {
		try {
			Property = ReadPropertiesFile.loadProperty(FilePath.VALIDATION_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static String getValidatingData(String key) {
		String value = Property.getProperty(key);
		return value;
	}
}
