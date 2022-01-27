package com.example.examplemvc.controller;

import com.example.examplemvc.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class OrderController {

    public static Set<Order> orders = new HashSet<>();

    static  {
        orders.add(new Order("iphone", 123));
        orders.add(new Order("book", 321));
        orders.add(new Order("chair", 567));
    }

    private static Set<Order> manageOrders(Order order) {
        if (order != null) orders.add(order);
        return orders;
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orders);
        return "orders_page";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute Order order) {
        System.out.println("order is : " + order);
        manageOrders(order);
        return "redirect:/orders";
    }
}
