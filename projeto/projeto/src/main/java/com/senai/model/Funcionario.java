package com.senai.model;

import jakarta.persistence.*;


@Entity
@Table("tab_funcionario")

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String matricula;
    private String email;





}
