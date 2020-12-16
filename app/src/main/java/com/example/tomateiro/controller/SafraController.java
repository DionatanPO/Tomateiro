package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.Safra;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class SafraController {
    private Context  context;

    public SafraController(Context context) {
        this.context = context;
    }

    public boolean validar_cadastro(Safra safra){
        if(safra.getClicloAno().isEmpty()||safra.getRegiaoReferencia().isEmpty()){
            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        }else {
            return  true;
        }
    }
    public boolean validar_alterar(Safra safra){
        if(safra.getClicloAno().isEmpty()||safra.getRegiaoReferencia().isEmpty()){
            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        }else {
            return  true;
        }
    }
}
