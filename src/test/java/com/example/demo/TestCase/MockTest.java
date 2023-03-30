package com.example.demo.TestCase;

import com.example.demo.HttpUtils.HttpInvoker;
import com.example.demo.Base.BaseTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @Author jxchenac
 * @create 3/23/2021 3:11 PM
 */
@SpringBootTest
public class MockTest extends BaseTestCase {
    @Autowired
    public HttpInvoker httpInvoker;

    @Test(description = "访问百度网站，预期成功")

    public void testAccessBaidu() throws IOException, URISyntaxException {
        String body = httpInvoker.get("https://www.baidu.com", null, null);
        System.out.println(body);
        Reporter.log("This is testcase ,case name is accessBaidu");
        Assert.fail("access baidu fail");
    }

    @Test
    public void testAccessSina() throws IOException, URISyntaxException {
        String body = httpInvoker.get("https://www.sina.com", null, null);
        System.out.println(body);

    }

    @Test
    public void testAccessTencent() throws IOException, URISyntaxException {
        String body = httpInvoker.get("https://www.qq.com", null, null);
        System.out.println(body);

    }
}
