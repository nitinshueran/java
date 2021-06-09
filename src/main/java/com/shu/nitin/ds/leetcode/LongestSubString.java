package com.shu.nitin.ds.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(new LongestSubString().lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s))
            return 0;
        if (s.length() == 1)
            return 1;
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            Map<Character, Integer> hash = new HashMap<>();
            hash.put(chars[i], 1);
            int tmpMax = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (hash.containsKey(chars[j])) {
                    if (tmpMax > max)
                        max = tmpMax;
                    break;
                } else {
                    hash.put(chars[j], 1);
                    tmpMax++;
                    if (tmpMax > max)
                        max = tmpMax;
                }
            }
        }
        return max;
    }
}
