package com.internship.foodordering.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a customer's order: the items chosen, and the running total.
 *
 * Pillars demonstrated:
 * - ENCAPSULATION: the item list is private; callers add items only
 *   through addItem(), never by reaching into the list directly.
 * - COMPOSITION: an Order "owns" its OrderItems. If the Order is
 *   discarded, its items go with it (strong HAS-A).
 * - ASSOCIATION: an Order "uses" a Customer, but the Customer exists
 *   independently of any single order (weaker relationship).
 */
public class Order {

    private final String id;
    private final Customer customer;
    private final List<OrderItem> items = new ArrayList<>();
    private boolean paid = false;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    /** Returns a read-only view so outside code can't mutate the internal list. */
    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(MenuItem menuItem, int quantity) {
        for (OrderItem existing : items) {
            if (existing.getMenuItem().getId().equals(menuItem.getId())) {
                existing.increaseQuantity(quantity);
                return;
            }
        }
        items.add(new OrderItem(menuItem, quantity));
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void markAsPaid() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot pay for an empty order");
        }
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public String printSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(id).append(" for ").append(customer.getName()).append("\n");
        for (OrderItem item : items) {
            sb.append("  - ").append(item).append("\n");
        }
        sb.append(String.format("Total: $%.2f%n", calculateTotal()));
        sb.append("Payment status: ").append(paid ? "PAID" : "PENDING");
        return sb.toString();
    }
}
