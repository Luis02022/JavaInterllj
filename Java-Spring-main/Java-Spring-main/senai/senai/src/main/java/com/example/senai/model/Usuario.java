package com.example.senai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;
    
    @Column(nullable = false)
    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Deve ser um Email válido.")
    private String email;
    
    @Column(nullable = false)
    @NotBlank(message = "Senha é obrigatória.")
    @Size(min=3,message = "A senha deve ter no minímo 3 caracteres.")
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, @NotBlank(message = "Nome é obrigatório.") String nome,
            @NotBlank(message = "Email é obrigatório.") @Email(message = "Deve ser um Email válido.") String email,
            @NotBlank(message = "Senha é obrigatória.") @Size(min = 3, message = "A senha deve ter no minímo 3 caracteres.") String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
    }

    
}
