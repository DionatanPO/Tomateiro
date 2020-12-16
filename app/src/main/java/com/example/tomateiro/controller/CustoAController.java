package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.CustoA;

import java.lang.reflect.Field;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class CustoAController {
    private Context context;

    public CustoAController(Context context) {
        this.context = context;
    }

    public boolean validar_custo(CustoA custoA) throws IllegalAccessException {
        Boolean resultado = false;

        Class<CustoA> custoAClass = CustoA.class;

        Field[] fields = custoAClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = field.get(custoA);

            if (objeto == null) {
                System.out.println(field.getName());
                resultado = false;
                viewToastAlerta(context,"Preencha todos os campos");
                break;

            } else {
                resultado = true;
            }
        }
        return resultado;
    }
}