package com.example.CDTT2.Ultils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUltils {

	public static final String Date_Time_Format = "yyyy-MM-dd HH:mm:ss";

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Date_Time_Format);

	public static String toString(LocalDateTime date) {
		return date.format(formatter);
	}

	public static LocalDateTime toDate(String date) {
		return LocalDateTime.parse(date, formatter);
	}
}
