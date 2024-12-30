package com.zepto.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtills {

	public String generateRandomString() {
		// Directly use the static method randomAlphabetic from RandomStringUtils
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}

	public String generateRandomNumber() {
		// Directly use the static method randomAlphabetic from RandomStringUtils
		String randomNumber = RandomStringUtils.randomNumeric(5);
		return randomNumber;
	}

	public String generateRandomAlfaNumeric() {
		// Directly use the static method randomAlphabetic from RandomStringUtils
		String randomAlfaNumeric = RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(2);
		return randomAlfaNumeric;
	}

	public static void main(String[] args) {
		CommonUtills c = new CommonUtills();
		System.out.println(c.generateRandomAlfaNumeric());
		System.out.println(c.generateRandomNumber());
		System.out.println(c.generateRandomString());
	}
}
