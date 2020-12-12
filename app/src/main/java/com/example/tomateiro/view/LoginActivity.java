package com.example.tomateiro.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Produtor;

public class LoginActivity extends AppCompatActivity {

   private Button btn_registrar, getBtn_entrar;
   private Context context;
   private Produtor produtor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                produtor = new Produtor();
                produtor.setNome("Dionatan");

                Intent intent = new Intent(context, PainelActivity.class);
                intent.putExtra("produtor", produtor);
                startActivity(intent);
            }
        });
    }
}