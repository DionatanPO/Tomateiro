package com.example.tomateiro.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

public class CustoD implements Serializable {

    //D - ADMINISTRAÇÃO
    private Long id;
    private String arrendamentoQ;
    private String moAdministrativaQ;
    private String contabilidadeEscritorioQ;
    private String luzTelefoneQ;
    private String viagensQ;
    private String impostosTaxasQ;
    private String outrosQ;

    private String arrendamentoV;
    private String moAdministrativaV;
    private String contabilidadeEscritorioV;
    private String luzTelefoneV;
    private String viagensV;
    private String impostosTaxasV;
    private String outrosV;

    //Subtotais
    private String subTotalD;

    public CustoD() {
    }

    public CustoD calcularSubTotal(CustoD c) {
        Double resultadoCalculo =
                parseToDouble(c.getArrendamentoV()) +
                        parseToDouble(c.getMoAdministrativaV()) +
                        parseToDouble(c.getContabilidadeEscritorioV()) +
                        parseToDouble(c.getLuzTelefoneV()) +
                        parseToDouble(c.getViagensV()) +
                        parseToDouble(c.getOutrosV()) +
                        parseToDouble(c.getImpostosTaxasV());


        String value = String.format("%,.2f", resultadoCalculo);

        c.setSubTotalD(value);
        return c;
    }

    public double parseToDouble(String s) {
        double value = 0;

        s = s.substring(1, s.length());

        NumberFormat format = NumberFormat.getInstance();

        try {
            value = format.parse(s).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArrendamentoQ() {
        return arrendamentoQ;
    }

    public void setArrendamentoQ(String arrendamentoQ) {
        this.arrendamentoQ = arrendamentoQ;
    }

    public String getMoAdministrativaQ() {
        return moAdministrativaQ;
    }

    public void setMoAdministrativaQ(String moAdministrativaQ) {
        this.moAdministrativaQ = moAdministrativaQ;
    }

    public String getContabilidadeEscritorioQ() {
        return contabilidadeEscritorioQ;
    }

    public void setContabilidadeEscritorioQ(String contabilidadeEscritorioQ) {
        this.contabilidadeEscritorioQ = contabilidadeEscritorioQ;
    }

    public String getLuzTelefoneQ() {
        return luzTelefoneQ;
    }

    public void setLuzTelefoneQ(String luzTelefoneQ) {
        this.luzTelefoneQ = luzTelefoneQ;
    }

    public String getViagensQ() {
        return viagensQ;
    }

    public void setViagensQ(String viagensQ) {
        this.viagensQ = viagensQ;
    }

    public String getImpostosTaxasQ() {
        return impostosTaxasQ;
    }

    public void setImpostosTaxasQ(String impostosTaxasQ) {
        this.impostosTaxasQ = impostosTaxasQ;
    }

    public String getOutrosQ() {
        return outrosQ;
    }

    public void setOutrosQ(String outrosQ) {
        this.outrosQ = outrosQ;
    }

    public String getArrendamentoV() {
        return arrendamentoV;
    }

    public void setArrendamentoV(String arrendamentoV) {
        this.arrendamentoV = arrendamentoV;
    }

    public String getMoAdministrativaV() {
        return moAdministrativaV;
    }

    public void setMoAdministrativaV(String moAdministrativaV) {
        this.moAdministrativaV = moAdministrativaV;
    }

    public String getContabilidadeEscritorioV() {
        return contabilidadeEscritorioV;
    }

    public void setContabilidadeEscritorioV(String contabilidadeEscritorioV) {
        this.contabilidadeEscritorioV = contabilidadeEscritorioV;
    }

    public String getLuzTelefoneV() {
        return luzTelefoneV;
    }

    public void setLuzTelefoneV(String luzTelefoneV) {
        this.luzTelefoneV = luzTelefoneV;
    }

    public String getViagensV() {
        return viagensV;
    }

    public void setViagensV(String viagensV) {
        this.viagensV = viagensV;
    }

    public String getImpostosTaxasV() {
        return impostosTaxasV;
    }

    public void setImpostosTaxasV(String impostosTaxasV) {
        this.impostosTaxasV = impostosTaxasV;
    }

    public String getOutrosV() {
        return outrosV;
    }

    public void setOutrosV(String outrosV) {
        this.outrosV = outrosV;
    }

    public String getSubTotalD() {
        return subTotalD;
    }

    public void setSubTotalD(String subTotalD) {
        this.subTotalD = subTotalD;
    }

}
