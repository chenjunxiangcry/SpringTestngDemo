package com.example.demo.Learn.LetCode;

public class Utils {

    public static void printArray(int[] nums){
        System.out.print("[");
        for(int k=0;k<nums.length-1;k++){
            System.out.print(nums[k]+",");
        }
        System.out.print(nums[nums.length-1]);
        System.out.print("]");
        System.out.println("");
    }
    public static void printArray(ListNode head){
        System.out.print("[");
        int count =0;
        while(head!=null){
            if(count == 0){
                System.out.print(head.val);
            }else{
                System.out.print(","+head.val);
            }
            count++;
            head=head.next;
        }
        System.out.print("]");
        System.out.println("");
    }
}
