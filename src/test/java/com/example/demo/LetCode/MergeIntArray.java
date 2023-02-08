package com.example.demo.LetCode;

public class MergeIntArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int start=0;
        for(int i=0;i<n;i++){
            for(int j=start; j<m+start;j++){
                if(nums2[i]>nums1[i]){
                    continue;
                }else if (nums2[i]<= nums1[j] && nums2[i] >=nums1[j+1]){
                    for(int k=0;k<m-j;j++){
                        //int tmp = nums1[]
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
}
