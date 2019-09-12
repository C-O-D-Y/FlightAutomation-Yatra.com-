package com.atmecs.dataProvider;

import org.testng.annotations.DataProvider;

import com.atmecs.constants.FilePath;
import com.atmecs.utils.ProvideData;

public class CityDataProvider {

	@DataProvider(name = "cityinput")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.CITYTESTDATA_FILE);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	public static void main(String[] args) {

		Object[][] data = new CityDataProvider().getData();
		for (Object[] objects : data) {
			String userName = (String) objects[0];
			String password = (String) objects[1];
			System.out.println(" " + userName + "   " + password);
		}
	}
}