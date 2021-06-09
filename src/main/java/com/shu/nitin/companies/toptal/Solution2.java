package com.shu.nitin.companies.toptal;

import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

	public String solution(String S) {

		if (S.length() > 3) {
			List<Character> list = S.chars().mapToObj(item -> (char) item).filter(ch -> {
				boolean match = true;
				if (ch == ' ' || ch == '-') {
					match = false;
				}
				return match;
			}).collect(Collectors.toList());
			int sequence = 0;
			StringBuilder sbFinal = new StringBuilder();
			for (Character ch : list) {
				if (sequence == 3) {
					sbFinal.append("-").append(ch);
					sequence = 1;
				} else {
					sbFinal.append(ch);
					sequence++;
				}
			}
			if (sbFinal.toString().length() - sbFinal.toString().lastIndexOf("-") == 1) {
				sbFinal.toString();
			}
		}
		return S;
	}

}
