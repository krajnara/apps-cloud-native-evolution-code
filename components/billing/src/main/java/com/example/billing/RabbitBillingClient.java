package com.example.billing;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 103209 on 12/09/17.
 */
@Component
public class RabbitBillingClient implements BillingClient {
    @Autowired
    private RabbitTemplate template;

//    public RabbitBillingClient(RabbitTemplate template) {
//        this.template = template;
//    }

    @Override
    public void billUser(String username, int amount) {

        System.out.println("Sending message to the Queue...");

        BillingMessage msg = new BillingMessage(username, amount);
        try {
            template.convertAndSend(msg);
        }
        catch(Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
