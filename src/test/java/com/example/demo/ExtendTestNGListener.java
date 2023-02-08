package com.example.demo;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
public class ExtendTestNGListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("------------------------------");
        System.out.println(Reporter.getOutput(result));

    }
}
