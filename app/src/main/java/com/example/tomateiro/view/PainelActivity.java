package com.example.tomateiro.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;


import com.example.tomateiro.R;
import com.example.tomateiro.controller.ProdutorController;
import com.example.tomateiro.controller.SafraController;
import com.example.tomateiro.model.CustoA;
import com.example.tomateiro.model.CustoB;
import com.example.tomateiro.model.CustoC;
import com.example.tomateiro.model.CustoD;
import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.model.Venda;
import com.example.tomateiro.request.ProdutorRequest;
import com.example.tomateiro.request.SafraRequest;
import com.example.tomateiro.view.custo.CustoA_Activity;
import com.example.tomateiro.view.custo.CustoB_Activity;
import com.example.tomateiro.view.custo.CustoC_Activity;
import com.example.tomateiro.view.custo.CustoD_Activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.tomateiro.model.CustonToast.viewToast;
import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class PainelActivity extends AppCompatActivity {
    private Button btn_safra_menu, btn_s_t_g, btn_relatorio, btn_venda, btn_estrutura;
    private Context context;
    private Intent intent;
    private Safra safra;
    private SafraController safraController;
    private ProdutorController produtorController;
    private View card_safra;
    private TextView msg, painel_produtor, txt_painel_card_safra_data, txt_painel_card_ciclo, txt_painel_card_qtde_pes, txt_painel_card_regiao;
    private Produtor produtor;
    private SafraRequest safraRequest;
    private ProdutorRequest produtorRequest;

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            produtor = (Produtor) getIntent().getSerializableExtra("produtor");

        }

        context = this;

        produtorController = new ProdutorController(context);
        safraController = new SafraController(context);
        safraRequest = new SafraRequest(context);
        produtorRequest = new ProdutorRequest(context);

        card_safra = findViewById(R.id.card_safra);
        msg = findViewById(R.id.mensagem);
        painel_produtor = findViewById(R.id.painel_proprietario);
        painel_produtor.setText(painel_produtor.getText().toString() + produtor.getNome());

        btn_safra_menu = findViewById(R.id.btn_safra_menu);
        btn_s_t_g = findViewById(R.id.painel_btn_g_t_e);
        btn_relatorio = findViewById(R.id.painel_btn_relatorio);
        btn_venda = findViewById(R.id.painel_btn_venda);
        btn_estrutura = findViewById(R.id.painel_btn_estrutura);

        txt_painel_card_safra_data = findViewById(R.id.painel_card_safra_data);
        txt_painel_card_ciclo = findViewById(R.id.painel_card_cocloAno);
        txt_painel_card_qtde_pes = findViewById(R.id.painel_card_qtde_pes);
        txt_painel_card_regiao = findViewById(R.id.painel_card_regiao);


        //------------buscando safra ativa-------------------------------------
//        safraRequest.buscar_safra_produtor(produtorController.converter_produtor_json(produtor), PainelActivity.this);

        card_safra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = LayoutInflater.from(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View layout;

                layout = inflater.inflate(R.layout.nova_safra_fragmento, null);

                Button btn_concluir = layout.findViewById(R.id.btn_concluir);
                TextView textView = layout.findViewById(R.id.textView);
                textView.setText(" Alterar dados da safra");

                final EditText et_nova_safra_pes = layout.findViewById(R.id.nova_safra_pes);
                final EditText et_nova_safra_ciclo = layout.findViewById(R.id.nova_safra_ciclo);
                final EditText et_nova_safra_regiao = layout.findViewById(R.id.nova_safra_regiao);
                final EditText et_nova_safra_data = layout.findViewById(R.id.nova_safra_data);

                et_nova_safra_pes.setText(String.valueOf(safra.getQtdePes()));
                et_nova_safra_ciclo.setText(safra.getClicloAno());
                et_nova_safra_regiao.setText(safra.getRegiaoReferencia());
                et_nova_safra_data.setText(safra.getData());


                btn_concluir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        safra.setClicloAno(et_nova_safra_ciclo.getText().toString());
                        safra.setRegiaoReferencia(et_nova_safra_regiao.getText().toString());
                        safra.setData(et_nova_safra_data.getText().toString());
                        try {
                            safra.setQtdePes(Integer.parseInt(et_nova_safra_pes.getText().toString()));
                        } catch (Exception e) {
                            safra.setQtdePes(0);
                        }

                        if (safraController.validar_alterar(safra)) {
                            safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), PainelActivity.this);

                            alerta.cancel();
                        } else {

                        }


                    }
                });

                builder.setView(layout);
                alerta = builder.create();
                alerta.show();
            }
        });

        btn_venda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (safra != null) {
                    intent = new Intent(context, VendaActivity.class);
                    intent.putExtra("safra", safra);
                    context.startActivity(intent);
                } else {
                    viewToastAlerta(context, "Cadastre uma nova safra para poder vesualizar venda.");
                }
            }
        });

        btn_relatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (safra != null) {
                    intent = new Intent(context, RelatorioActivity.class);
                    intent.putExtra("safra", safra);
                    intent.putExtra("produtor", produtor);
                    context.startActivity(intent);
                } else {
                    viewToastAlerta(context, "Cadastre uma nova safra para poder vesualizar o relatório.");
                }

            }
        });

        btn_estrutura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (safra != null) {
                    intent = new Intent(context, EstruturaActivity.class);
                    intent.putExtra("safra", safra);
                    context.startActivity(intent);
                } else {
                    viewToastAlerta(context, "Cadastre uma nova safra para poder vesualizar estrutura.");
                }

            }
        });

        btn_safra_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(context, btn_safra_menu);

                popup.getMenuInflater()
                        .inflate(R.menu.painel_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    AlertDialog alerta;
                    LayoutInflater inflater = LayoutInflater.from(context);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View layout;

                    @SuppressLint("SetTextI18n")
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.novaSafra:
                                layout = inflater.inflate(R.layout.nova_safra_fragmento, null);

                                Button btn_concluir = layout.findViewById(R.id.btn_concluir);
                                final EditText et_nova_safra_pes = layout.findViewById(R.id.nova_safra_pes);
                                final EditText et_nova_safra_ciclo = layout.findViewById(R.id.nova_safra_ciclo);
                                final EditText et_nova_safra_regiao = layout.findViewById(R.id.nova_safra_regiao);
                                final EditText et_nova_safra_data = layout.findViewById(R.id.nova_safra_data);

                                SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
                                Date data = new Date();
                                String dataFormatada = formataData.format(data);

                                et_nova_safra_data.setText(dataFormatada);

                                btn_concluir.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        if (safra != null) {

                                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                                            alertDialogBuilder
                                                    .setMessage("Ao cadastrar uma nova safra, implica em concluir a safra atual. Deseja concluir a safra atual?")
                                                    .setCancelable(false)
                                                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            Safra novaSafra = new Safra();

                                                            safra.setEstado("Concluida");
                                                           final Safra safraAnterior = safra;

                                                            novaSafra.setClicloAno(et_nova_safra_ciclo.getText().toString());
                                                            novaSafra.setRegiaoReferencia(et_nova_safra_regiao.getText().toString());
                                                            novaSafra.setData(et_nova_safra_data.getText().toString());

                                                            try {
                                                                novaSafra.setQtdePes(Integer.parseInt(et_nova_safra_pes.getText().toString()));
                                                            } catch (Exception e) {
                                                                novaSafra.setQtdePes(0);
                                                            }


                                                            //fazer request para salvar safra
                                                            if (safraController.validar_cadastro(novaSafra)) {

                                                                safraRequest.alterrar_safra(safraController.converter_safra_json(safraAnterior), safraAnterior.getId(), PainelActivity.this);

                                                                novaSafra.setEstado("Ativo");
                                                                novaSafra.setProdutor(produtor);
                                                                novaSafra.setClicloAno(et_nova_safra_ciclo.getText().toString());
                                                                novaSafra.setRegiaoReferencia(et_nova_safra_regiao.getText().toString());
                                                                novaSafra.setData(et_nova_safra_data.getText().toString());

                                                                safraRequest.cadastrar_safra(safraController.converter_safra_json(novaSafra), PainelActivity.this);

                                                                alerta.cancel();
                                                            } else {

                                                            }

                                                            dialog.cancel();
                                                        }
                                                    })
                                                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {

                                                            dialog.cancel();
                                                        }
                                                    });

                                            AlertDialog alertDialog = alertDialogBuilder.create();
                                            alertDialog.show();

                                        } else {
                                            safra = new Safra();

                                            safra.setClicloAno(et_nova_safra_ciclo.getText().toString());
                                            safra.setRegiaoReferencia(et_nova_safra_regiao.getText().toString());
                                            safra.setData(et_nova_safra_data.getText().toString());
                                            try {
                                                safra.setQtdePes(Integer.parseInt(et_nova_safra_pes.getText().toString()));
                                            } catch (Exception e) {
                                                safra.setQtdePes(0);
                                            }


                                            //fazer request para salvar safra
                                            if (safraController.validar_cadastro(safra)) {
                                                safra.setProdutor(produtor);
                                                safra.setEstado("Ativo");
                                                safraRequest.cadastrar_safra(safraController.converter_safra_json(safra), PainelActivity.this);

                                                alerta.cancel();
                                            } else {

                                            }

                                        }


                                    }
                                });

                                builder.setView(layout);
                                alerta = builder.create();
                                alerta.show();

                                return true;
                            case R.id.perfil:

                                layout = inflater.inflate(R.layout.activity_registro, null);
                                TextView titulo = layout.findViewById(R.id.textView);
                                titulo.setText("Alterar seus dados");

                                final EditText nome, propriedade, identificacao, senha1, senha2;
                                Button button_concluir;
                                TextView txt_senha1, txt_senha2;

                                button_concluir = layout.findViewById(R.id.btn_concluir);

                                nome = layout.findViewById(R.id.registro_nome);
                                propriedade = layout.findViewById(R.id.registro_propriedade);
                                identificacao = layout.findViewById(R.id.registro_identificacao);

                                txt_senha1 = layout.findViewById(R.id.txt_senha1);
                                txt_senha2 = layout.findViewById(R.id.txt_senha2);

                                txt_senha1.setVisibility(View.GONE);
                                txt_senha2.setVisibility(View.GONE);

                                senha1 = layout.findViewById(R.id.senha1);
                                senha2 = layout.findViewById(R.id.senha2);

                                senha1.setVisibility(View.GONE);
                                senha2.setVisibility(View.GONE);

                                nome.setText(produtor.getNome());
                                propriedade.setText(produtor.getPropriedade());
                                identificacao.setText(produtor.getCodIdentificacao());

                                button_concluir.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        produtor.setNome(nome.getText().toString());
                                        produtor.setPropriedade(propriedade.getText().toString());
                                        produtor.setCodIdentificacao(identificacao.getText().toString());

                                        //fazer rquest para alterar dados do produtor
                                        if (produtorController.validar_alterar_perfil(produtor)) {
                                            produtorRequest.alterrar_produtor(produtorController.converter_produtor_json(produtor), produtor.getId(), PainelActivity.this);

                                            alerta.cancel();
                                        } else {

                                        }


                                    }
                                });

                                builder.setView(layout);
                                alerta = builder.create();
                                alerta.show();

                                return true;
                            case R.id.senha:

                                layout = inflater.inflate(R.layout.activity_registro, null);
                                titulo = layout.findViewById(R.id.textView);

                                TextView txt_nome, txt_propriedade, txt_codigo;

                                txt_nome = layout.findViewById(R.id.txt_nome);
                                txt_propriedade = layout.findViewById(R.id.txt_propriedade);
                                txt_codigo = layout.findViewById(R.id.txt_codigo);

                                txt_nome.setVisibility(View.GONE);
                                txt_propriedade.setVisibility(View.GONE);
                                txt_codigo.setVisibility(View.GONE);

                                titulo.setText("Alterar seus dados");


                                button_concluir = layout.findViewById(R.id.btn_concluir);

                                nome = layout.findViewById(R.id.registro_nome);
                                propriedade = layout.findViewById(R.id.registro_propriedade);
                                identificacao = layout.findViewById(R.id.registro_identificacao);

                                senha1 = layout.findViewById(R.id.senha1);
                                senha2 = layout.findViewById(R.id.senha2);

                                nome.setVisibility(View.GONE);
                                propriedade.setVisibility(View.GONE);
                                identificacao.setVisibility(View.GONE);


                                button_concluir.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        produtor.setSenha(senha1.getText().toString());

                                        //fazer rquest para alterar dados do produtor
                                        if (produtorController.validar_alterar_senha(produtor, senha2.getText().toString())) {
                                            produtorRequest.alterrar_produtor(produtorController.converter_produtor_json(produtor), produtor.getId(), PainelActivity.this);
                                            alerta.cancel();
                                        } else {

                                        }


                                    }
                                });

                                builder.setView(layout);
                                alerta = builder.create();
                                alerta.show();

                                return true;
                            case R.id.ajuda:
                                androidx.appcompat.app.AlertDialog.Builder alertDialogBuilder = new androidx.appcompat.app.AlertDialog.Builder(context);
                                alertDialogBuilder.setTitle("Ajuda");

                                alertDialogBuilder
                                        .setMessage("")
                                        .setCancelable(false)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                dialog.cancel();
                                            }
                                        });

                                androidx.appcompat.app.AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.show();

                                return true;

                            case R.id.sobre:
                                CustonView cv = new CustonView();
                                cv.showDialog(PainelActivity.this, getResources().getString(R.string.sobre), "Sobre");

                                return true;
                            case R.id.sair:
                                Intent intent = new Intent(PainelActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();

                                return true;

                            default:
                                return false;
                        }

                    }
                });

                popup.show();
            }
        });

        btn_s_t_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (safra != null) {
                    PopupMenu popup = new PopupMenu(context, btn_s_t_g);

                    popup.getMenuInflater()
                            .inflate(R.menu.custo_menu, popup.getMenu());

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.custoA:
                                    intent = new Intent(context, CustoA_Activity.class);
                                    intent.putExtra("safra", safra);
                                    context.startActivity(intent);

                                    return true;
                                case R.id.custoB:
                                    intent = new Intent(context, CustoB_Activity.class);
                                    intent.putExtra("safra", safra);
                                    context.startActivity(intent);

                                    return true;
                                case R.id.custoC:
                                    intent = new Intent(context, CustoC_Activity.class);
                                    intent.putExtra("safra", safra);
                                    context.startActivity(intent);

                                    return true;
                                case R.id.custoD:
                                    intent = new Intent(context, CustoD_Activity.class);
                                    intent.putExtra("safra", safra);
                                    context.startActivity(intent);

                                    return true;

                                default:
                                    return false;
                            }

                        }
                    });

                    popup.show();
                } else {
                    viewToastAlerta(context, "Cadastre uma nova safra para caclcular os gastos.");
                }


            }
        });

    }

    public void request_cadastrar_novaSafra(Safra s) {
        safra = s;
        txt_painel_card_safra_data.setText(safra.getData());
        txt_painel_card_ciclo.setText(safra.getClicloAno());
        txt_painel_card_qtde_pes.setText(String.valueOf(safra.getQtdePes()));
        txt_painel_card_regiao.setText(safra.getRegiaoReferencia());


        card_safra.setVisibility(View.VISIBLE);
        msg.setVisibility(View.GONE);

    }

    public void request_buscar_safra(Safra s) {
        safra = s;
        txt_painel_card_safra_data.setText(safra.getData());
        txt_painel_card_ciclo.setText(safra.getClicloAno());
        txt_painel_card_qtde_pes.setText(String.valueOf(safra.getQtdePes()));
        txt_painel_card_regiao.setText(safra.getRegiaoReferencia());

        card_safra.setVisibility(View.VISIBLE);
        msg.setVisibility(View.GONE);

    }

    public void request_alterar_safra(Safra s) {
        safra = s;
        txt_painel_card_safra_data.setText(safra.getData());
        txt_painel_card_ciclo.setText(safra.getClicloAno());
        txt_painel_card_qtde_pes.setText(String.valueOf(safra.getQtdePes()));
        txt_painel_card_regiao.setText(safra.getRegiaoReferencia());

        card_safra.setVisibility(View.VISIBLE);
        msg.setVisibility(View.GONE);

    }

    public void request_alterar_dados_produtor(Produtor p) {
        produtor = p;
        painel_produtor.setText(painel_produtor.getText().toString() + produtor.getNome());
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder
                .setMessage("Deseja mesmo sair?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(context, LoginActivity.class);
                        startActivity(intent);
                        finishAffinity();

                        dialog.cancel();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        safraRequest.buscar_safra_produtor(produtor.getId(), "Ativo", PainelActivity.this);
    }
}