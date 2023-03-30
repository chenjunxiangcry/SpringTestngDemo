package com.example.demo.Concurrent;

import com.example.demo.HttpUtils.HttpInvoker;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class HelloThread implements Runnable{
    @Autowired
    private HttpInvoker httpInvoker;
    public CountDownLatch countDownLatchEnd;
    public CountDownLatch countDownLatchStart;

    public HelloThread(CountDownLatch start, CountDownLatch end){
        countDownLatchStart = start;
        countDownLatchEnd = end;
    }
    public String result;
    @Override
    public void run() {
        try {
            System.out.println("This is prepare");
            countDownLatchStart.await();
            this.result =httpInvoker.postJsonStr("http://182.92.99.17:5000/hello","{\"data\": \"test\"}");
            System.out.println(Thread.currentThread().getName()+"completed");
            countDownLatchEnd.countDown();
        } catch (  InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
