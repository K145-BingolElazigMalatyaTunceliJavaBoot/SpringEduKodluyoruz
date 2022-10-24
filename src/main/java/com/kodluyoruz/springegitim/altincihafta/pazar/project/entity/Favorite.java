package com.kodluyoruz.springegitim.altincihafta.pazar.project.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


}
