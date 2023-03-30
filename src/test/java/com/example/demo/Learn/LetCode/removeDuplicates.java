package com.example.demo.Learn.LetCode;

import java.util.Arrays;

public class removeDuplicates {

    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length<2){return 0;}
        int low=0;
        for(int i=1; i<nums.length;i++){
            if(nums[i]!=nums[low]){
                nums[++low]=nums[i];
            }
            System.out.println(Arrays.toString(nums));

        }
        System.out.println(Arrays.toString(nums));
        return low+1;
    }
    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
                if(nums[i]!=nums[index-2]){
                    nums[index]=nums[i];
                    index++;
                }
        }
        Utils.printArray(nums);
        return index++;

    }

        public static int removeDuplicatesCommon(int[] nums) {
            return process(nums, 2);
        }
       public static int process(int[] nums, int k) {
            int u = 0;
            for (int x : nums) {
                if (u < k || nums[u - k] != x) nums[u++] = x;
            }
            System.out.println(Arrays.toString(nums));
            return u;
        }


    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,1,1,1,2,2,2,2,2,3,3};
        System.out.println(removeDuplicates2(array));
        int[] array1 = new int[]{0,0,1,1,1,1,2,2,2,2,2,3,3};

        System.out.println(process(array1,2));
    }
}
