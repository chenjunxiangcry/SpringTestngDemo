package com.example.demo.Learn.LetCode;

public class publicSubString {

    public static String subString(String str1,String str2){
        if(null == str1 || null == str2){
            return null;
        }
        String shortstr = "";
        String longstr = "";
        String subString = null;
        if(str2.length()>str1.length()){
            shortstr=str1;
            longstr = str2;
        }else{
            shortstr=str2;
            longstr = str1;
        }
        for(int i=0; i<shortstr.length();i++){
            for(int j=shortstr.length();j>i;j--){
                if(longstr.contains(shortstr.substring(i,j))){
                    String current = shortstr.substring(i,j);
                    if(subString==null || subString.length()<current.length()){
                        subString = current;
                    }
                    break;
                }
            }
        }

        return subString;
    }
    public static void main(String[] args){
        String str1 = "abdefghjjki";
        String str2 = "abcefgghjjki";
        System.out.println(subString(str1,str2));
    }
}
