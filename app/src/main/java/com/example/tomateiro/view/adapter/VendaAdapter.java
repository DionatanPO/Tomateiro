package com.example.tomateiro.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tomateiro.R;
import com.example.tomateiro.controller.VendaController;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.model.Venda;

import java.util.ArrayList;
import java.util.List;

import static com.example.tomateiro.model.CustonToast.viewToast;


public class VendaAdapter extends RecyclerView.Adapter<VendaAdapter.VendaViewHolder> {
    private Context context;
    private ArrayList<Venda> vendaList;
    private Intent intent;
    private int position;
    private Safra safra;
    private VendaController vendaController;

    public VendaAdapter(Context context, ArrayList<Venda> vendagemslis, Safra safra) {
        this.context = context;
        this.vendaList = vendagemslis;
        this.safra = safra;

    }

    @NonNull
    @Override
    public VendaAdapter.VendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_venda, parent, false);
        return new VendaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VendaAdapter.VendaViewHolder holder, int position) {
        holder.card_venda_id.setText(String.valueOf(vendaList.get(position).getId()));
        holder.card_venda_data.setText(vendaList.get(position).getVendaData());
        holder.card_venda_quantidade.setText(String.valueOf(vendaList.get(position).getQuantidade()));
        holder.card_venda_preco.setText(vendaList.get(position).getPreco());
    }

    public class VendaViewHolder extends RecyclerView.ViewHolder {


        TextView card_venda_id;
        TextView card_venda_data;
        TextView card_venda_quantidade;
        TextView card_venda_preco;


        public VendaViewHolder(View itemView) {
            super(itemView);

            card_venda_id = itemView.findViewById(R.id.card_venda_id);
            card_venda_data = itemView.findViewById(R.id.card_venda_data);
            card_venda_quantidade = itemView.findViewById(R.id.card_venda_quantidade);
            card_venda_preco = itemView.findViewById(R.id.card_venda_preco);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {

                        AlertDialog alerta;
                        LayoutInflater inflater = LayoutInflater.from(context);
                        View layout = inflater.inflate(R.layout.nova_venda_fragmento, null);

                        TextView titulo = layout.findViewById(R.id.textView);
                        titulo.setText("Alterar dados da venda");

                        Button btn_concluir = layout.findViewById(R.id.btn_concluir);
                        final EditText et_nova_venda_data = layout.findViewById(R.id.nova_venda_data);
                        final EditText et_nova_venda_quantidade = layout.findViewById(R.id.nova_venda_quantidade);
                        final EditText et_nova_venda_preco = layout.findViewById(R.id.nova_venda_preco);

                        et_nova_venda_data.setText(getVendaList().get(position).getVendaData());
                        et_nova_venda_quantidade.setText(String.valueOf(getVendaList().get(position).getQuantidade()));
                        et_nova_venda_preco.setText(getVendaList().get(position).getPreco());

                        btn_concluir.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                vendaController = new VendaController(context);

                                if (vendaController.validar_alterar(getVendaList().get(position))) {
                                    getVendaList().get(position).setVendaData(et_nova_venda_data.getText().toString());
                                    getVendaList().get(position).setQuantidade(Integer.parseInt(et_nova_venda_quantidade.getText().toString()));
                                    getVendaList().get(position).setPreco(et_nova_venda_preco.getText().toString());

                                    //Fazer request para atualizar dados
                                    safra.setVendas(getVendaList());
                                } else {

                                }

                            }
                        });

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout);
                        alerta = builder.create();
                        alerta.show();

                    }

                }
            });


        }

    }

    public ArrayList<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(ArrayList<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int getItemCount() {
        return vendaList.size();
    }

    public void request_alterarDados(Safra safra) {

        this.notifyDataSetChanged();
        viewToast(context, "Dados da vebda alterados!");
    }

}