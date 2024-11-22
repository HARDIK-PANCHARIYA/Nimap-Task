package com.core.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    @NotNull
    private String pName;

    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // No-args constructor
    public Product() {
    }

    // Constructor with arguments
    public Product(String pName, double price, Category category) {
        this.pName = pName;
        this.price = price;
        this.category = category;
    }
}
