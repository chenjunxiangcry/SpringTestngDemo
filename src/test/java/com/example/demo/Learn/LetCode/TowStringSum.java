package com.example.demo.Learn.LetCode;

public class TowStringSum {
        public String addStrings(String num1, String num2) {
            int i = num1.length()-1;
            int j = num2.length()-1;
            int jingwei=0;
            StringBuilder sb = new StringBuilder();
            while(i >=0||j>=0){
                int a=0;
                int b=0;
                if(i>=0){a=num1.charAt(i)-'0';}
                if(j>=0){b=num2.charAt(j)-'0';}
                int tmp =a+b+jingwei;
                jingwei = tmp/10;
                sb.append(tmp%10);
                i--;
                j--;
                System.out.println(sb.toString());

            }
            if(jingwei>0){sb.append(jingwei);}
            System.out.println(sb.reverse().toString());
            return sb.reverse().toString();
    }

    public static void main(String[] args){

            new TowStringSum().addStrings("456","77");
    }
}
