package com.example.payments;

import org.springframework.stereotype.Component;

@Component
public class RecurlyGateway implements Gateway {
    public boolean createReocurringPayment(int paymentMonthlyAmount){
        return true;
    }
}
