package com.internship.foodordering;

import com.internship.foodordering.model.Customer;
import com.internship.foodordering.model.MenuItem;
import com.internship.foodordering.model.Order;
import com.internship.foodordering.notification.EmailNotification;
import com.internship.foodordering.payment.CardPayment;
import com.internship.foodordering.service.MenuService;
import com.internship.foodordering.service.OrderService;

/**
 * Demo entry point covering every requirement from the exercise slide:
 *   - View menu items
 *   - Add items to an order
 *   - Choose payment method
 *   - Calculate total price
 *   - Print order summary
 *   - Send notification to customer
 */
public class Main {

    public static void main(String[] args) {
        // Set up the menu
        MenuService menuService = new MenuService();
        menuService.addMenuItem(new MenuItem("M1", "Margherita Pizza", 8.99));
        menuService.addMenuItem(new MenuItem("M2", "Cheeseburger", 6.50));
        menuService.addMenuItem(new MenuItem("M3", "Fries", 2.99));
        menuService.addMenuItem(new MenuItem("M4", "Soda", 1.50));

        System.out.println("=== Menu ===");
        menuService.viewMenu().forEach(item -> System.out.println("  " + item));

        // Create a customer and an order
        Customer customer = new Customer("Samir Mohammed", "samir@example.com");
        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(customer);

        // Add items to the order
        orderService.addItemToOrder(order, menuService.findById("M1").get(), 1);
        orderService.addItemToOrder(order, menuService.findById("M3").get(), 2);
        orderService.addItemToOrder(order, menuService.findById("M4").get(), 1);

        // Choose payment method (any PaymentMethod implementation works here —
        // swap this for CashPayment or PaypalPayment with no other code changes)
        orderService.checkout(order, new CardPayment("4111111111111234"), new EmailNotification());

        // Print order summary
        System.out.println("\n=== Order Summary ===");
        System.out.println(order.printSummary());
    }
}
