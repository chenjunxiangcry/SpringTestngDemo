package com.example.demo.Learn.LetCode;

import java.util.ArrayList;
import java.util.List;

public class MinCha {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            int minCha = Integer.MAX_VALUE;

            List<List<Integer>> ans = new ArrayList<>();

            for(int i=0;i<arr.length-1;i++){
                for(int j=i+1;j<arr.length;j++){
                    int cha = Math.abs(arr[j]-arr[i]);
                    if(cha<minCha){
                        minCha = cha;
                        ans.clear();
                        List<Integer> res = new ArrayList<>();
                        res.add(Math.min(arr[j],arr[i]));
                        res.add(Math.max(arr[j],arr[i]));
                        ans.add(res);
                    }
                    if(cha==minCha){
                        List<Integer> res = new ArrayList<>();
                        res.add(Math.min(arr[j],arr[i]));
                        res.add(Math.max(arr[j],arr[i]));
                        ans.add(res);
                    }
                }
            }
            return ans;
        }

}
