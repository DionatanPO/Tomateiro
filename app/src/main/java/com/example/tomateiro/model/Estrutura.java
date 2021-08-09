package com.example.tomateiro.model;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Estrutura implements Serializable {

    private Long id;
    private String nome_item;
    private String valor;
    private String vidaUtil;
    private String categoria;
    private String depreciacao;
    private String dataInicial;
    private String dataReuso;
    private String detaFinal;
    private long qtdMesesGeral;
    private long qtdMesesAtual;

    public Estrutura() {
    }

    public String calcular_deprecicao(String e, String valor, String mes) {
        String resultado;

        int percentual = 0;

        if (e.equals("Outras máquinas")) {
            percentual = 10;
        }
        if (e.equals("Máquina: Trator")) {
            percentual = 60;
        }
        if (e.equals("Máquina: Colheitadeira")) {
            percentual = 60;
        }
        if (e.equals("Implemento")) {
            percentual = 10;
        }
        if (e.equals("Ferramenta")) {
            percentual = 20;
        }
        if (e.equals("Outras construções")) {
            percentual = 5;
        }
        if (e.equals("Construção: Estaca")) {
            percentual = 0;
        }
        float valorInicial = parse(valor);

        float valorFinal = percentual * valorInicial / 100;

        double depreciacao = valorInicial - valorFinal;

        depreciacao = depreciacao / Integer.parseInt(mes);

        depreciacao = depreciacao / 100;

        resultado = String.format("%,.2f", depreciacao);

        return resultado;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Long caclcular_Duracao_meses(String dataInicial) {
        //define datas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataCadastro = LocalDate.parse(dataInicial, formatter);
        LocalDate hoje = LocalDate.now();

        //calcula diferença
        long meses = dataCadastro.until(hoje, ChronoUnit.MONTHS);
        return meses;
    }

    public float parse(String s) {
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

    public long getQtdMesesGeral() {
        return qtdMesesGeral;
    }

    public void setQtdMesesGeral(long qtdMesesGeral) {
        this.qtdMesesGeral = qtdMesesGeral;
    }

    public long getQtdMesesAtual() {
        return qtdMesesAtual;
    }

    public void setQtdMesesAtual(long qtdMesesAtual) {
        this.qtdMesesAtual = qtdMesesAtual;
    }

    public String getDataReuso() {
        return dataReuso;
    }

    public void setDataReuso(String dataReuso) {
        this.dataReuso = dataReuso;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDetaFinal() {
        return detaFinal;
    }

    public void setDetaFinal(String detaFinal) {
        this.detaFinal = detaFinal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDepreciacao() {
        return depreciacao;
    }

    public void setDepreciacao(String depreciacao) {
        this.depreciacao = depreciacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
    }
}
