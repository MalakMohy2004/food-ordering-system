package com.internship.foodordering.payment;

public class CardPayment implements PaymentMethod {

    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        String lastFour = cardNumber.length() >= 4
                ? cardNumber.substring(cardNumber.length() - 4)
                : cardNumber;
        System.out.printf("Charged $%.2f to card ending in %s%n", amount, lastFour);
        return true;
    }

    @Override
    public String getDescription() {
        return "Card";
    }
}
