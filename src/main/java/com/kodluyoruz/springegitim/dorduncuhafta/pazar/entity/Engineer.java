package com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ENGINEER")
@Data
public class Engineer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column
    private String tckn;

}
