package com.example.billing.billing;

import com.example.billing.BillingMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by 103209 on 12/09/17.
 */
public class BillingConsumer {

    @RabbitListener(queues = "ums-billing-queue")
    public void process(BillingMessage msg) {

        System.out.println(">>>>>>  User ID : " + msg.getUserName() + ", Amount : " + msg.getAmount());
    }
}
