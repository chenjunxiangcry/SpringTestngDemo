package com.example.demo.Learn.LetCode;

import java.util.HashSet;

public class longSubString {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 1;
        for( ; left< s.length();left++){
            int right = left+1;
            HashSet<String> set = new HashSet<>();
            set.add(String.valueOf(s.charAt(left)));
            System.out.println(s.charAt(left)+"    ---");
            while(right<s.length()){
                if(set.contains(String.valueOf(s.charAt(right)))){
                    max = Math.max(set.size(),max);
                    System.out.println(s.subSequence(left,right)+" hhh "+max);
                    break;
                }else{
                    set.add(String.valueOf(s.charAt(right)));
                    right++;
                }

            }
            if(right == s.length()){
                max = Math.max(right-left,max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
       System.out.println(lengthOfLongestSubstring("au"));
    }
}