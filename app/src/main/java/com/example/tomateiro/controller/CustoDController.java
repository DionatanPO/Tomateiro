package com.example.tomateiro.controller;

import android.content.Context;

import com.example.tomateiro.model.CustoD;

import java.lang.reflect.Field;

import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class CustoDController {
    private Context context;

    public CustoDController(Context context) {
        this.context = context;
    }

    public boolean validar_custo(CustoD custoD) throws IllegalAccessException {
        Boolean resultado = false;

        Class<CustoD> custoDClass = CustoD.class;

        Field[] fields = custoDClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = field.get(custoD);

            if (objeto == null) {
                System.out.println(field.getName());
                if(field.getName().equals("subTotalD")){
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