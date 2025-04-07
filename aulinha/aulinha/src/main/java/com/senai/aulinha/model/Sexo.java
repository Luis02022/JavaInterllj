package com.senai.aulinha.model;

public enum Sexo {
    MASCULINO ("Masculino"),
    FEMININO  ("Feminino");

    private String text;

    Sexo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
