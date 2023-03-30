package com.example.demo.strategy;

public interface PaymentStraegy {

     void createOrder();

     void pay();

     void queryPayOrderStatus();

     Boolean isCurrentStrategy(PaymentEnum paymentEnum);

}
