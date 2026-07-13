package com.internship.foodordering.service;

import com.internship.foodordering.model.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * SOLID principle: SINGLE RESPONSIBILITY
 * This class's only job is knowing what's on the menu. It does not
 * know about orders, payments, or notifications.
 */
public class MenuService {

    private final List<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public List<MenuItem> viewMenu() {
        return Collections.unmodifiableList(menuItems);
    }

    public Optional<MenuItem> findById(String id) {
        return menuItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
