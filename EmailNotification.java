package com.internship.foodordering.notification;

import com.internship.foodordering.model.Order;

public class EmailNotification implements Notification {

    @Override
    public void notify(Order order) {
        String email = order.getCustomer().getEmail();
        System.out.printf("[Email] Sent order confirmation for #%s to %s%n",
                order.getId(), email);
    }
}
