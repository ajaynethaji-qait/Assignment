package com.qait.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MakeMyTrip {
	public static void main(String args[]) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// Getting current date
		Calendar cal = Calendar.getInstance();
		// Number of Days to add
		cal.add(Calendar.DAY_OF_MONTH, 7);
		// Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		// Displaying the new Date after addition of Days to current date
		System.out.println("Date after Addition: " + newDate);
	}
}
