package com.example.demo.Learn.LetCode;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack ;
    private Stack<Integer> minStack;

    public MinStack(){
        this.minStack = new Stack<>();
        this.stack = new Stack<>();
    }
    public void push(int val){
        if(minStack.isEmpty()){
            this.minStack.push(val);
        }else{
            if(minStack.peek()>val){
                this.minStack.push(val);
            }
        }
        stack.push(val);

    }
    public void pop(){
        int x = stack.pop();
        if(minStack.peek().equals(x)){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return this.minStack.peek();
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());



    }
}
