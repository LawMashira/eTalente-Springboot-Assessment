package com.enviro.assessment.grad001.lawson_matutu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT_TB")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank(message = "Product name required")
    private String productName;

    private  Double currentBalance;

    @Enumerated(EnumType.STRING)
    private ProductEnumType   productType;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "investor_id")
    private   Investor  name;
}
