package com.shu.nitin.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeAPIDemo {

	public static void main(String[] args) {
		LocalDate current = LocalDate.now();
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("UTC"));
		System.out.println(current);
		System.out.println(dateTime);
	}

}
