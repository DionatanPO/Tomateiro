package com.example.tomateiro.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tomateiro.R;
import com.example.tomateiro.controller.EstruturaController;
import com.example.tomateiro.controller.SafraController;
import com.example.tomateiro.model.Estrutura;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.request.SafraRequest;

import java.util.ArrayList;

public class EstruturaActivity extends AppCompatActivity {
    private Button estrutura_btn_nova;
    private Context context;
    private EstruturaController estruturaController;
    private SafraController safraController;
    private SafraRequest safraRequest;
    private Safra safra;
    private ArrayList<Estrutura> estruturaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estrutura);
        context = this;
        estrutura_btn_nova = findViewById(R.id.estrutura_btn_nova);

        estruturaArrayList = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            if (safra.getEstruturas() == null) {
                safra.setEstruturas(estruturaArrayList);
            }
        }

        estrutura_btn_nova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alerta;
                LayoutInflater inflater = LayoutInflater.from(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                View layout = inflater.inflate(R.layout.nova_estrutura_fragmento, null);

                EditText estrutura_nome_item = layout.findViewById(R.id.estrutura_nome_item);
                EditText estrutura_valor_item = layout.findViewById(R.id.estrutura_valor_item);
                EditText estrutura_vida_item = layout.findViewById(R.id.estrutura_vida_item);

                Estrutura estrutura = new Estrutura();
                estrutura.setNome_item(estrutura_nome_item.getText().toString());
                estrutura.setValor(estrutura_valor_item.getText().toString());
                estrutura.setVidaUtil(estrutura_vida_item.getText().toString());

                estruturaController = new EstruturaController(context);

                if (estruturaController.validarCadastroEstrutura(estrutura)) {
                    safraController = new SafraController(context);
                    safraRequest = new SafraRequest(context);

                    safra.getEstruturas().add(estrutura);

                    safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), EstruturaActivity.this);

                }

                builder.setView(layout);
                alerta = builder.create();
                alerta.show();
            }
        });

    }

    public void request_cadastro(Safra s) {
        safra = s;
    }
}