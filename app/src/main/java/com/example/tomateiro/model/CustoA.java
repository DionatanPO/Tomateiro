package com.example.tomateiro.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

public class CustoA implements Serializable {

    //A - OPERAÇÕES MECANIZADAS
    private Long id;
    private String aracaoQ;
    private String aracaoV;

    private String gradeacaoQ;
    private String gradeacaoV;

    private String subsolagemQ;
    private String subsolagemV;

    private String calagemQ;
    private String calagemV;

    private String sulcamentoQ;
    private String sulcamentoV;

    private String adubacaoBasicaQ;
    private String adubacaoBasicaV;

    private String aplicacaoEstercoQ;
    private String aplicacaoEstercoV;

    private String adubacaoCoberturaQ;
    private String adubacaoCoberturaV;

    private String pulverizacaoQ;
    private String pulverizacaoV;

    private String colheitaClassificacaoQ;
    private String colheitaClassificacaoV;

    private String irrigacoesQ;
    private String irrigacoesV;

    private String outrosAQ;
    private String outrosAV;

    //Subtotais
    private String subTotalA;

    public CustoA() {
    }

    public CustoA calcularSubTotal(CustoA c) {
        Double resultadoCalculo =
                parseToDouble(c.getAracaoV()) +
                        parseToDouble(c.getAdubacaoBasicaV()) +
                        parseToDouble(c.getAdubacaoCoberturaV()) +
                        parseToDouble(c.getAplicacaoEstercoV()) +
                        parseToDouble(c.getCalagemV()) +
                        parseToDouble(c.getColheitaClassificacaoV()) +
                        parseToDouble(c.getGradeacaoV()) +
                        parseToDouble(c.getSubsolagemV()) +
                        parseToDouble(c.getPulverizacaoV()) +
                        parseToDouble(c.getIrrigacoesV()) +
                        parseToDouble(c.getOutrosAV()) +
                        parseToDouble(c.getSulcamentoV());

        String value = String.format("%,.2f", resultadoCalculo);
        c.setSubTotalA(value);
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

    public String getAracaoQ() {
        return aracaoQ;
    }

    public void setAracaoQ(String aracaoQ) {
        this.aracaoQ = aracaoQ;
    }

    public String getAracaoV() {
        return aracaoV;
    }

    public void setAracaoV(String aracaoV) {
        this.aracaoV = aracaoV;
    }

    public String getGradeacaoQ() {
        return gradeacaoQ;
    }

    public void setGradeacaoQ(String gradeacaoQ) {
        this.gradeacaoQ = gradeacaoQ;
    }

    public String getGradeacaoV() {
        return gradeacaoV;
    }

    public void setGradeacaoV(String gradeacaoV) {
        this.gradeacaoV = gradeacaoV;
    }

    public String getSubsolagemQ() {
        return subsolagemQ;
    }

    public void setSubsolagemQ(String subsolagemQ) {
        this.subsolagemQ = subsolagemQ;
    }

    public String getSubsolagemV() {
        return subsolagemV;
    }

    public void setSubsolagemV(String subsolagemV) {
        this.subsolagemV = subsolagemV;
    }

    public String getCalagemQ() {
        return calagemQ;
    }

    public void setCalagemQ(String calagemQ) {
        this.calagemQ = calagemQ;
    }

    public String getCalagemV() {
        return calagemV;
    }

    public void setCalagemV(String calagemV) {
        this.calagemV = calagemV;
    }

    public String getSulcamentoQ() {
        return sulcamentoQ;
    }

    public void setSulcamentoQ(String sulcamentoQ) {
        this.sulcamentoQ = sulcamentoQ;
    }

    public String getSulcamentoV() {
        return sulcamentoV;
    }

    public void setSulcamentoV(String sulcamentoV) {
        this.sulcamentoV = sulcamentoV;
    }

    public String getAdubacaoBasicaQ() {
        return adubacaoBasicaQ;
    }

    public void setAdubacaoBasicaQ(String adubacaoBasicaQ) {
        this.adubacaoBasicaQ = adubacaoBasicaQ;
    }

    public String getAdubacaoBasicaV() {
        return adubacaoBasicaV;
    }

    public void setAdubacaoBasicaV(String adubacaoBasicaV) {
        this.adubacaoBasicaV = adubacaoBasicaV;
    }

    public String getAplicacaoEstercoQ() {
        return aplicacaoEstercoQ;
    }

    public void setAplicacaoEstercoQ(String aplicacaoEstercoQ) {
        this.aplicacaoEstercoQ = aplicacaoEstercoQ;
    }

    public String getAplicacaoEstercoV() {
        return aplicacaoEstercoV;
    }

    public void setAplicacaoEstercoV(String aplicacaoEstercoV) {
        this.aplicacaoEstercoV = aplicacaoEstercoV;
    }

    public String getAdubacaoCoberturaQ() {
        return adubacaoCoberturaQ;
    }

    public void setAdubacaoCoberturaQ(String adubacaoCoberturaQ) {
        this.adubacaoCoberturaQ = adubacaoCoberturaQ;
    }

    public String getAdubacaoCoberturaV() {
        return adubacaoCoberturaV;
    }

    public void setAdubacaoCoberturaV(String adubacaoCoberturaV) {
        this.adubacaoCoberturaV = adubacaoCoberturaV;
    }

    public String getPulverizacaoQ() {
        return pulverizacaoQ;
    }

    public void setPulverizacaoQ(String pulverizacaoQ) {
        this.pulverizacaoQ = pulverizacaoQ;
    }

    public String getPulverizacaoV() {
        return pulverizacaoV;
    }

    public void setPulverizacaoV(String pulverizacaoV) {
        this.pulverizacaoV = pulverizacaoV;
    }

    public String getColheitaClassificacaoQ() {
        return colheitaClassificacaoQ;
    }

    public void setColheitaClassificacaoQ(String colheitaClassificacaoQ) {
        this.colheitaClassificacaoQ = colheitaClassificacaoQ;
    }

    public String getColheitaClassificacaoV() {
        return colheitaClassificacaoV;
    }

    public void setColheitaClassificacaoV(String colheitaClassificacaoV) {
        this.colheitaClassificacaoV = colheitaClassificacaoV;
    }

    public String getIrrigacoesQ() {
        return irrigacoesQ;
    }

    public void setIrrigacoesQ(String irrigacoesQ) {
        this.irrigacoesQ = irrigacoesQ;
    }

    public String getIrrigacoesV() {
        return irrigacoesV;
    }

    public void setIrrigacoesV(String irrigacoesV) {
        this.irrigacoesV = irrigacoesV;
    }

    public String getOutrosAQ() {
        return outrosAQ;
    }

    public void setOutrosAQ(String outrosAQ) {
        this.outrosAQ = outrosAQ;
    }

    public String getOutrosAV() {
        return outrosAV;
    }

    public void setOutrosAV(String outrosAV) {
        this.outrosAV = outrosAV;
    }

    public String getSubTotalA() {
        return subTotalA;
    }

    public void setSubTotalA(String subTotalA) {
        this.subTotalA = subTotalA;
    }
}
