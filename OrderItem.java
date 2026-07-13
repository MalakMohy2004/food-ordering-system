package com.internship.foodordering.model;

/**
 * A line item inside an order: a MenuItem plus the quantity ordered.
 *
 * Pillar demonstrated: COMPOSITION (strong HAS-A relationship)
 * An OrderItem cannot exist meaningfully without a MenuItem, but it is
 * still its own object with its own behavior (calculating a subtotal).
 */
public class OrderItem {

    private final MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public double getSubtotal() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + "x " + menuItem.getName() +
                " = $" + String.format("%.2f", getSubtotal());
    }
}
