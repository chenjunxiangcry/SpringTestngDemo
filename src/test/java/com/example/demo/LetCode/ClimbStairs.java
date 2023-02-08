package com.example.demo.LetCode;

import com.fasterxml.jackson.core.JsonEncoding;

public class ClimbStairs {
    // 递归算法
    public static int climbstairs(int n){
        if(n<=2){return n;}
        return climbstairs(n-1)+climbstairs(n-2);
    }

    //滚动数组方法
    public static int climbstairs1(int n){
        if(n<=2){return n;}
        int result=0;
        int first=1;
        int second=2;
        for(int i=3; i<=n; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;

    }

    //动态规划
    public static int climbstairs2(int n){
        if(n<=2){return n;}
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=n ;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
