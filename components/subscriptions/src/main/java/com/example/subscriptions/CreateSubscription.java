package com.example.subscriptions;

import com.example.billing.ChargeUser;
import com.example.email.SendEmail;
import com.example.billing.BillingInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateSubscription {

    //private final ChargeUser chargeUser;

    private final BillingInterface billingInterface;  //Discuss with Rangaa on autowireeeeeeeeee
    private final SendEmail emailSender;
    private final SubscriptionRepository subscriptions;

    public CreateSubscription(
     //       ChargeUser chargeUser,
     BillingInterface billingInterface_In,
            SendEmail emailSender, SubscriptionRepository subscriptions) {
        //this.chargeUser = chargeUser;
        this.billingInterface = billingInterface_In;
        this.emailSender = emailSender;
        this.subscriptions = subscriptions;
    }

    public void run(String userId, String packageId) {
        subscriptions.create(new Subscription(userId, packageId));
        //chargeUser.run(userId, 100);
        billingInterface.billUser(userId, 100);
        emailSender.run("me@example.com", "Subscription Created", "Some email body");
    }
}
