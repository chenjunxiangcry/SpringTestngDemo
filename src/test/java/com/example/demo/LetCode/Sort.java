package com.example.demo.LetCode;

import java.util.Arrays;

public class Sort {

    //选择排序 每一次遍历找到最大值的下标，再将最大值换到前面位置
    public static int[] selectionSort(int[] nums){
        if(nums == null || nums.length==0){
            System.out.println("length is zero or is null");
            return nums;
        }
        for(int i=0; i< nums.length; i++) {
            int max = nums[i];
            int index = i;
            for(int j=i+1; j<nums.length;j++){
                if(nums[j]>max){
                    max=nums[j];
                    index=j;
                }
            }
            nums[index] = nums[i];
            nums[i] = max;
            Utils.printArray(nums);
        }
        return nums;
    }

    //选择排序 一次遍历找到最大和最小值
    public static int[] selectionSort1(int[] nums){
        if(nums == null || nums.length==0){
            System.out.println("length is zero or is null");
            return nums;
        }
        for(int i=0; i< nums.length; i++) {
            int maxIndex = i;
            int minIndex = i;
            for(int j=i+1; j<nums.length;j++){
                if(nums[j]>nums[maxIndex]){
                    maxIndex=j;
                }
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            int tmp = nums[maxIndex];
            nums[maxIndex] = nums[i];
            nums[i] = tmp;
            Utils.printArray(nums);
        }
        return nums;
    }
    //每一次的排序过程都是将待排序列中最大的元素放到最下方
    // （通过所有待排元素的两两比较实现的，也就是说一次的排序过程需要比较所有的元素，虽然这个过程不一定发生交换)
    ////第一张牌可以看成有序，后面n-1个元素都需要插入
    public static int[] bubbleSort(int[] nums){
        for(int i=0; i< nums.length-1; i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                System.out.println("i is "+i + " j is "+j);
                Utils.printArray(nums);

            }
            //Utils.printArray(nums);
        }
        return  nums;
    }
    //每一步将一个元素插入到合适的位置
    // (通过将当前的待排元素和之前排好序的有序序列相比较，但是这个比较的过程并不是需要每一个元素都比较，
    // 一旦发现当前待插入元素比有序序列某一个数大就不需要和前面的数比了）

    public static int[] insertSort(int[] nums){
        for(int i=1; i< nums.length; i++){
            for(int j=i; j>0;j--){
                if(nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=tmp;
                }
            }
            Utils.printArray(nums);
        }
        return  nums;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1000,9, 3, 4,5,7,6,6,100};
        Utils.printArray(insertSort(array));
    }
}
