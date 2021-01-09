package com.example.tomateiro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Safra;
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
            titulo.setText("Gráfico operações mecanizadas");
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
        if (acao.equals("g2")) {
            titulo.setText("Gráfico operações manuais");
            String subTotal = safra.getCustoB().getSubTotalB();

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Colagem"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Transplantio"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Estaqueamento"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Amontoa"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Amarração"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Adubação básica"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Aplicação de esterco"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Desbrota"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Adubação em cobertura"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Pulverização com costal"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Capinas Manuais"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Colheita e Classificação"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Irrigação"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Outros"));



            pieDataSet.setColors(
                    new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                            R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10,
                            R.color.color11, R.color.color12, R.color.color13, R.color.color14}, GraficoActivity.this);

        }

        if (acao.equals("g3")) {
            titulo.setText("Gráfico insumos");
            String subTotal = safra.getCustoC().getSubTotalC();

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Calcário Dolomítico"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Sulfato de Amônio"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Superfosfato Simples"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Cloreto de Potássio"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Esterco Bovino"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Yorin BZ"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Sementes"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Confecção de mudas"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Estacas Bambu (1 ciclos)"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Mourões Eucal. (10 ciclos)"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Arame nº 16 (3 ciclos)"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Arame nº 20 (3 ciclos)"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Fungicidas"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Herbicidas"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Inseticidas"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Outros produtos químicos"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Outros"));




            pieDataSet.setColors(
                    new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                            R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10,
                            R.color.color11, R.color.color12, R.color.color13, R.color.color14,
                            R.color.color15,  R.color.color16,  R.color.color17}, GraficoActivity.this);

        }        if (acao.equals("g4")) {
            titulo.setText("Gráfico administração");
            String subTotal = safra.getCustoD().getSubTotalD();

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "Arrendamento"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "M. O. Administrativa"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "Contabilidade/ Escritório"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "Luz/ Telefone"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "Viagens"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "Impostos / Taxas"));
            pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "Outros"));


            pieDataSet.setColors(
                    new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                            R.color.color6, R.color.color7}, GraficoActivity.this);

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
        if (acao.equals("g3")) {
            legend.setTextSize(11);
            legend.setFormSize(11);
        }else{
            legend.setTextSize(15);
            legend.setFormSize(20);
        }

        legend.setFormToTextSpace(2);

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
    }
}