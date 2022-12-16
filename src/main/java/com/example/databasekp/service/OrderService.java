package com.example.databasekp.service;

import com.example.databasekp.model.Order;
import com.example.databasekp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(Long id) {
        return repository.findById(id).get();
    }

    public void save(Order order) {
        repository.save(order);
    }
}
