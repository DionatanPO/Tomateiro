package com.example.tomateiro.model;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tomateiro.R;


public class  CustonToast {

    public static void viewToast(Context mCtx, String alerta){
        LayoutInflater inflater = LayoutInflater.from( mCtx);
        View layout = inflater.inflate(R.layout.custom_toast, null);
        layout.setBackgroundResource(R.color.alerta_verde);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(alerta);
        Toast toast = new Toast(mCtx);
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.BOTTOM, 0, 0);
        toast.setView(layout);
        toast.show();
    }
     public static void viewToastAlerta(Context mCtx, String alerta){
         LayoutInflater inflater = LayoutInflater.from( mCtx);
         View layout = inflater.inflate(R.layout.custom_toast, null);
         layout.setBackgroundResource(R.color.alerta_amarelo);
         TextView text = (TextView) layout.findViewById(R.id.text);
         text.setText(alerta);
         Toast toast = new Toast(mCtx);
         toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.BOTTOM, 0, 0);
         toast.setView(layout);
         toast.show();
     }
     public static void viewToastErro(Context mCtx, String alerta){
         LayoutInflater inflater = LayoutInflater.from( mCtx);
         View layout = inflater.inflate(R.layout.custom_toast, null);
         layout.setBackgroundResource(R.color.alerta_vermelho);
         TextView text = (TextView) layout.findViewById(R.id.text);
         text.setText(alerta);
         Toast toast = new Toast(mCtx);
         toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.BOTTOM, 0, 0);
         toast.setView(layout);
         toast.show();
     }
}
