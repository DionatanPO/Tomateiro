package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.Produtor;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class ProdutorController {
    private Context context;

    public ProdutorController(Context context) {
        this.context = context;
    }

    public boolean validar_registro(Produtor produtor, String senha2) {
        if (produtor.getNome().isEmpty() || produtor.getCodIdentificacao().isEmpty()
                || produtor.getPropriedade().isEmpty() || produtor.getSenha().isEmpty() || senha2.isEmpty()) {

            viewToastAlerta(context, "Preencha todos os campos");
          return  false;
        } else {
            if (produtor.getSenha().equals(senha2)) {

                return true;
            } else {
                viewToastAlerta(context, "As senhas não são iguais");
                return false;
            }
        }
    }

    public boolean validar_login(Produtor produtor) {
        if (produtor.getSenha().isEmpty() || produtor.getCodIdentificacao().isEmpty()) {

            viewToastAlerta(context, "Preencha todos os campos");
            return false;

        } else {
            return true;
        }
    }

    public boolean validar_alterar_senha(Produtor produtor, String senha) {
        if (senha.isEmpty() || produtor.getSenha().isEmpty()) {
            viewToastAlerta(context, "Preencha todos os campos");
            if (produtor.getSenha().equals(senha)) {
                return true;
            } else {
                viewToastAlerta(context, "As senhas não são iguais");
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean validar_alterar_perfil(Produtor produtor) {
        if (produtor.getNome().isEmpty() || produtor.getCodIdentificacao().isEmpty()
                || produtor.getPropriedade().isEmpty()) {

            viewToastAlerta(context, "Preencha todos os campos");
            return false;
        } else {
            return true;
        }
    }
}
