package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.CustoB;

import java.lang.reflect.Field;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class CustoBController {
    private Context context;

    public CustoBController(Context context) {
        this.context = context;
    }

    public boolean validar_custo(CustoB custoB) throws IllegalAccessException {
        Boolean resultado = false;

        Class<CustoB> custoBClass = CustoB.class;

        Field[] fields = custoBClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = field.get(custoB);

            if (objeto == null) {
                System.out.println(field.getName());
                if(field.getName().equals("subTotalB") ||field.getName().equals("id")){
                    resultado = true;
                }else{
                    resultado = false;
                    viewToastAlerta(context,"Preencha todos os campos");
                    break;
                }

            } else {
                resultado = true;
            }
        }
        return resultado;
    }
}