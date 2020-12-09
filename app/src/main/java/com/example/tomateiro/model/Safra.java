package com.example.tomateiro.model;

import android.annotation.SuppressLint;

public class Safra {

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
    private int pesoCaixas;
    private String clicloAno;
    private String estado;

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

    public int getPesoCaixas() {
        return pesoCaixas;
    }

    public void setPesoCaixas(int pesoCaixas) {
        this.pesoCaixas = pesoCaixas;
    }

    public String getClicloAno() {
        return clicloAno;
    }

    public void setClicloAno(String clicloAno) {
        this.clicloAno = clicloAno;
    }

}
