package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.CustoC;

import java.lang.reflect.Field;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class CustoCController {
    private Context context;

    public CustoCController(Context context) {
        this.context = context;
    }

    public boolean validar_custo(CustoC custoC) throws IllegalAccessException {
        Boolean resultado = false;

        Class<CustoC> custoCClass = CustoC.class;

        Field[] fields = custoCClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = field.get(custoC);

            if (objeto == null) {
                System.out.println(field.getName());
                if(field.getName().equals("subTotalA")){
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