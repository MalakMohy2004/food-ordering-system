package com.internship.foodordering.model;

/**
 * Represents a single item available on the restaurant menu.
 *
 * Pillar demonstrated: ENCAPSULATION
 * Fields are private; the outside world can only read them through
 * getters. There is no public setter for price, so once a MenuItem
 * is created its price cannot be silently changed by unrelated code.
 */
public class MenuItem {

    private final String id;
    private final String name;
    private final double price;

    public MenuItem(String id, String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + String.format("%.2f", price) + ")";
    }
}
