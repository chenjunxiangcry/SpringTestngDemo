package com.example.demo.LetCode;

public class MoveZeroes {
        public static void moveZeroes(int[] nums) {
            int index=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    int tmp=nums[index];
                    nums[index]=nums[i];
                    nums[i]=tmp;
                    index++;
                }
            }
            for(int k=0;k<nums.length;k++){
                System.out.print(nums[k]+",");
            }
            System.out.println("");
        }

    public static void main(String[] args) {
        int[] array = new int[]{0,0,0,0,0,12,0, 3, 4};
        moveZeroes(array);
    }
}
