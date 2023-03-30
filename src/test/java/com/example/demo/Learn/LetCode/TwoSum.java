package com.example.demo.Learn.LetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashmap.containsKey(target - nums[i])) {
                    return new int[]{ hashmap.get(target - nums[i]),i};
                }
                hashmap.put(nums[i], i);
            }
            return null;
        }
    public static void main(String[] args) {
        int[] array = new int[]{3, 3, 4};
        //System.out.println(twoSum(array, 6));
        for (int i:
             twoSum(array,6)) {
            System.out.print(i+",");
        }
    }
}
