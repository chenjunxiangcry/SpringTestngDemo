package com.example.demo.Learn.LetCode;

import java.util.Arrays;

public class RotateIntArray {
    public class Solution {
        /*
            normal 2b method
         */
        public void rotate(int[] nums, int k) {
            int x = k % (nums.length);
            if (x == 0) {
                return;
            }
            while (x > 0) {
                int tmp = nums[nums.length - 1];
                for (int i = nums.length - 1; i > 0; i--) {
                    nums[i] = nums[i - 1];
                    System.out.println(Arrays.toString(nums));
                }
                nums[0] = tmp;
                System.out.println(Arrays.toString(nums));
                x--;
            }
        }
        public void rotateR(int[] nums, int k) {
            k = k%(nums.length);
            if(k==0){return ;}
            System.out.println(nums.length);
            System.out.println("-----start--1111----");
            reverse(nums,0,nums.length-1);
            System.out.println("-----done--1111----");
            reverse(nums,0,k-1);
            reverse(nums,k,nums.length-1);
            Utils.printArray(nums);
        }

       public void reverse(int[] nums, int start, int end){
            while(start<end){
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
        public void rotateK(int[] nums, int k) {
            int x = k%(nums.length);
            if(x==0){return;}
            int move = nums.length;
            int moveIndex=0;
            int preMoveIndex=0;
            int moveVaule=nums[0];
            while(move>0){
                do{
                    int targetIndex =getTargetIndex(moveIndex,x,nums.length);
                    int tmp = nums[targetIndex];
                    nums[targetIndex] = moveVaule;
                    moveIndex=targetIndex;
                    moveVaule = tmp;
                    move--;
                    System.out.println(String.format("move times: %d , tmp is %d", move,tmp));
                    System.out.println(Arrays.toString(nums));
                }while (moveIndex != preMoveIndex);
                moveIndex++;
                preMoveIndex = moveIndex;
                moveVaule = nums[moveIndex];
            }

        }
        int getTargetIndex(int targetIndex,int k,int length){

            if(targetIndex+k>=length){
                targetIndex = (targetIndex+k)%length;
            }else{
                targetIndex = targetIndex+k;
            }
            return targetIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1,100,3,99};
        RotateIntArray.Solution solution =new RotateIntArray().new Solution();
        solution.rotateR(array,2);

    }
}
