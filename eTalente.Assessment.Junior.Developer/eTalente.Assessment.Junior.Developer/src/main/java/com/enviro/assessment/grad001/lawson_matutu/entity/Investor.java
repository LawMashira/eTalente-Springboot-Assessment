package com.enviro.assessment.grad001.lawson_matutu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "INVESTOR_TB")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Investor required")
    private String investorName;

    @NotBlank(message = "Address required")
    private  String address;
@NotBlank
@Pattern(regexp = "^\\d{10}$",message = "Invalid phone number")

    private String contactNumber;
    //private  String productInvested;
    /*@OneToMany(  cascade = CascadeType.ALL)
    @JoinColumn(name = "investor_Id",referencedColumnName = "id")*/

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "name")
    private List<Product > productList;
}
