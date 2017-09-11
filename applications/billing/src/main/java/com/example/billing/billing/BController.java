package com.example.billing.billing;

import com.example.payments.Gateway;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 103209 on 11/09/17.
 */
@RestController
public class BController {

    private Gateway paymentGateway;

    public BController(Gateway gateway) {
        this.paymentGateway = gateway;
    }

    @RequestMapping(value = "/reoccurringPayment", method = RequestMethod.POST)
    public ResponseEntity<String> reoccurringPayment(@RequestBody String param) {

        HttpHeaders response = new HttpHeaders();
        response.add("content-type", MediaType.APPLICATION_JSON.toString());

        System.out.println("**** Parameter value obtained " + param);
        boolean pay = paymentGateway.createReocurringPayment(Integer.valueOf(param));
        if(pay) {
            return new ResponseEntity<String>("{errors: []}", response, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>("{errors: ['Invalid Request', 'Re-submit request']}", response, HttpStatus.BAD_REQUEST);
        }
    }

}
