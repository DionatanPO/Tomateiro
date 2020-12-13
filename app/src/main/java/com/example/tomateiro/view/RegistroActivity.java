package com.example.tomateiro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Produtor;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class RegistroActivity extends AppCompatActivity {
    private Produtor produtor;
    private EditText nome, propriedade, identificacao, senha1, senha2;
    private Button button_concluir;
    private Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        context = this;
        button_concluir = findViewById(R.id.btn_concluir);

        nome = findViewById(R.id.registro_nome);
        propriedade = findViewById(R.id.registro_propriedade);
        identificacao = findViewById(R.id.registro_identificacao);
        senha1 = findViewById(R.id.senha1);
        senha2 = findViewById(R.id.senha2);

        button_concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produtor = new Produtor();
                produtor.setNome(nome.getText().toString());
                produtor.setPropriedade(propriedade.getText().toString());
                produtor.setCodIdentificacao(identificacao.getText().toString());
                produtor.setSenha(senha1.getText().toString());

                intent = new Intent(context, PainelActivity.class);
                intent.putExtra("produtor", produtor);
                context.startActivity(intent);

                viewToast(context, "Registro concluido com sucesso!");

            }
        });

    }
}