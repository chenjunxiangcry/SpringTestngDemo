package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class AgreementAquire implements  PaymentStraegy{
    @Override
    public void createOrder() {
        System.out.println("this is AgreementAquire createOrder");
    }

    @Override
    public void pay() {
        System.out.println("this is AgreementAquire Pay");

    }

    @Override
    public void queryPayOrderStatus() {
        System.out.println("this is AgreementAquire queryOder");

    }

    @Override
    public Boolean isCurrentStrategy(PaymentEnum paymentEnum) {
        if(paymentEnum.equals(PaymentEnum.AgreementAquire)){
            return true;
        }
        return false;
    }
}
