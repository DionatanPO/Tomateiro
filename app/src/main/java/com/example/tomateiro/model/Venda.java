package com.example.tomateiro.model;

import java.io.Serializable;
import java.sql.Date;

public class Venda implements Serializable {

    private Long id;
    private String vendaData;
    private int quantidade;
    private String preco;
    private String pesoCaixa;
    private String estado;

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getPesoCaixa() {
        return pesoCaixa;
    }

    public String getVendaData() {
        return vendaData;
    }

    public void setVendaData(String vendaData) {
        this.vendaData = vendaData;
    }

    public void setPesoCaixa(String pesoCaixa) {
        this.pesoCaixa = pesoCaixa;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
