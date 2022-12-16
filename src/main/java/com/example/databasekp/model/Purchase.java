package com.example.databasekp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Purchase {
    @Id
    private Long id;
    private Integer count;
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;
    @ManyToOne
    private Product product;
}
