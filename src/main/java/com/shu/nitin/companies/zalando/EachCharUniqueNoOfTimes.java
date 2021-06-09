package com.shu.nitin.companies.zalando;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class EachCharUniqueNoOfTimes {

    public static void main(String[] args) {
        String s = "aaaabbbbb";
        System.out.println(noOfDeletion(s));
    }

    private static int noOfDeletion(String s) {
        int i = 0;
        Map<Character, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
        while (i < s.length()) {
            if (hash.containsKey(s.charAt(i)))
                hash.put(s.charAt(i), hash.get(s.charAt(i)) + 1);
            else
                hash.put(s.charAt(i), 1);
            i++;
        }
        for (Entry<Character, Integer> entry : hash.entrySet()) {
            pq.add(entry.getValue());
        }
        int minDel = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            if (!pq.isEmpty() && val == pq.peek()) {
                minDel++;
                pq.add(val - 1);
            }
        }
        return minDel;
    }

}
