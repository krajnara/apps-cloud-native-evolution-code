package com.example.billing;

import java.io.Serializable;

/**
 * Created by 103209 on 12/09/17.
 */
public class BillingMessage implements Serializable {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int amount;

    public BillingMessage(String userName, int amount) {
        this.userName = userName;
        this.amount = amount;

    }

    public BillingMessage() {}
}
