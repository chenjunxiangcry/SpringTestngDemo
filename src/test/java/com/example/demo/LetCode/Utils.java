package com.example.demo.LetCode;

public class Utils {

    public static void printArray(int[] nums){
        System.out.print("[ ");
        for(int k=0;k<nums.length-1;k++){
            System.out.print(nums[k]+",");
        }
        System.out.print(nums[nums.length-1]);
        System.out.print(" ]");
        System.out.println("");
    }
}
