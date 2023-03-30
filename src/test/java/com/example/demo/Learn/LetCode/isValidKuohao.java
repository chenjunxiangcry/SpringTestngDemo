package com.example.demo.Learn.LetCode;

import java.util.HashMap;
import java.util.Stack;

public class isValidKuohao {
    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()||map.get(stack.peek())!=s.charAt(i)){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public static int kuohaodepth(String str){
        int depth=0;
        int maxDepth=0;
        String ss = "()+(())+((())))";
        for(int i=0;i< str.length();i++){
            if(str.charAt(i) == '('){
                depth++;
                maxDepth = Math.max(depth,maxDepth);
            }else if(str.charAt(i)==')'){
                depth--;
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(isValid("{(){[]}}"));
        System.out.println(kuohaodepth("()+(())+((()))"));
    }
}
