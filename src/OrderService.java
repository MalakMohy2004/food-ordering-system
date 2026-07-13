package com.internship.foodordering.service;

import com.internship.foodordering.model.Customer;
import com.internship.foodordering.model.MenuItem;
import com.internship.foodordering.model.Order;
import com.internship.foodordering.notification.Notification;
import com.internship.foodordering.payment.PaymentMethod;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * SOLID principle: SINGLE RESPONSIBILITY
 * This class's only job is orchestrating the order workflow: create,
 * add items, checkout. It delegates payment and notification to
 * whatever implementation is handed to it.
 *
 * SOLID principle: DEPENDENCY INVERSION
 * OrderService depends on the PaymentMethod and Notification
 * interfaces, never on a concrete class like CardPayment or
 * EmailNotification. That's what lets checkout() work with ANY
 * payment method or notification channel without being rewritten.
 */
public class OrderService {

    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Order createOrder(Customer customer) {
        if (!customer.hasValidEmail()) {
            throw new IllegalArgumentException("Customer must have a valid email");
        }
        String orderId = "ORD-" + idCounter.getAndIncrement();
        return new Order(orderId, customer);
    }

    public void addItemToOrder(Order order, MenuItem menuItem, int quantity) {
        order.addItem(menuItem, quantity);
    }

    /**
     * Checks out the order: charges the customer via whichever
     * PaymentMethod was injected, then notifies them via whichever
     * Notification channel was injected.
     */
    public void checkout(Order order, PaymentMethod paymentMethod, Notification notification) {
        double total = order.calculateTotal();
        boolean success = paymentMethod.pay(total);
        if (!success) {
            throw new IllegalStateException("Payment failed for order " + order.getId());
        }
        order.markAsPaid();
        notification.notify(order);
    }
}
