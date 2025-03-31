package com.senai.aula.enu;

public enum Setor {
    ENGENHARIA("Engenheiro"),
    SAUDE("Saúde"),
    JURIDICO("Jurídico");

    private String nome;

    Setor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
