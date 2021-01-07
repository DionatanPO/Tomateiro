package com.example.tomateiro.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tomateiro.R;
import com.example.tomateiro.controller.EstruturaController;
import com.example.tomateiro.controller.SafraController;
import com.example.tomateiro.model.Estrutura;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.request.SafraRequest;
import com.example.tomateiro.view.adapter.EstruturaAdapter;

import java.util.ArrayList;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class EstruturaActivity extends AppCompatActivity {
    private Button estrutura_btn_nova;
    private Context context;
    private EstruturaController estruturaController;
    private SafraController safraController;
    private SafraRequest safraRequest;
    private Safra safra;
    private ArrayList<Estrutura> estruturaArrayList;
    private ListView listView;
    private EstruturaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estrutura);
        context = this;
        estrutura_btn_nova = findViewById(R.id.estrutura_btn_nova);
        listView = findViewById(R.id.listview_estrutura);

        estruturaArrayList = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            if (safra.getEstruturas() == null) {
                safra.setEstruturas(estruturaArrayList);
            } else {
                estruturaArrayList = safra.getEstruturas();
            }

            adapter = new EstruturaAdapter(context, estruturaArrayList);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }

        estrutura_btn_nova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alerta = null;
                LayoutInflater inflater = LayoutInflater.from(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                View layout = inflater.inflate(R.layout.nova_estrutura_fragmento, null);

                final EditText estrutura_nome_item = layout.findViewById(R.id.estrutura_nome_item);
                final EditText estrutura_valor_item = layout.findViewById(R.id.estrutura_valor_item);
                final EditText estrutura_vida_item = layout.findViewById(R.id.estrutura_vida_item);

                Button btn_concluir = layout.findViewById(R.id.btn_concluir);


                btn_concluir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        estruturaController = new EstruturaController(context);

                        Estrutura estrutura = new Estrutura();
                        estrutura.setNome_item(estrutura_nome_item.getText().toString());
                        try {
                            estrutura.setValor(estrutura_valor_item.getText().toString().substring(1));
                        } catch (Exception e) {

                        }
                        estrutura.setVidaUtil(estrutura_vida_item.getText().toString());

                        if (estruturaController.validarCadastroEstrutura(estrutura)) {
                            safraController = new SafraController(context);
                            safraRequest = new SafraRequest(context);

                            adapter.getEstruturaArrayList().add(estrutura);
                            safra.setEstruturas(adapter.getEstruturaArrayList());

                            safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), EstruturaActivity.this, "Cadastrar");

                        }

                    }
                });


                builder.setView(layout);
                alerta = builder.create();
                alerta.show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                safraRequest = new SafraRequest(context);
                estruturaController = new EstruturaController(context);
                safraController = new SafraController(context);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder
                        .setMessage("Escolha uma das opções")
                        .setCancelable(true)
                        .setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                AlertDialog alerta;
                                LayoutInflater inflater = LayoutInflater.from(context);
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                                View layout = inflater.inflate(R.layout.nova_estrutura_fragmento, null);

                                TextView titulo = layout.findViewById(R.id.textView);
                                titulo.setText("Alterar item");

                                final EditText estrutura_nome_item = layout.findViewById(R.id.estrutura_nome_item);
                                final EditText estrutura_valor_item = layout.findViewById(R.id.estrutura_valor_item);
                                final EditText estrutura_vida_item = layout.findViewById(R.id.estrutura_vida_item);

                                estrutura_nome_item.setText(estruturaArrayList.get(position).getNome_item());
                                estrutura_valor_item.setText(estruturaArrayList.get(position).getValor());
                                estrutura_vida_item.setText(estruturaArrayList.get(position).getVidaUtil());

                                Button btn_concluir = layout.findViewById(R.id.btn_concluir);

                                btn_concluir.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        estruturaArrayList.get(position).setNome_item(estrutura_nome_item.getText().toString());
                                        try {
                                            estruturaArrayList.get(position).setValor(estrutura_valor_item.getText().toString().substring(1));
                                        } catch (Exception e) {

                                        }
                                        estruturaArrayList.get(position).setVidaUtil(estrutura_vida_item.getText().toString());

                                        if (estruturaController.validarCadastroEstrutura(estruturaArrayList.get(position))) {

                                            safra.setEstruturas(estruturaArrayList);

                                            safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), EstruturaActivity.this, "Alterar");

                                        }
                                    }
                                });


                                builder.setView(layout);
                                alerta = builder.create();
                                alerta.show();

                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Apagar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                adapter.getEstruturaArrayList().remove(position);
                                safra.setEstruturas(adapter.getEstruturaArrayList());
                                safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), EstruturaActivity.this, "Apagar");
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }


    public void request_cadastro(Safra s) {

        adapter.setEstruturaArrayList(safra.getEstruturas());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        safra = s;
    }

    public void request_alterar(Safra s) {
        safra = s;
        adapter = new EstruturaAdapter(context, estruturaArrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void request_apagar(Safra s) {
        adapter.setEstruturaArrayList(safra.getEstruturas());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        safra = s;
    }
}