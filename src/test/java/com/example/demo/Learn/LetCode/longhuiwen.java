package com.example.demo.Learn.LetCode;

public class longhuiwen {
        public String longestPalindrome(String s) {
            int max = 0;
            String x = "";
            char[] arr = s.toCharArray();
            for(int i=0;i<s.length()-1;i++){
                System.out.println("*****");

                for(int j=s.length()-1;j>i;j--){
                    System.out.println("&&&&&");
                    if(ishuiwen(arr,i,j)){
                        if(max<j-i+1){
                            max=j-i+1;
                            x="";
                            for(int k=i;k<=j;k++){
                                System.out.println("----");
                                x=x+String.valueOf(arr[k]);
                            }
                        }
                    }
                }
            }
            return x;
        }

        public boolean ishuiwen(char[] arr, int left,int right){
            while(left<right){
                if(arr[left]!=arr[right]){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    public static void main(String[] args) {
        System.out.println(new longhuiwen().longestPalindrome("babad"));
    }

}

