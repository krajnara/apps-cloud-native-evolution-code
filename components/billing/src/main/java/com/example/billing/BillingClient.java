package com.example.billing;

/**
 * Created by 103209 on 11/09/17.
 */
public interface BillingClient {
    public void billUser(String userId, int amount);
}
