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
            titulo.setText("Gráfico: Operações Mecanizadas");

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");

            if (safra.getCustoA() != null) {
                String subTotalA = safra.getCustoA().getSubTotalA();

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
                
            }
            pieDataSet.setColors(
                    new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                            R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10, R.color.color11, R.color.color12}, GraficoActivity.this);

        }
        if (acao.equals("g2")) {
            titulo.setText("Gráfico: Operações Manuais");
            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");

            if (safra.getCustoB() != null) {
                String subTotal = safra.getCustoB().getSubTotalB();


                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Colagem"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getTransplantioV(), subTotal)), "Transplantio"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getEstaqueamentoV(), subTotal)), "Estaqueamento"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAmontoaV(), subTotal)), "Amontoa"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAmarracaoV(), subTotal)), "Amarração"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAdubacaoBasicaV(), subTotal)), "Adubação básica"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAplicacaoEstercoV(), subTotal)), "Aplicação de esterco"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getDesbrotaV(), subTotal)), "Desbrota"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAdubacaoCoberturaV(), subTotal)), "Adubação em cobertura"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getPulverizacaoCostalV(), subTotal)), "Pulverização com costal"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getCapinasManuaisV(), subTotal)), "Capinas Manuais"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColheitaClassificaçãoV(), subTotal)), "Colheita e Classificação"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getIrrigacaoV(), subTotal)), "Irrigação"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getOutrosBV(), subTotal)), "Outros"));
            }

            pieDataSet.setColors(
                    new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                            R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10,
                            R.color.color11, R.color.color12, R.color.color13, R.color.color14}, GraficoActivity.this);

        }

        if (acao.equals("g3")) {
            titulo.setText("Gráfico: Insumos");

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");

            if (safra.getCustoC() != null) {
                String subTotal = safra.getCustoC().getSubTotalC();


                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Calcário Dolomítico"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getSulfatoAmonioV(), subTotal)), "Sulfato de Amônio"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getSuperfosfatoSimplesV(), subTotal)), "Superfosfato Simples"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCloretoPotassioV(), subTotal)), "Cloreto de Potássio"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getEstercoBovinoV(), subTotal)), "Esterco Bovino"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getYorinV(), subTotal)), "Yorin BZ"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getSementesV(), subTotal)), "Sementes"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getConfeccaoMudasV(), subTotal)), "Confecção de mudas"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getEstacasBambuV(), subTotal)), "Estacas Bambu (1 ciclos)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getMouroesEucaV(), subTotal)), "Mourões Eucal. (10 ciclos)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getArame16V(), subTotal)), "Arame nº 16 (3 ciclos)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getArame20V(), subTotal)), "Arame nº 20 (3 ciclos)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getFungicidasV(), subTotal)), "Fungicidas"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getHerbicidasV(), subTotal)), "Herbicidas"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getInseticidasV(), subTotal)), "Inseticidas"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getOutrosProdutosQuimicosV(), subTotal)), "Outros produtos químicos"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getOutrosV(), subTotal)), "Outros"));

            }
            pieDataSet.setColors(
                    new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                            R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10,
                            R.color.color11, R.color.color12, R.color.color13, R.color.color14,
                            R.color.color15, R.color.color16, R.color.color17}, GraficoActivity.this);

        }
        if (acao.equals("g4")) {
            titulo.setText("Gráfico: Administração");
            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");


            if (safra.getCustoD() != null) {
                String subTotal = safra.getCustoD().getSubTotalD();

                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getArrendamentoV(), subTotal)), "Arrendamento"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getMoAdministrativaV(), subTotal)), "M. O. Administrativa"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getContabilidadeEscritorioV(), subTotal)), "Contabilidade/ Escritório"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getLuzTelefoneV(), subTotal)), "Luz/ Telefone"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getViagensV(), subTotal)), "Viagens"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getImpostosTaxasV(), subTotal)), "Impostos / Taxas"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoD().getOutrosV(), subTotal)), "Outros"));
            } else {

            }

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
//        pieChart.setCenterTextColor(WHITE);
        pieChart.setCenterTextSize(18);

        pieChart.animateX(1000);
        pieChart.animateY(500);

//        pieChart.getLegend().setTextColor(Color.WHITE);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        if (acao.equals("g3")) {
            legend.setTextSize(11);
            legend.setFormSize(11);
        } else {
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