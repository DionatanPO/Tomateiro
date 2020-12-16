package com.example.tomateiro.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.EditText;
import android.widget.TextView;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.model.Venda;
import com.example.tomateiro.view.adapter.VendaAdapter;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class VendaActivity extends AppCompatActivity {
    private Button btn_venda_menu;
    private Context context;
    private TextView msg;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private VendaAdapter mAdapter;
    private ArrayList<Venda> vendaList;
    private Produtor produtor;
    private Safra safra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);
        context = this;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            produtor = (Produtor) getIntent().getSerializableExtra("produtor");
            safra = (Safra) getIntent().getSerializableExtra("safra");
        }

        msg = findViewById(R.id.mensagem);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        vendaList = new ArrayList<>();
        mAdapter = new VendaAdapter(context, vendaList, safra);

        recyclerView.setVisibility(View.GONE);

        btn_venda_menu = findViewById(R.id.btn_venda_menu);
        btn_venda_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(context, btn_venda_menu);

                popup.getMenuInflater()
                        .inflate(R.menu.venda_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    AlertDialog alerta;
                    LayoutInflater inflater = LayoutInflater.from(context);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View layout;

                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nova_venda:
                                final Venda venda = new Venda();

                                layout = inflater.inflate(R.layout.nova_venda_fragmento, null);
                                Button btn_concluir = layout.findViewById(R.id.btn_concluir);
                                final EditText et_nova_venda_data = layout.findViewById(R.id.nova_venda_data);
                                final EditText et_nova_venda_quantidade = layout.findViewById(R.id.nova_venda_quantidade);
                                final EditText et_nova_venda_preco = layout.findViewById(R.id.nova_venda_preco);


                                btn_concluir.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        venda.setEstado("Disponivel");
                                        venda.setVendaData(et_nova_venda_data.getText().toString());
                                        venda.setQuantidade(Integer.parseInt(et_nova_venda_quantidade.getText().toString()));
                                        venda.setPreco(et_nova_venda_preco.getText().toString());

                                        //fazer requisiçao para alterar dados da safra
//                                        vendaList.add(venda);
//                                        safra.setVendas(vendaList);

                                        request_cadastrarVenda(venda);
                                    }
                                });


                                builder.setView(layout);
                                alerta = builder.create();
                                alerta.show();

                                return true;

                            default:
                                return false;
                        }

                    }
                });

                popup.show();
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(
                new VendaActivity.ItemTouchHandler(0,
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
                    .setMessage("Deseja mesmo apagar essa venda?\nEsta ação não pode ser desfeita.")
                    .setCancelable(false)
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {

                            mAdapter.getVendaList().get(position).setEstado("Desabilitado");
//                            String json = amostragemController.converter_amostragem_json(mAdapter.getAmostragemslis().get(position));
//                            amostragemRequest.alterar_amostragem(json, token);

                            mAdapter.getVendaList().remove(position);
                            mAdapter.notifyItemRemoved(position);
                            //fazer requisiçao para alterar dados da safra
                            safra.setVendas(mAdapter.getVendaList());
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
                    .addBackgroundColor(ContextCompat.getColor(VendaActivity.this, R.color.alerta_vermelho))
                    .addActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

    }

    public void request_buscarVendas(ArrayList<Venda> list) {
        msg.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        vendaList = list;
        mAdapter.setVendaList(vendaList);
        mAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(mAdapter);
    }

    public void request_cadastrarVenda(Venda v) {
        msg.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        mAdapter.getVendaList().add(v);
        mAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(mAdapter);
        viewToast(context, "Venda cadastrada!");
    }
}