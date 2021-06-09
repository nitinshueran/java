package com.shu.nitin.companies.toptal;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Solution3 {

	public int solution(int Y, String A, String B, String W) {
		LocalDate from = LocalDate.of(Y, Month.valueOf(A.toUpperCase()), 1);
		LocalDate to = LocalDate.of(Y, Month.valueOf(B.toUpperCase()), 30);
		return (int) ChronoUnit.WEEKS.between(from, to);

	}

}
