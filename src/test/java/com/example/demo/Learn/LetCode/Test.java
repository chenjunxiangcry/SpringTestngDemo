package com.example.demo.Learn.LetCode;

import java.util.HashMap;

public class Test {


    public static void count(String str){
        String[] arr = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        /**
         *  #/bin/sh
         *  if [ file -e ] then
         *     tailf -n 1 file |awk -F ' ' '{print $10}'
         *
         * student userid subject score
         * 统计成绩60分一下的比例 60-80 比例 80-100 比例
         *
         * declare count60yixia=0 ;
         * declare total = 0;
         * total = select count(1) from student where subject = "shuxue";
         * count69yixia=select count(1) from student where subject = "shuxue"  and score < 60 ;
         *
         * declare rate60yixia = 0;
         * rate60yixia =
         *
         *
         *
         *
         *
         *
         */

    }

    public static void xiangjiao(ListNode first, ListNode second){



    }

}
