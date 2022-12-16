package com.example.databasekp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Partition {
    @Id
    private Long id;
    private String name;
    private String description;
}
