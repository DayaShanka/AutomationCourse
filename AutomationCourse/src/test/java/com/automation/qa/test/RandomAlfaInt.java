package com.automation.qa.test;

import java.util.Random;

public class RandomAlfaInt {

	public static void main(String[] args) {

		int lengthReq = 6;
		String reqString = "";
		String random = "a1W2D1fr34ffr2";
		random = random.toUpperCase();

		Random ran = new Random();

		for (int i = 0; i < lengthReq; i++) {

			int index = ran.nextInt(random.length());

			reqString = reqString + random.charAt(index);

		}

		System.out.println("Required String: " + reqString);

	}

}
