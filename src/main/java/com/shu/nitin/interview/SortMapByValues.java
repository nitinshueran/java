package com.shu.nitin.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValues {

	public static void main(String[] args) {

		Map<String, Integer> mapToSort = new HashMap<>();
		mapToSort.put("Nitin", 28);
		mapToSort.put("Nitesh", 25);

		Set<Entry<String, Integer>> mapEntry = mapToSort.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(mapEntry);

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		mapToSort.entrySet().stream().sorted(
				(Entry<String, Integer> o1, Entry<String, Integer> o2) -> o1.getValue().compareTo(o2.getValue()));
	}

}
