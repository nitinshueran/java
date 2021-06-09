package com.shu.nitin.ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> response = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> hash = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (hash.containsKey(nums[j])) {
                    response.add(Arrays.asList(nums[i], nums[hash.get(nums[j])], nums[j]));
                } else {
                    hash.put(target - nums[j], j);
                }
            }
        }
        return response.stream().map(ArrayList::new).collect(Collectors.toList());
    }
}
