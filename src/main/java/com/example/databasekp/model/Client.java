package com.example.databasekp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Client {
    @Id
    private Long id;

    private String fullName;
    private String phone;
    @Column(name = "e-mail")
    private String email;
    private String address;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}
