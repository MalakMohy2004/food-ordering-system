package com.internship.foodordering.payment;

/**
 * Pillar demonstrated: ABSTRACTION
 * Callers only need to know "something can charge(amount)". They never
 * need to know whether that means calling Stripe, PayPal, or handling cash.
 *
 * SOLID principle: OPEN/CLOSED
 * New payment types are added by writing a new class that implements
 * this interface — never by editing existing payment code.
 */
public interface PaymentMethod {
    boolean pay(double amount);

    String getDescription();
}
