package com.example.databasekp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {
    @Id
    private Long id;

    private String title;

    private Integer amount;

    private Double price;

    private String description;

    @ManyToMany
    @JoinTable(name = "product_partition",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "partition_id")
    )
    private List<Partition> partitions;

}
