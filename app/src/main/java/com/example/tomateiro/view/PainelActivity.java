package com.example.tomateiro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.view.adapter.SafraAdapter;

import java.util.ArrayList;

public class PainelActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Button btn_safra_menu, btn_nova_safra;
    private Context context;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private SafraAdapter mAdapter;
    private ArrayList<Safra> safraArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel);
        context = this;

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Lista de teste
        safraArrayList = new ArrayList<>();
        Safra s1 = new Safra();
        safraArrayList.add(s1);
        Safra s2 = new Safra();
        safraArrayList.add(s2);
        Safra s3 = new Safra();
        safraArrayList.add(s3);
        Safra s4 = new Safra();
        safraArrayList.add(s4);
        //--------------------------

        mAdapter = new SafraAdapter(this, safraArrayList);
        recyclerView.setAdapter(mAdapter);

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

                AlertDialog alerta;

                LayoutInflater inflater = LayoutInflater.from(context);
                View layout = inflater.inflate(R.layout.nova_safra_fragmento, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(layout);
                alerta = builder.create();
                alerta.show();

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
                cv.showDialog(this, getResources().getString(R.string.sobre), "Sobre");

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