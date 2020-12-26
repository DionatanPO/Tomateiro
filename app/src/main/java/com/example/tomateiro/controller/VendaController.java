package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.Venda;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class VendaController {
    private Context context;

    public VendaController(Context context) {
        this.context = context;
    }

    public boolean validar_cadastro(Venda venda, String quantidade) {
        if (venda.getPreco().isEmpty() || venda.getVendaData().isEmpty()
                || quantidade.equals("")||venda.getPesoCaixa().equals("")) {
            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        } else {
            return true;
        }
    }

    public boolean validar_alterar(Venda venda, String quantidade) {
        if (venda.getPreco().isEmpty() || venda.getVendaData().isEmpty()
                || quantidade.equals("")||venda.getPesoCaixa().equals("")) {
            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        } else {
            return true;
        }
    }
}
