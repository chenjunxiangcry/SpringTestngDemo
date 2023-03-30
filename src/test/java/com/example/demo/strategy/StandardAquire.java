package com.example.demo.strategy;

import org.springframework.stereotype.Component;

@Component("StandardAquire")
public class StandardAquire implements PaymentStraegy{
    @Override
    public void createOrder() {
        System.out.println("this is StandardAquire createOrder");

    }

    @Override
    public void pay() {
        System.out.println("this is StandardAquire Pay");

    }

    @Override
    public void queryPayOrderStatus() {
        System.out.println("this is StandardAquire queryOrder");

    }
    @Override
    public Boolean isCurrentStrategy(PaymentEnum paymentEnum) {
        if(paymentEnum.equals(PaymentEnum.StandardAquire)){
            return true;
        }
        return false;
    }
}
