package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.Estrutura;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class EstruturaController {
    private Context context;

    public EstruturaController(Context context) {
        this.context = context;
    }

    public boolean validarCadastroEstrutura(Estrutura e){
        if(e.getNome_item().isEmpty()||e.getValor().isEmpty()||e.getVidaUtil().isEmpty()||e.getCategoria().equals("")){
            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        }else {
            try {
                e.setDepreciacao(e.calcular_deprecicao(e.getCategoria(),e.getValor(),e.getVidaUtil()));

            }catch (Exception ex){

            }

            return true;
        }
    }
}
