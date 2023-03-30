package com.example.demo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestPayment {

    @Autowired
    List<PaymentStraegy> paymentStraegyList;

    public PaymentStraegy getPaymentStragagy(PaymentEnum paymentEnum) {
        PaymentStraegy paymentStraegy =this.paymentStraegyList.stream().filter(l->l.isCurrentStrategy(paymentEnum)).findFirst().orElse(null);
        return paymentStraegy;
    }
    public  void createOrder(PaymentStraegy paymentStraegy){
        paymentStraegy.createOrder();
        paymentStraegy.pay();
        paymentStraegy.queryPayOrderStatus();

    }

    public static void main(String[] args){

    }
}
