package com.example.demo.LetCode;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length-1;
        while(L<=R) {
            int mid = L+(R-L)/2;
            if(nums[mid]>target) {
                R=mid-1;
            }
            if(nums[mid]<target ) {
                L=mid+1;
            }
            if(nums[mid]==target) {
                return mid;
            }
        }
        return L;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4,8,9,22,55};
        System.out.println( searchInsert(array,99));
    }
}
