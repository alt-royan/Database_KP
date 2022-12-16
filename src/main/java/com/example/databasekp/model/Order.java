package com.example.databasekp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Long id;

    private Integer number;

    private Integer deliveryTime;

    private Double totalPrice;

    private Date orderDate;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<Purchase> purchases;
}
