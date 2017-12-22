package com.example.billing;

import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class BillingInterface {
    private final RestOperations restTemplate;
    private final String serviceEndpoint;

    public BillingInterface(String serviceEndpoint, RestOperations restTemplate) {
        this.restTemplate = restTemplate;
        this.serviceEndpoint = serviceEndpoint;
    }

    public void billUser(String userId, int amount) {

        System.out.println("Value of billing end pointtttttttttttt:" + serviceEndpoint);
        restTemplate.postForEntity(serviceEndpoint + "/reocurringPayment", amount, String.class);
    }
}
