package com.example.demo.Learn.LetCode;

public class MaxProfit {

    /*
        买卖股票的最佳时机 只能买卖一次
     */
    public int maxProfit(int[] prices) {
        int  maxProfit = 0;
        int  lowPrice = prices[0];
        for(int i =1; i < prices.length ; i++){
            if(prices[i]-lowPrice>maxProfit){
                maxProfit = prices[i]-lowPrice;
            }else{
                lowPrice = Math.min(prices[i],lowPrice);
            }
        }
        return maxProfit;
    }
    public int maxProfitDuoci(int[] prices) {
        int  maxProfit = 0;
        int  lowPrice = prices[0];
        for(int i =1; i < prices.length ; i++){
            if(prices[i]-lowPrice>maxProfit){
                maxProfit = prices[i]-lowPrice;
            }else{
                lowPrice = Math.min(prices[i],lowPrice);
            }
        }
        return maxProfit;
    }
}
