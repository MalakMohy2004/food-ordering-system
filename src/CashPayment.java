package com.internship.foodordering.payment;

public class CashPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.printf("Collected $%.2f in cash on delivery%n", amount);
        return true;
    }

    @Override
    public String getDescription() {
        return "Cash on delivery";
    }
}
