package com.ninjaselenium.qa.util;

import java.util.Date;

public class Utilities {

	public static String generateEmailWithTimeStamp() {
		// using static to use this method in Login class with the help of
		// Utilities.generateEmailWithTimeStamp()

		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "daya.choubey.111." + timeStamp + "@gmail.com";

	}

}