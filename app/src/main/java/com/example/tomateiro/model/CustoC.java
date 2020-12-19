package com.example.tomateiro.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

public class CustoC implements Serializable {
    //C - INSUMOS
    private String calcarioDolomiticoQ;
    private String sulfatoAmonioQ;
    private String superfosfatoSimplesQ;
    private String cloretoPotassioQ;
    private String estercoBovinoQ;
    private String yorinQ;
    private String sementesQ;
    private String confeccaoMudasQ;
    private String estacasBambuQ;
    private String mouroesEucaQ;
    private String arame16Q;
    private String arame20Q;
    private String fungicidasQ;
    private String herbicidasQ;
    private String inseticidasQ;
    private String outrosProdutosQuimicosQ;
    private String outrosQ;

    private String calcarioDolomiticoV;
    private String sulfatoAmonioV;
    private String superfosfatoSimplesV;
    private String cloretoPotassioV;
    private String estercoBovinoV;
    private String yorinV;
    private String sementesV;
    private String confeccaoMudasV;
    private String estacasBambuV;
    private String mouroesEucaV;
    private String arame16V;
    private String arame20V;
    private String fungicidasV;
    private String herbicidasV;
    private String inseticidasV;
    private String outrosProdutosQuimicosV;
    private String outrosV;

    //Subtotais
    private String subTotalC;

    public CustoC() {
    }

        public CustoC calcularSubTotal(CustoC c) {
        Double resultadoCalculo =
                parseToDouble(c.getCalcarioDolomiticoV()) +
                        parseToDouble(c.getSulfatoAmonioV()) +
                        parseToDouble(c.getSuperfosfatoSimplesV()) +
                        parseToDouble(c.getSuperfosfatoSimplesV()) +
                        parseToDouble(c.getCloretoPotassioV()) +
                        parseToDouble(c.getEstercoBovinoV()) +
                        parseToDouble(c.getYorinV()) +
                        parseToDouble(c.getSementesV()) +
                        parseToDouble(c.getConfeccaoMudasV()) +
                        parseToDouble(c.getEstacasBambuV()) +
                        parseToDouble(c.getMouroesEucaV()) +
                        parseToDouble(c.getArame16V()) +
                        parseToDouble(c.getArame20V()) +
                        parseToDouble(c.getFungicidasV()) +
                        parseToDouble(c.getHerbicidasV()) +
                        parseToDouble(c.getInseticidasV()) +
                        parseToDouble(c.getOutrosProdutosQuimicosV()) +
                        parseToDouble(c.getOutrosV());


        String value = String.format("%,.2f", resultadoCalculo);

        c.setSubTotalC(value);
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

    public String getCalcarioDolomiticoQ() {
        return calcarioDolomiticoQ;
    }

    public void setCalcarioDolomiticoQ(String calcarioDolomiticoQ) {
        this.calcarioDolomiticoQ = calcarioDolomiticoQ;
    }

    public String getSulfatoAmonioQ() {
        return sulfatoAmonioQ;
    }

    public void setSulfatoAmonioQ(String sulfatoAmonioQ) {
        this.sulfatoAmonioQ = sulfatoAmonioQ;
    }

    public String getSuperfosfatoSimplesQ() {
        return superfosfatoSimplesQ;
    }

    public void setSuperfosfatoSimplesQ(String superfosfatoSimplesQ) {
        this.superfosfatoSimplesQ = superfosfatoSimplesQ;
    }

    public String getCloretoPotassioQ() {
        return cloretoPotassioQ;
    }

    public void setCloretoPotassioQ(String cloretoPotassioQ) {
        this.cloretoPotassioQ = cloretoPotassioQ;
    }

    public String getEstercoBovinoQ() {
        return estercoBovinoQ;
    }

    public void setEstercoBovinoQ(String estercoBovinoQ) {
        this.estercoBovinoQ = estercoBovinoQ;
    }

    public String getYorinQ() {
        return yorinQ;
    }

    public void setYorinQ(String yorinQ) {
        this.yorinQ = yorinQ;
    }

    public String getSementesQ() {
        return sementesQ;
    }

    public void setSementesQ(String sementesQ) {
        this.sementesQ = sementesQ;
    }

    public String getConfeccaoMudasQ() {
        return confeccaoMudasQ;
    }

    public void setConfeccaoMudasQ(String confeccaoMudasQ) {
        this.confeccaoMudasQ = confeccaoMudasQ;
    }

    public String getEstacasBambuQ() {
        return estacasBambuQ;
    }

    public void setEstacasBambuQ(String estacasBambuQ) {
        this.estacasBambuQ = estacasBambuQ;
    }

    public String getMouroesEucaQ() {
        return mouroesEucaQ;
    }

    public void setMouroesEucaQ(String mouroesEucaQ) {
        this.mouroesEucaQ = mouroesEucaQ;
    }

    public String getArame16Q() {
        return arame16Q;
    }

    public void setArame16Q(String arame16Q) {
        this.arame16Q = arame16Q;
    }

    public String getArame20Q() {
        return arame20Q;
    }

    public void setArame20Q(String arame20Q) {
        this.arame20Q = arame20Q;
    }

    public String getFungicidasQ() {
        return fungicidasQ;
    }

    public void setFungicidasQ(String fungicidasQ) {
        this.fungicidasQ = fungicidasQ;
    }

    public String getHerbicidasQ() {
        return herbicidasQ;
    }

    public void setHerbicidasQ(String herbicidasQ) {
        this.herbicidasQ = herbicidasQ;
    }

    public String getInseticidasQ() {
        return inseticidasQ;
    }

    public void setInseticidasQ(String inseticidasQ) {
        this.inseticidasQ = inseticidasQ;
    }

    public String getOutrosProdutosQuimicosQ() {
        return outrosProdutosQuimicosQ;
    }

    public void setOutrosProdutosQuimicosQ(String outrosProdutosQuimicosQ) {
        this.outrosProdutosQuimicosQ = outrosProdutosQuimicosQ;
    }

    public String getOutrosQ() {
        return outrosQ;
    }

    public void setOutrosQ(String outrosQ) {
        this.outrosQ = outrosQ;
    }

    public String getCalcarioDolomiticoV() {
        return calcarioDolomiticoV;
    }

    public void setCalcarioDolomiticoV(String calcarioDolomiticoV) {
        this.calcarioDolomiticoV = calcarioDolomiticoV;
    }

    public String getSulfatoAmonioV() {
        return sulfatoAmonioV;
    }

    public void setSulfatoAmonioV(String sulfatoAmonioV) {
        this.sulfatoAmonioV = sulfatoAmonioV;
    }

    public String getSuperfosfatoSimplesV() {
        return superfosfatoSimplesV;
    }

    public void setSuperfosfatoSimplesV(String superfosfatoSimplesV) {
        this.superfosfatoSimplesV = superfosfatoSimplesV;
    }

    public String getCloretoPotassioV() {
        return cloretoPotassioV;
    }

    public void setCloretoPotassioV(String cloretoPotassioV) {
        this.cloretoPotassioV = cloretoPotassioV;
    }

    public String getEstercoBovinoV() {
        return estercoBovinoV;
    }

    public void setEstercoBovinoV(String estercoBovinoV) {
        this.estercoBovinoV = estercoBovinoV;
    }

    public String getYorinV() {
        return yorinV;
    }

    public void setYorinV(String yorinV) {
        this.yorinV = yorinV;
    }

    public String getSementesV() {
        return sementesV;
    }

    public void setSementesV(String sementesV) {
        this.sementesV = sementesV;
    }

    public String getConfeccaoMudasV() {
        return confeccaoMudasV;
    }

    public void setConfeccaoMudasV(String confeccaoMudasV) {
        this.confeccaoMudasV = confeccaoMudasV;
    }

    public String getEstacasBambuV() {
        return estacasBambuV;
    }

    public void setEstacasBambuV(String estacasBambuV) {
        this.estacasBambuV = estacasBambuV;
    }

    public String getMouroesEucaV() {
        return mouroesEucaV;
    }

    public void setMouroesEucaV(String mouroesEucaV) {
        this.mouroesEucaV = mouroesEucaV;
    }

    public String getArame16V() {
        return arame16V;
    }

    public void setArame16V(String arame16V) {
        this.arame16V = arame16V;
    }

    public String getArame20V() {
        return arame20V;
    }

    public void setArame20V(String arame20V) {
        this.arame20V = arame20V;
    }

    public String getFungicidasV() {
        return fungicidasV;
    }

    public void setFungicidasV(String fungicidasV) {
        this.fungicidasV = fungicidasV;
    }

    public String getHerbicidasV() {
        return herbicidasV;
    }

    public void setHerbicidasV(String herbicidasV) {
        this.herbicidasV = herbicidasV;
    }

    public String getInseticidasV() {
        return inseticidasV;
    }

    public void setInseticidasV(String inseticidasV) {
        this.inseticidasV = inseticidasV;
    }

    public String getOutrosProdutosQuimicosV() {
        return outrosProdutosQuimicosV;
    }

    public void setOutrosProdutosQuimicosV(String outrosProdutosQuimicosV) {
        this.outrosProdutosQuimicosV = outrosProdutosQuimicosV;
    }

    public String getOutrosV() {
        return outrosV;
    }

    public void setOutrosV(String outrosV) {
        this.outrosV = outrosV;
    }

    public String getSubTotalC() {
        return subTotalC;
    }

    public void setSubTotalC(String subTotalC) {
        this.subTotalC = subTotalC;
    }
}
