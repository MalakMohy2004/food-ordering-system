package com.internship.foodordering.notification;

import com.internship.foodordering.model.Order;

/**
 * Pillar demonstrated: POLYMORPHISM
 * OrderService calls notify(order) without caring which concrete
 * class handles it — the same call produces different behavior
 * depending on the actual object plugged in at runtime.
 */
public interface Notification {
    void notify(Order order);
}
