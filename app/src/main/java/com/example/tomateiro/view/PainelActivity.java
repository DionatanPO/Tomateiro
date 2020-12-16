package com.example.tomateiro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;


import com.example.tomateiro.R;
import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.model.Venda;
import com.example.tomateiro.view.custo.CustoA_Activity;
import com.example.tomateiro.view.custo.CustoB_Activity;
import com.example.tomateiro.view.custo.CustoC_Activity;
import com.example.tomateiro.view.custo.CustoD_Activity;

import java.util.ArrayList;

import static com.example.tomateiro.model.CustonToast.viewToast;
import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class PainelActivity extends AppCompatActivity {
    private Button btn_safra_menu, btn_s_t_g, btn_relatorio, btn_venda;
    private Context context;
    private Intent intent;
    private Safra safra;
    private View card_safra;
    private TextView msg, painel_produtor;
    private Produtor produtor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            produtor = (Produtor) getIntent().getSerializableExtra("produtor");
        }

        context = this;

        card_safra = findViewById(R.id.card_safra);
        msg = findViewById(R.id.mensagem);
        painel_produtor = findViewById(R.id.painel_proprietario);
        painel_produtor.setText(painel_produtor.getText().toString() + produtor.getNome());

        btn_safra_menu = findViewById(R.id.btn_safra_menu);
        btn_s_t_g = findViewById(R.id.painel_btn_g_t_e);
        btn_relatorio = findViewById(R.id.painel_btn_relatorio);
        btn_venda = findViewById(R.id.painel_btn_venda);

        if (safra != null) {
            card_safra.setVisibility(View.VISIBLE);
            msg.setVisibility(View.GONE);
        } else {

        }
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
                    context.startActivity(intent);
                } else {
                    viewToastAlerta(context, "Cadastre uma nova safra para poder vesualizar o relatório.");
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

                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.novaSafra:
                                safra = new Safra();

                                layout = inflater.inflate(R.layout.nova_safra_fragmento, null);

                                Button btn_concluir = layout.findViewById(R.id.btn_concluir);
                                final EditText et_nova_safra_pes = layout.findViewById(R.id.nova_safra_pes);
                                final EditText et_nova_safra_ciclo = layout.findViewById(R.id.nova_safra_ciclo);
                                final EditText et_nova_safra_regiao = layout.findViewById(R.id.nova_safra_regiao);


                                btn_concluir.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        safra = teste();
                                        safra.setEstado("Disponivel");
                                        safra.setClicloAno(et_nova_safra_ciclo.getText().toString());
                                        safra.setRegiaoReferencia(et_nova_safra_regiao.getText().toString());
                                        safra.setQtdePes(Integer.parseInt(et_nova_safra_pes.getText().toString()));

                                        card_safra.setVisibility(View.VISIBLE);
                                        msg.setVisibility(View.GONE);
                                        //fazer request para salvar safra
                                        request_cadastrar_novaSafra(safra);

                                        alerta.cancel();
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

                                final EditText nome, propriedade, identificacao;
                                Button button_concluir;

                                button_concluir = layout.findViewById(R.id.btn_concluir);

                                nome = layout.findViewById(R.id.registro_nome);
                                propriedade = layout.findViewById(R.id.registro_propriedade);
                                identificacao = layout.findViewById(R.id.registro_identificacao);

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
                                        request_alterar_dados_perfil(produtor);
                                        alerta.cancel();

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

    public void request_cadastrar_novaSafra(Safra safra) {
        viewToast(context, "Safra cadastrada!");
    }

    public void request_alterar_dados_perfil(Produtor produtor) {
        viewToast(context, "Iformações alteradas!");
    }

    public void request_alterar_dados_senha(Produtor produtor) {
        viewToast(context, "Iformações alteradas!");
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

    public Safra teste() {
        Safra safra = new Safra();
        safra.setClicloAno("1");
        safra.setQtdePes(1000);
        safra.setRegiaoReferencia("São Paulo");

        Venda venda = new Venda();
        venda.setPesoCaixa("22,00");
        ;
        venda.setPreco("10,00");
        venda.setQuantidade(10);

        Venda venda2 = new Venda();
        venda2.setPesoCaixa("22,00");
        ;
        venda2.setPreco("10,00");
        venda2.setQuantidade(10);

        Venda venda3 = new Venda();
        venda3.setPesoCaixa("22,00");
        ;
        venda3.setPreco("10,00");
        venda3.setQuantidade(10);

        ArrayList<Venda> vendas = new ArrayList<>();
        vendas.add(venda);
        vendas.add(venda2);
        vendas.add(venda3);

        safra.setVendas(vendas);
        return safra;
    }
}