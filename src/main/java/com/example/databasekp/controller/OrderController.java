package com.example.databasekp.controller;

import com.example.databasekp.model.Client;
import com.example.databasekp.model.Order;
import com.example.databasekp.service.ClientService;
import com.example.databasekp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;

    @GetMapping("/order")
    public String clients(Model model) {
        var orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/order")
    public String saveOrder(@RequestParam String number,
                             @RequestParam String deliveryTime,
                             @RequestParam String clientId,
                             @RequestParam String id) {
        var order = new Order();
        order.setId(Long.parseLong(id));
        order.setClient(clientService.getById(Long.parseLong(clientId)));
        order.setOrderDate(new Date());
        order.setNumber(Integer.parseInt(number));
        order.setDeliveryTime(Integer.parseInt(deliveryTime));
        order.setTotalPrice(0d);
        orderService.save(order);
        return "redirect:/order";
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable Long id, Model model) {
        var order = orderService.getById(id);
        model.addAttribute("order", order);
        return "orderPage";
    }
}