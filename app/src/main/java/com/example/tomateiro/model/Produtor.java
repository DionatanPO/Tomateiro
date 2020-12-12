package com.example.tomateiro.model;

import java.io.Serializable;

public class Produtor implements Serializable {
    private String nome;

    public Produtor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
