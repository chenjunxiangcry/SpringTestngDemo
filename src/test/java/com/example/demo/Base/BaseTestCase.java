package com.example.demo.Base;

import com.example.demo.DemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @Author jxchenac
 * @create 3/23/2021 11:30 AM
 */

@SpringBootTest(classes = {DemoApplication.class })
public class BaseTestCase extends AbstractTestNGSpringContextTests {
    @BeforeMethod
    protected void beforeTestCase() { System.out.println("[" + this.getClass().getSimpleName() + " start to execute   ] ");
    }

    @AfterMethod
    protected void afterTestCase() {
        System.out.println("[" + this.getClass().getSimpleName() + " execute end   ] ");
    }
}
