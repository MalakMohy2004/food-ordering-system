package com.internship.foodordering.notification;

import com.internship.foodordering.model.Order;

public class SmsNotification implements Notification {

    @Override
    public void notify(Order order) {
        System.out.printf("[SMS] Sent order confirmation for #%s to %s%n",
                order.getId(), order.getCustomer().getName());
    }
}
