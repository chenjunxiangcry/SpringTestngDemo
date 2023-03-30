package com.example.demo.Concurrent;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DemoConcurrent {

    public static void main(String[] args){
        ExecutorService executors = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatchEnd = new CountDownLatch(10);
        CountDownLatch countDownLatchStart = new CountDownLatch(1);
        for(int i=0;i<10;i++){
            HelloThread helloThread = new HelloThread(countDownLatchStart,countDownLatchEnd);
            executors.submit(helloThread);
        }
        try {
            countDownLatchStart.countDown();
            long start = System.currentTimeMillis();
            countDownLatchEnd.await();
            long end =System.currentTimeMillis();
            System.out.println("cost time is "+(end-start));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executors.shutdown();
        System.out.println("main finished");
    }


}
