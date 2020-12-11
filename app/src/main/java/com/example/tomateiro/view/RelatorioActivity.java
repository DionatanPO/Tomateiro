package com.example.tomateiro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Safra;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;

public class RelatorioActivity extends AppCompatActivity {
    private PieChart pieChart, pieChart2, pieChart3, pieChart4;
    private PieDataSet pieDataSet;
    private PieData pieData;
    private ArrayList<PieEntry> pieEntries;
    private Safra safra;

    private TextView
            r_qtd_total_caixa,
            r_ciclo,
            r_peso_medio_caixa,
            r_qtd_pes,
            r_regiao_referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        //Definindo variaves
        r_qtd_total_caixa = findViewById(R.id.relatorio_qtd_total_caixa);
        r_ciclo = findViewById(R.id.relatorio_ciclo);
        r_peso_medio_caixa = findViewById(R.id.relatorio_peso_caixa);
        r_qtd_pes = findViewById(R.id.relatorio_qtde_pes);
        r_regiao_referencia = findViewById(R.id.relatorio_regiao_referencia);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            safra = safra.calcularQtdeCaixasVendidas(safra);
            safra = safra.calcularPesoMedioCaixa(safra);

        } else {
            safra = new Safra();
        }

        ///Setar valores
        try {
            r_ciclo.setText(safra.getClicloAno());
            r_qtd_pes.setText(String.valueOf(safra.getQtdePes()));
            r_regiao_referencia.setText(safra.getRegiaoReferencia());
            r_peso_medio_caixa.setText(safra.getPesoMedioCaixas());
            r_qtd_total_caixa.setText(String.valueOf(safra.getQtdeCaixas()));
        } catch (Exception e) {

        }

        //--------------------------------------------------------

        pieChart = findViewById(R.id.grafico1);
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(20, "Final"));
        pieEntries.add(new PieEntry(20, "Inicio"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
//        pieDataSet.setColors(new int[]{R.color.color1, R.color.color2, R.color.color3}, RelatorioActivity.this);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(WHITE);
        pieDataSet.setValueLineColor(WHITE);
        pieDataSet.setValueTextSize(11f);
        pieDataSet.setFormSize(11f);

        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setCenterText("");
        pieChart.getLegend().setEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.animateX(1000);
        pieChart.animateY(500);
        //----------------------------------------------------------
        pieChart2 = findViewById(R.id.grafico2);

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(20, "Final"));
        pieEntries.add(new PieEntry(20, "Inicio"));
        pieEntries.add(new PieEntry(20, "kkkkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setValueTextColor(WHITE);
        pieDataSet.setValueLineColor(WHITE);
        pieDataSet.setValueTextSize(11f);
        pieDataSet.setFormSize(11f);

        pieData = new PieData(pieDataSet);
        pieChart2.setData(pieData);
        pieChart2.setCenterText("");
        pieChart2.getLegend().setEnabled(false);
        pieChart2.getDescription().setEnabled(false);
        pieChart2.animateX(1000);
        pieChart2.animateY(500);
        //----------------------------------------------------------
        pieChart3 = findViewById(R.id.grafico3);

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(20, "Final"));
        pieEntries.add(new PieEntry(20, "Inicio"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));
        pieEntries.add(new PieEntry(20, "kkkkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        pieDataSet.setValueTextColor(WHITE);
        pieDataSet.setValueLineColor(WHITE);
        pieDataSet.setValueTextSize(11f);
        pieDataSet.setFormSize(11f);

        pieData = new PieData(pieDataSet);
        pieChart3.setData(pieData);
        pieChart3.setCenterText("");
        pieChart3.getLegend().setEnabled(false);
        pieChart3.getDescription().setEnabled(false);
        pieChart3.animateX(1000);
        pieChart3.animateY(500);
        //----------------------------------------------------------
        pieChart4 = findViewById(R.id.grafico4);

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(20, "Final"));
        pieEntries.add(new PieEntry(20, "Inicio"));
        pieEntries.add(new PieEntry(20, "Inicio"));
        pieEntries.add(new PieEntry(20, "kkkkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieDataSet.setValueTextColor(WHITE);
        pieDataSet.setValueTextSize(11f);
        pieDataSet.setFormSize(11f);

        pieData = new PieData(pieDataSet);
        pieChart4.setData(pieData);
        pieChart4.setCenterText("");
        pieChart4.getLegend().setEnabled(false);
        pieChart4.getDescription().setEnabled(false);
        pieChart4.animateX(1000);
        pieChart4.animateY(500);

        //-----------------------------------------------------------------------------
        BarChart barChart = findViewById(R.id.barchart);


        ArrayList barEntries = new ArrayList<>();


        barEntries.add(new BarEntry(2015, safra.getQtdeCaixas()));
        barEntries.add(new BarEntry(2016, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 100));
        barEntries.add(new BarEntry(2017, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));
        barEntries.add(new BarEntry(2018, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));
        barEntries.add(new BarEntry(2019, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));
        barEntries.add(new BarEntry(2020, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));


        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        barDataSet.setColors(WHITE);
        barDataSet.setValueTextColor(WHITE);
        barDataSet.setValueTextSize(18f);

        barChart.getAxisLeft().setTextColor(WHITE);
        barChart.getAxisRight().setTextColor(WHITE);
        barChart.getXAxis().setTextColor(WHITE);
        barChart.getLegend().setTextColor(WHITE);
        barChart.getDescription().setEnabled(false);
        barChart.animateY(4000);
        barChart.setFitBars(false);
        //--------------------------------------------------------------------
    }

}