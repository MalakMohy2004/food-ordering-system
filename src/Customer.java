package com.internship.foodordering.model;

/**
 * Represents the customer placing the order.
 *
 * Pillar demonstrated: ENCAPSULATION
 * hasValidEmail() enforces a rule right next to the data it protects,
 * exactly as shown in the "OOP Idea" slide of the session.
 */
public class Customer {

    private final String name;
    private final String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean hasValidEmail() {
        return email != null && email.contains("@");
    }
}
