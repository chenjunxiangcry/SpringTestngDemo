package com.example.demo.strategy;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestAcquire {
    @Resource(type=AgreementAquire.class)
    final PaymentStraegy standardAquire;

    public TestAcquire(PaymentStraegy standardAquire) {
        this.standardAquire = standardAquire;
    }

    public void test(){
        System.out.println("this is testacquire test");
        standardAquire.queryPayOrderStatus();
    }
}
