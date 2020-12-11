package com.example.tomateiro.model;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.util.ArrayList;

public class Safra implements Serializable {

    private CustoA custoA;
    private CustoB custoB;
    private CustoC custoC;
    private CustoD custoD;
    private Produtor produtor;

    //custos totais por hectares (ha) e caixa(cx)

    private String custoTotalHa;
    private String custoTotalCa;
    private String resultadoHa;
    private String resultadoCx;
    private String receitaHa;
    private String margemVenda;
    private String preçoMedioRecebidoProdutor;
    private String regiaoReferencia;
    private int qtdePes;
    private int qtdeCaixas;
    private String qtdeMediaCaixas;
    private String pesoMedioCaixas;
    private String clicloAno;
    private String estado;

    private ArrayList<Venda> vendas = new ArrayList<>();

    public Safra() {
    }

    @SuppressLint("DefaultLocale")
    public Safra calcularCustoTotalHa(Safra s) {
        double resultado = Double.parseDouble(s.getCustoA().getSubTotalA()) +
                Double.parseDouble(s.getCustoB().getSubTotalB()) +
                Double.parseDouble(s.getCustoC().getSubTotalC()) +
                Double.parseDouble(s.getCustoD().getSubTotalD());
        s.setCustoTotalHa(String.format("%,.2f", resultado));
        return s;
    }

    @SuppressLint("DefaultLocale")
    public Safra calcularCustoTotalCx(Safra s) {
        double resultado = Double.parseDouble(s.getCustoTotalHa()) / s.getQtdeCaixas();
        s.setCustoTotalCa(String.format("%,.2f", resultado));
        return s;
    }

    public Safra calcularPrecoMedioRecebido(Safra s) {
        double resultado = 0;
        for (int i = 0; i < s.getVendas().size(); i++) {
            resultado += Double.parseDouble(s.getVendas().get(i).getPreco());
        }
        s.setPreçoMedioRecebidoProdutor(String.format("%,.2f", resultado));
        return s;
    }

    public Safra calcularQtdeCaixasVendidas(Safra s) {
        int resultado = 0;
        for (int i = 0; i < s.getVendas().size(); i++) {
            resultado += s.getVendas().get(i).getQuantidade();
        }
        s.setQtdeCaixas(resultado);
        return s;
    }

    public Safra calcularQtdeMediaCaixasVendidas(Safra s) {
        int resultado = 0;
        for (int i = 0; i < s.getVendas().size(); i++) {
            resultado += s.getVendas().get(i).getQuantidade();
        }
        s.setQtdeMediaCaixas(String.format("%,.2f", resultado / s.getVendas().size()));
        return s;
    }

    public Safra calcularPesoMedioCaixa(Safra s) {
        double resultado = 0;
        for (int i = 0; i < s.getVendas().size(); i++) {
            resultado += Double.parseDouble(s.parse(s.getVendas().get(i).getPesoCaixa()));
        }
        s.setPesoMedioCaixas(String.format("%,.2f", resultado / s.getVendas().size()));
        return s;
    }

    public String parse(String s) {
        return s = s.replace(",", ".");
    }

    public CustoA getCustoA() {
        return custoA;
    }

    public void setCustoA(CustoA custoA) {
        this.custoA = custoA;
    }

    public CustoB getCustoB() {
        return custoB;
    }

    public void setCustoB(CustoB custoB) {
        this.custoB = custoB;
    }

    public CustoC getCustoC() {
        return custoC;
    }

    public void setCustoC(CustoC custoC) {
        this.custoC = custoC;
    }

    public String getQtdeMediaCaixas() {
        return qtdeMediaCaixas;
    }

    public void setQtdeMediaCaixas(String qtdeMediaCaixas) {
        this.qtdeMediaCaixas = qtdeMediaCaixas;
    }

    public CustoD getCustoD() {
        return custoD;
    }

    public void setCustoD(CustoD custoD) {
        this.custoD = custoD;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public String getCustoTotalHa() {
        return custoTotalHa;
    }

    public void setCustoTotalHa(String custoTotalHa) {
        this.custoTotalHa = custoTotalHa;
    }

    public String getCustoTotalCa() {
        return custoTotalCa;
    }

    public void setCustoTotalCa(String custoTotalCa) {
        this.custoTotalCa = custoTotalCa;
    }

    public String getResultadoHa() {
        return resultadoHa;
    }

    public void setResultadoHa(String resultadoHa) {
        this.resultadoHa = resultadoHa;
    }

    public String getResultadoCx() {
        return resultadoCx;
    }

    public void setResultadoCx(String resultadoCx) {
        this.resultadoCx = resultadoCx;
    }

    public String getReceitaHa() {
        return receitaHa;
    }

    public void setReceitaHa(String receitaHa) {
        this.receitaHa = receitaHa;
    }

    public String getMargemVenda() {
        return margemVenda;
    }

    public void setMargemVenda(String margemVenda) {
        this.margemVenda = margemVenda;
    }

    public String getPreçoMedioRecebidoProdutor() {
        return preçoMedioRecebidoProdutor;
    }

    public void setPreçoMedioRecebidoProdutor(String preçoMedioRecebidoProdutor) {
        this.preçoMedioRecebidoProdutor = preçoMedioRecebidoProdutor;
    }

    public String getRegiaoReferencia() {
        return regiaoReferencia;
    }

    public void setRegiaoReferencia(String regiaoReferencia) {
        this.regiaoReferencia = regiaoReferencia;
    }

    public int getQtdePes() {
        return qtdePes;
    }

    public void setQtdePes(int qtdePes) {
        this.qtdePes = qtdePes;
    }

    public int getQtdeCaixas() {
        return qtdeCaixas;
    }

    public void setQtdeCaixas(int qtdeCaixas) {
        this.qtdeCaixas = qtdeCaixas;
    }

    public String getPesoMedioCaixas() {
        return pesoMedioCaixas;
    }

    public void setPesoMedioCaixas(String pesoMedioCaixas) {
        this.pesoMedioCaixas = pesoMedioCaixas;
    }

    public String getClicloAno() {
        return clicloAno;
    }

    public void setClicloAno(String clicloAno) {
        this.clicloAno = clicloAno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }
}
