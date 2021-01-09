package com.example.tomateiro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tomateiro.model.Safra;
import com.example.tomateiro.view.RelatorioActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;

public class GraficoActivity extends AppCompatActivity {
    private PieChart pieChart;
    private PieDataSet pieDataSet;
    private PieData pieData;
    private ArrayList<PieEntry> pieEntries;
    private Safra safra;
    private String acao;

    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        titulo = findViewById(R.id.textView);
        pieChart = findViewById(R.id.grafico);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            acao = extras.getString("acao");
        }

        if (acao.equals("g1")) {
            titulo.setText("Operações mecanizadas");
            String subTotalA = safra.getCustoA().getSubTotalA();

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAracaoV(), subTotalA)), "Aração"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getGradeacaoV(), subTotalA)), "Gradeação (2x) "));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getSubsolagemV(), subTotalA)), "Subsolagem"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getCalagemV(), subTotalA)), "Calagem"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getSulcamentoV(), subTotalA)), "Sucamento"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAdubacaoBasicaV(), subTotalA)), "Adubação Básica"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAplicacaoEstercoV(), subTotalA)), "Aplicação de esterco"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAdubacaoCoberturaV(), subTotalA)), "Adubação em cobertura"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getPulverizacaoV(), subTotalA)), "Pulverização"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getColheitaClassificacaoV(), subTotalA)), "Colheita e Classificação"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getIrrigacoesV(), subTotalA)), "Irrigações"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getOutrosAV(), subTotalA)), "Outros"));

            pieDataSet.setColors(
                    new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                            R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10, R.color.color11, R.color.color12}, GraficoActivity.this);

        }

        pieDataSet.setValueTextColor(WHITE);
        pieDataSet.setValueLineColor(WHITE);
        pieDataSet.setValueTextSize(15f);
        pieDataSet.setFormSize(15f);

        pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.setHoleRadius(45);
        pieChart.setHoleColor(Color.argb(0, 255, 255, 255));
        pieChart.setDrawHoleEnabled(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.setTransparentCircleRadius(10);
        pieChart.setCenterText("%");
        pieChart.setCenterTextColor(WHITE);
        pieChart.setCenterTextSize(18);

        pieChart.animateX(1000);
        pieChart.animateY(500);

        pieChart.getLegend().setTextColor(Color.WHITE);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setTextSize(15);
        legend.setFormSize(20);
        legend.setFormToTextSpace(2);

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
    }
}