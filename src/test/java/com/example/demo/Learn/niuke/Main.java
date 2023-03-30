package com.example.demo.Learn.niuke;

import com.jayway.jsonpath.internal.filter.ValueNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            List<List<Integer>> rows = yanghuisanjiaobianxing(n);
            System.out.println(rows);
            List<Integer> list = rows.get(n-1);
            boolean exist = false;
            for(int i=0;i<list.size();i++){
                if(list.get(i)%2==0){
                    exist = true;
                    System.out.println(i+1);
                    break;
                }
            }
            if(!exist){
                System.out.print(-1);
            }
            break;
        }
        in.close();

    }

    public static List<List<Integer>> yanghuisanjiaobianxing(int n) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 2*(i+1)-1; j++) {
                if (j == 0 || j == 2*(i+1)-2) {
                    list.add(1);
                }
                else {
                    System.out.println(rows);
                    System.out.println(j+ " i "+i);
                    int value=rows.get(i-1).get(j-1);
                    if(j-2>=0){
                        value+=rows.get(i-1).get(j-2);
                    }
                    if(j<=rows.get(i-1).size()-1){
                        value+=rows.get(i-1).get(j);
                    }
                    list.add(value);
                }
            }
            rows.add(list);
        }
        return rows;
    }
    public static List<List<Integer>> yanghuisanjiao(int n) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    list.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
                }
            }
            rows.add(list);
        }
        return rows;
    }
}