package com.example.demo.Learn.LetCode;

public class jiuwufenwei {

    public static int fenwei(int[] nums){

        if(nums == null || nums.length<100){
            return -1;
        }
        int index = (int)(nums.length*0.95);
        for(int i=0;i<=nums.length-index;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    int tmp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=tmp;
                }
            }
        }
        Utils.printArray(nums);
        return nums[nums.length-index];
    }
    public static void main(String[] args){
        int[] nums = new int[100];
        for(int i=0;i<nums.length;i++){
            nums[i]=1+i;
        }
        System.out.println(fenwei(nums));

    }

}
