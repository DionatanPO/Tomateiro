package com.example.tomateiro.model;

import java.io.Serializable;
import java.sql.Date;

public class Venda implements Serializable {
    private Date vendaData;
    private int quantidade;
    private String preco;
    private String pesoCaixa;

    public Venda() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getPesoCaixa() {
        return pesoCaixa;
    }

    public Date getVendaData() {
        return vendaData;
    }

    public void setVendaData(Date vendaData) {
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
