package com.example.billing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * Created by 103209 on 11/09/17.
 */
@Component
public class BillingClient {
    private RestOperations restTemplate;

    @Autowired
    private RestTemplate rTemplate;

    @Value("${billing.url}")
    private String serviceUrl;

    public BillingClient() {
        this.restTemplate = new RestTemplate();
    }

    public void billUser(String userId, int amount) {
        /*
        System.out.println("**** Calling " + serviceUrl);
        try {
            URI uri = new URI(serviceUrl + "/reoccurringPayment");
            System.out.println("Coded URI : " + uri.toString());

            restTemplate.postForEntity(uri, amount, String.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
         */

        rTemplate.postForObject("http://ums-billing" + "/reoccurringPayment", amount, String.class);

    }
}
