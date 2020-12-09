package com.example.tomateiro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;


import com.example.tomateiro.R;
import com.example.tomateiro.RelatorioActivity;
import com.example.tomateiro.view.custo.CustoA_Activity;
import com.example.tomateiro.view.custo.CustoB_Activity;
import com.example.tomateiro.view.custo.CustoC_Activity;
import com.example.tomateiro.view.custo.CustoD_Activity;

public class PainelActivity extends AppCompatActivity {
    private Button btn_safra_menu, btn_s_t_g, btn_relatorio;
    private Context context;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel);

        context = this;

        View card_safra = findViewById(R.id.card_safra);

        btn_safra_menu = findViewById(R.id.btn_safra_menu);
        btn_s_t_g = findViewById(R.id.painel_btn_g_t_e);
        btn_relatorio = findViewById(R.id.painel_btn_relatorio);

        btn_relatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, RelatorioActivity.class);
                context.startActivity(intent);
            }
        });

        btn_safra_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, btn_safra_menu);

                popup.getMenuInflater()
                        .inflate(R.menu.safra_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    AlertDialog alerta;
                    LayoutInflater inflater = LayoutInflater.from(context);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View layout;

                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.novaSafra:

                                layout = inflater.inflate(R.layout.nova_safra_fragmento, null);
                                builder.setView(layout);
                                alerta = builder.create();
                                alerta.show();

                                return true;
                            case R.id.perfil:

                                layout = inflater.inflate(R.layout.activity_registro, null);
                                TextView titulo = layout.findViewById(R.id.textView);
                                titulo.setText("Alterar seus dados");
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
                PopupMenu popup = new PopupMenu(context, btn_s_t_g);

                popup.getMenuInflater()
                        .inflate(R.menu.custo_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.custoA:
                                intent = new Intent(context, CustoA_Activity.class);
                                context.startActivity(intent);

                                return true;
                            case R.id.custoB:
                                intent = new Intent(context, CustoB_Activity.class);
                                context.startActivity(intent);

                                return true;
                            case R.id.custoC:
                                intent = new Intent(context, CustoC_Activity.class);
                                context.startActivity(intent);

                                return true;
                            case R.id.custoD:
                                intent = new Intent(context, CustoD_Activity.class);
                                context.startActivity(intent);

                                return true;

                            default:
                                return false;
                        }

                    }
                });

                popup.show();
            }
        });

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
}