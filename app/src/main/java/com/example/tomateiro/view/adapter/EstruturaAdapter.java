package com.example.tomateiro.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Estrutura;

import java.util.ArrayList;

public class EstruturaAdapter extends ArrayAdapter<Estrutura> {

    ArrayList<Estrutura> estruturaArrayList;
    Context context;

    public EstruturaAdapter(@NonNull Context context, ArrayList<Estrutura> estruturaArrayList) {
        super(context, 0, estruturaArrayList);
        this.estruturaArrayList = estruturaArrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view_estrutura, parent, false);
        }

        TextView item_nome = convertView.findViewById(R.id.card_estrutura_nome_item);
        TextView item_valor = convertView.findViewById(R.id.card_estrutura_valor_item);
        TextView item_vida = convertView.findViewById(R.id.card_estrutura_vida_item);

        item_nome.setText("Item: "+ estruturaArrayList.get(position).getNome_item());
        item_valor.setText("Valor R$: "+ estruturaArrayList.get(position).getValor());
        item_vida.setText("Vida útil mês: " + estruturaArrayList.get(position).getVidaUtil());

        return convertView;
    }

    public ArrayList<Estrutura> getEstruturaArrayList() {
        return estruturaArrayList;
    }

    public void setEstruturaArrayList(ArrayList<Estrutura> estruturaArrayList) {
        this.estruturaArrayList = estruturaArrayList;
    }
}
