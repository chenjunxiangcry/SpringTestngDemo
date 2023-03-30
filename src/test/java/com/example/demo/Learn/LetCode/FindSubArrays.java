package com.example.demo.Learn.LetCode;

import java.util.HashSet;

public class FindSubArrays {
        public boolean findSubarrays(int[] nums) {
            if(nums == null || nums.length<3){return false;}
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length-1; i++){
                if(set.contains(nums[i]+nums[i+1])){
                    return true;
                }else{
                    set.add(nums[i]+nums[i+1]);
                }
            }
            return false;
        }
}
