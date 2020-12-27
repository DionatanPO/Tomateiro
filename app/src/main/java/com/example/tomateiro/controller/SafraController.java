package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.model.Safra;
import com.google.gson.Gson;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class SafraController {
    private Gson gson = new Gson();
    private Safra safra = new Safra();
    private Context context;

    public SafraController(Context context) {
        this.context = context;
    }

    public boolean validar_cadastro(Safra safra) {
        if (safra.getClicloAno().isEmpty() || safra.getRegiaoReferencia().isEmpty()|| safra.getData().isEmpty()) {
            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        } else {
            return true;
        }
    }

    public boolean validar_alterar(Safra safra) {
        if (safra.getClicloAno().isEmpty() || safra.getRegiaoReferencia().isEmpty()|| safra.getData().isEmpty()) {
            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        } else {
            return true;
        }
    }

    public String converter_safra_json(Safra safra) {
        String json = gson.toJson(safra);
        return json;
    }

    public Safra converter_json_safra(String json) {
        safra = new Gson().fromJson(json, Safra.class);
        return safra;
    }
}
