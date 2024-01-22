package com.hexaware.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateAPIs {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		System.out.println(date1.isLeapYear());
		
		LocalDate date2 = LocalDate.of(2023, 12, 31);
		System.out.println(date1.isAfter(date2));
		
		System.out.println(date1.plusDays(20));
		
		System.out.println(date2.minusYears(23));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(date2.format(formatter));
		
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(date2.format(format));
	}

}
