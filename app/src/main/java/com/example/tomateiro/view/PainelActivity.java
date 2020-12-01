package com.example.tomateiro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.example.tomateiro.R;

import com.example.tomateiro.view.custo.CustoE_Activity;


public class PainelActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Button btn_safra_menu, btn_nova_safra;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel);
        context = this;

        btn_safra_menu = findViewById(R.id.btn_safra_menu);

        btn_safra_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(PainelActivity.this, view);
                popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) context);
                popup.inflate(R.menu.safra_menu);
                popup.show();
            }
        });

        btn_nova_safra = findViewById(R.id.btn_nova_safra);
        btn_nova_safra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, CustoE_Activity.class);
                startActivity(intent);

//                AlertDialog alerta;
//
//                LayoutInflater inflater = LayoutInflater.from(context);
//                View layout = inflater.inflate(R.layout.nova_safra_fragmento, null);
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setView(layout);
//                alerta = builder.create();
//                alerta.show();


            }
        });


    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.perfil:


                return true;
            case R.id.ajuda:

                androidx.appcompat.app.AlertDialog.Builder alertDialogBuilder = new androidx.appcompat.app.AlertDialog.Builder(this);
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
                cv.showDialog(this,  getResources().getString(R.string.sobre), "Sobre");


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