package com.example.tomateiro.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;

public class LoginActivity extends AppCompatActivity {

    Button btn_registrar, getBtn_entrar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        context = this;

        btn_registrar = findViewById(R.id.btn_registrar);
        getBtn_entrar = findViewById(R.id.btn_entrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegistroActivity.class);
                startActivity(intent);
            }
        });
        getBtn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PainelActivity.class);
                startActivity(intent);
            }
        });
    }
}