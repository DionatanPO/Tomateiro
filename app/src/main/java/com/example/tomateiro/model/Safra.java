package com.example.tomateiro.model;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Safra implements Serializable {

    private Long id;
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
    private String data;

    private ArrayList<Venda> vendas = new ArrayList<>();
    private ArrayList<Estrutura> estruturas = new ArrayList<>();

    public Safra() {
    }

    @SuppressLint("DefaultLocale")
    public Safra calcularCustoTotalHa(Safra s) {

        if (s.getCustoA() != null && s.getCustoB().getSubTotalB() != null &&
                s.getCustoC().getSubTotalC() != null && s.getCustoD().getSubTotalD() != null) {
            long resultado = parse2(s.getCustoA().getSubTotalA()) +
                    parse2(s.getCustoB().getSubTotalB()) +
                    parse2(s.getCustoC().getSubTotalC()) +
                    parse2(s.getCustoD().getSubTotalD());
            double x = (double) resultado / 100;
            s.setCustoTotalHa(String.format("%,.2f", x));

        } else {
            s.setCustoTotalHa("0");
        }

        return s;
    }

    @SuppressLint("DefaultLocale")
    public Safra calcularCustoTotalCx(Safra s) {
        long resultado = parse2(s.getCustoTotalHa()) / s.getQtdeCaixas();
        double x = (double) resultado / 100;
        s.setCustoTotalCa(String.format("%,.2f", x));
        return s;
    }

    public Safra calcularPrecoMedioRecebido(Safra s) {
        long resultado = 0;
        for (int i = 0; i < s.getVendas().size(); i++) {
            resultado += parse2(s.getVendas().get(i).getPreco());
        }
        double x = ((double) resultado / 100) / s.getVendas().size();
        s.setPreçoMedioRecebidoProdutor(String.format("%,.2f", x));
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


    public Safra calcularPesoMedioCaixa(Safra s) {
        double resultado = 0;
        for (int i = 0; i < s.getVendas().size(); i++) {
            resultado += Double.parseDouble(s.parse(s.getVendas().get(i).getPesoCaixa()));
        }
        s.setPesoMedioCaixas(String.format("%,.2f", resultado / s.getVendas().size()));
        return s;
    }

    public Safra calcularReceita(Safra s) {
        long resultado = parse2(s.getPreçoMedioRecebidoProdutor()) * s.getQtdeCaixas();
        double x = (double) resultado / 100;
        s.setReceitaHa(String.format("%,.2f", x));
        return s;
    }

    public Safra calcularResultadoHa(Safra s) {
        long resultado = parse2(s.getReceitaHa()) - parse2(s.getCustoTotalHa());
        double x = (double) resultado / 100;
        s.setResultadoHa(String.format("%,.2f", x));
        return s;
    }

    public Safra calcularResultadoCx(Safra s) {
        long resultado = parse2(s.getPreçoMedioRecebidoProdutor()) - parse2(s.getCustoTotalCa());
        double x = (double) resultado / 100;
        s.setResultadoCx(String.format("%,.2f", x));
        return s;
    }

    public Safra calcularMargemVenda(Safra s) {
        double resultado = parse4(s.getResultadoCx()) / parse4(s.getPreçoMedioRecebidoProdutor());
        double x = resultado * 100;
        s.setMargemVenda(String.format("%,.2f", x));
        return s;
    }

    public String parse(String s) {
        return s = s.replace(",", ".");
    }

    public long parse2(String s) {
        double value = 0;
        long r = 0;

        s = s.replace(",", ".");

        NumberFormat format = NumberFormat.getInstance();
        try {
            value = format.parse(s).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        s = String.format(Locale.US, "%.0f", value);
        r = Long.parseLong(s);
        return r;
    }

    public float parse4(String s) {
        double value = 0;
        float r = 0;

        s = s.replace(",", ".");

        NumberFormat format = NumberFormat.getInstance();

        try {
            value = format.parse(s).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        s = String.format(Locale.US, "%.2f", value);
        r = Float.parseFloat(s);
        return r;
    }

    public String parse3(String value, String valueTotal) {
        double resultado = parse4(value) / parse4(valueTotal);
        resultado = resultado * 100;

        return String.format(Locale.US, "%.2f", resultado);
    }

    public String calcularLucratividade(String dateInicial, String receita, String custoTotalHa) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        Date dataHoraAtual = new Date();
        String dataAtual = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);

        Date firstDate = sdf.parse(dateInicial);

        Date secondDate = sdf.parse(dataAtual);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long quantidadeDias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if (quantidadeDias > 0) {
            double resultado = 0;

            double resDia = quantidadeDias / 30.0;

            double resReceita = parse4(receita) / parse4(custoTotalHa);

            double resRaiz = Math.pow(resReceita, 1.0 / resDia);

            resultado = (resRaiz - 1) * 100;

            return String.format("%.2f", resultado);
        } else {
            return "+100.000";
        }


    }


    public ArrayList<Estrutura> getEstruturas() {
        return estruturas;
    }

    public void setEstruturas(ArrayList<Estrutura> estruturas) {
        this.estruturas = estruturas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Safra cliclo/ ano = " + clicloAno + " Data " + data;
    }
}
