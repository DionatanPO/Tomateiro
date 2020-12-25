package com.example.tomateiro.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Relatorio {

    private Safra safra;

    public Relatorio() {
    }

    public float parse(String s) {

        float resultado = 0;
        s = s.replace(",", ".");

        NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
        try {
            resultado = format.parse(s).floatValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        value = value / 100;
//        s = String.format(Locale.US, "%.2f", value);


        return resultado/100;
    }

    public Safra getSafra() {
        return safra;
    }

    public void setSafra(Safra safra) {
        this.safra = safra;
    }
}
