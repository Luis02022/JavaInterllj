package com.senai.aula.enu;

public enum Sexo {
    MASCULINO("masculino"),
    FEMININO("feminino");

    private String text;

    Sexo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
