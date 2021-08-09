package com.example.tomateiro.view.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view_estrutura, parent, false);
        }

        TextView item_nome = convertView.findViewById(R.id.card_estrutura_nome_item);
        TextView item_valor = convertView.findViewById(R.id.card_estrutura_valor_item);
        TextView item_vida = convertView.findViewById(R.id.card_estrutura_vida_item);
        TextView item_categoria = convertView.findViewById(R.id.card_estrutura_categoria_item);
        TextView item_depreciacao = convertView.findViewById(R.id.card_estrutura_depreciacao_item);
        TextView item_data_cadastro = convertView.findViewById(R.id.card_estrutura_data_cadastro);
        TextView item_tempo_uso = convertView.findViewById(R.id.card_estrutura_tempo_uso);
        TextView item_tempo_uso_geral = convertView.findViewById(R.id.card_estrutura_tempo_uso_geral);
        TextView item_obs= convertView.findViewById(R.id.card_estrutura_ob_item);
        TextView item_dataReuso= convertView.findViewById(R.id.card_estrutura_dataReuso);

        item_nome.setText(estruturaArrayList.get(position).getNome_item());
        item_valor.setText("Valor R$: "+ estruturaArrayList.get(position).getValor());
        item_vida.setText("Vida útil/ meses: " + estruturaArrayList.get(position).getVidaUtil());
        item_categoria.setText("Categoria: " + estruturaArrayList.get(position).getCategoria());
        item_depreciacao.setText("Depreciação R$: " + estruturaArrayList.get(position).getDepreciacao());
        item_data_cadastro.setText("Data do cadastro: " + estruturaArrayList.get(position).getDataInicial());
        item_dataReuso.setText("Data de início de uso (Safra atual): " + estruturaArrayList.get(position).getDataReuso());
        item_tempo_uso.setText("Meses em uso (Safra atual): " + estruturaArrayList.get(position).caclcular_Duracao_meses(estruturaArrayList.get(position).getDataReuso()));
        item_tempo_uso_geral.setText("Meses em uso (Geral): " + estruturaArrayList.get(position).caclcular_Duracao_meses(
                estruturaArrayList.get(position).getDataInicial()));

        if(estruturaArrayList.get(position).caclcular_Duracao_meses(
                estruturaArrayList.get(position).getDataInicial()) >= Integer.parseInt(estruturaArrayList.get(position).getVidaUtil())){
            item_obs.setText("Vida útil atingida!");

        }

        return convertView;
    }

    public ArrayList<Estrutura> getEstruturaArrayList() {
        return estruturaArrayList;
    }

    public void setEstruturaArrayList(ArrayList<Estrutura> estruturaArrayList) {
        this.estruturaArrayList = estruturaArrayList;
    }
}
