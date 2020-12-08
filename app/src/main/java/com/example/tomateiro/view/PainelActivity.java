package com.example.tomateiro.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.view.adapter.SafraAdapter;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

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

        ItemTouchHelper helper = new ItemTouchHelper(
                new PainelActivity.ItemTouchHandler(0,
                        ItemTouchHelper.LEFT)
        );
        helper.attachToRecyclerView(recyclerView);

    }

    public class ItemTouchHandler extends ItemTouchHelper.SimpleCallback {

        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @SuppressLint("WrongConstant")
        @Override
        public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
            final int position = viewHolder.getAdapterPosition();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

            alertDialogBuilder
                    .setMessage("Deseja mesmo apagar essa safra?\nEsta ação não pode ser desfeita.")
                    .setCancelable(false)
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {

//                            mAdapter.getAmostragemslis().get(position).setEstado("Desabilitado");
//                            String json = amostragemController.converter_amostragem_json(mAdapter.getAmostragemslis().get(position));
//                            amostragemRequest.alterar_amostragem(json, token);
//
//                            mAdapter.getAmostragemslis().remove(position);
//                            mAdapter.notifyItemRemoved(position);

                            dialog.cancel();
                        }
                    })
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mAdapter.notifyItemRemoved(position);
                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();


        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder
                viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(PainelActivity.this, R.color.colorPrimary))
                    .addActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.perfil:
                AlertDialog alerta;
                LayoutInflater inflater = LayoutInflater.from(this.getApplicationContext());
                View layout = inflater.inflate(R.layout.activity_registro, null);

                TextView titulo = layout.findViewById(R.id.textView);
                titulo.setText("Alterar seus dados");

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(layout);
                alerta = builder.create();
                alerta.show();

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