package com.example.demo.Learn.LetCode;

public class MergeIntArray {
    public static void mergeNewArray(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int i=0;
        int j=0;
        int k =0;
        while(i<n && j<m){
            if(nums2[i]<=nums1[j]){
                arr[k] = nums2[i];
                i++;
            }else{
                arr[k] = nums1[j];
                j++;
            }
            k++;
        }
        while(i<n){
            arr[k++] = nums2[i++];
        }
        while(j<m){
            arr[k++] = nums1[j++];

        }
        Utils.printArray(arr);
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3,4,9,99,0,0,0};
        int[] nums2 = new int[]{0, 2, 6};
        merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+ i] = nums2[i];
        }
        int left = 0;
        int right = m - 1;
        for (int k = 0; k < n; k++) {
            int tmp = nums1[m+n-1];
            int insertIndex = findIndex(nums1,nums1[m+n-1],left,right);
            for(int i = m+n-1; i>insertIndex;i--){
                nums1[i]=nums1[i-1];
            }
            nums1[insertIndex] = tmp;
        }
    }
    public static int findIndex(int[] nums,int val, int left, int right){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }


}
