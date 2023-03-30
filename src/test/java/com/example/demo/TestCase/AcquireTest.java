package com.example.demo.TestCase;

import com.example.demo.Base.BaseTestCase;
import com.example.demo.strategy.PaymentEnum;
import com.example.demo.strategy.PaymentStraegy;
import com.example.demo.strategy.TestAcquire;
import com.example.demo.strategy.TestPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;


@SpringBootTest
public class AcquireTest extends BaseTestCase {

    @Autowired
    TestPayment testPayment;

    @Autowired
    TestAcquire testAcquire;

    @Test(description = "testStandardAcquire")
    public void testStandardAcquire() throws IOException, URISyntaxException {
        PaymentStraegy paymentStraegy = testPayment.getPaymentStragagy(PaymentEnum.StandardAquire);
        testPayment.createOrder(paymentStraegy);
        testAcquire.test();
    }

    @Test(description = "testAgreementAquire")
    public void testAgreementAquire() throws IOException, URISyntaxException {
        PaymentStraegy paymentStraegy = testPayment.getPaymentStragagy(PaymentEnum.AgreementAquire);
        paymentStraegy.createOrder();
        paymentStraegy.pay();
        paymentStraegy.queryPayOrderStatus();
    }
}
