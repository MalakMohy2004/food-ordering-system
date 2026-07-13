package com.internship.foodordering.payment;

public class PaypalPayment implements PaymentMethod {

    private final String accountEmail;

    public PaypalPayment(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public boolean pay(double amount) {
        System.out.printf("Charged $%.2f via PayPal account %s%n", amount, accountEmail);
        return true;
    }

    @Override
    public String getDescription() {
        return "PayPal";
    }
}
