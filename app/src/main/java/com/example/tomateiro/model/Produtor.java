package com.example.tomateiro.model;

import java.io.Serializable;

public class Produtor implements Serializable {
	
	private Long id;
    private String nome;
    private String propriedade;
    private String codIdentificacao;
    private String senha;
    private String estado;

    public Produtor() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    public String getCodIdentificacao() {
        return codIdentificacao;
    }

    public void setCodIdentificacao(String codIdentificacao) {
        this.codIdentificacao = codIdentificacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
