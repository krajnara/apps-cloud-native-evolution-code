package com.example.billing;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * Created by 103209 on 11/09/17.
 */
// @Component
public class HttpBillingClient implements BillingClient {
    private static final Logger LOG = Logger.getLogger(HttpBillingClient.class.getName());

    private RestOperations restTemplate;

    @Autowired
    private RestTemplate rTemplate;

    @Value("${billing.url}")
    private String serviceUrl;

    public HttpBillingClient() {
        this.restTemplate = new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "defaultBillUser")
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

    public void defaultBillUser(String userId, int amount) {
        LOG.info("Billing user failed for user '" + userId + "' with an amount " + amount);
    }
}
