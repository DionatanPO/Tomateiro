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
    private PieChart pieChart, pieChart2;
    private PieDataSet pieDataSet, pieDataSet2;
    private PieData pieData, pieData2;
    private ArrayList<PieEntry> pieEntries;
    private Safra safra;
    private String acao;

    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        titulo = findViewById(R.id.textView);
        pieChart = findViewById(R.id.grafico2);
        pieChart2 = findViewById(R.id.grafico);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            acao = extras.getString("acao");
        }

        if (acao.equals("g1")) {
            titulo.setText("Gráficos: Operações Mecanizadas");

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");

            if (safra.getCustoA() != null) {

                String subTotalA = safra.getCustoA().getSubTotalA();

                pieDataSet = new PieDataSet(pieEntries, "");
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAracaoV(), subTotalA)), "Aração - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getGradeacaoV(), subTotalA)), "Gradeação (2x) - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getSubsolagemV(), subTotalA)), "Subsolagem - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getCalagemV(), subTotalA)), "Calagem - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getSulcamentoV(), subTotalA)), "Sulcamento - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAdubacaoBasicaV(), subTotalA)), "Adubação básica - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAplicacaoEstercoV(), subTotalA)), "Aplicação de esterco - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getAdubacaoCoberturaV(), subTotalA)), "Adubação em cobertura - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getPulverizacaoV(), subTotalA)), "Pulverização - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getColheitaClassificacaoV(), subTotalA)), "Colheita e classificação - (C)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getIrrigacoesV(), subTotalA)), "Irrigações - (I)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getOutrosAV(), subTotalA)), "Outros - (O)"));

                pieEntries = new ArrayList<>();
                pieDataSet2 = new PieDataSet(pieEntries, "");

                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().calcularSubTotalPreparoSolo(safra.getCustoA()), subTotalA)), "Preparo do solo - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().calcularSubTotalTratosCulturais(safra.getCustoA()), subTotalA)), "Tratos culturais - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getColheitaClassificacaoV(), subTotalA)), "Colheita - (C)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getIrrigacoesV(), subTotalA)), "Irrigação - (I)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoA().getOutrosAV(), subTotalA)), "Outros (O)"));

                pieDataSet.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                                R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10, R.color.color11, R.color.color12}, GraficoActivity.this);

                pieDataSet2.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5}, GraficoActivity.this);
            }

        }

        if (acao.equals("g2")) {
            titulo.setText("Gráficos: Operações Manuais");
            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");

            if (safra.getCustoB() != null) {
                String subTotal = safra.getCustoB().getSubTotalB();


                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Calagem - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getTransplantioV(), subTotal)), "Transplantio - (P)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getEstaqueamentoV(), subTotal)), "Estaqueamento - (P)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAmontoaV(), subTotal)), "Amontoa - (P)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAmarracaoV(), subTotal)), "Amarração - (P)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAdubacaoBasicaV(), subTotal)), "Adubação básica - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAplicacaoEstercoV(), subTotal)), "Aplicação de esterco - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getDesbrotaV(), subTotal)), "Desbrota - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getAdubacaoCoberturaV(), subTotal)), "Adubação em cobertura - (TC"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getPulverizacaoCostalV(), subTotal)), "Pulverização com costal - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getCapinasManuaisV(), subTotal)), "Capinas Manuais - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColheitaClassificacaoV(), subTotal)), "Colheita e Classificação - (C)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getIrrigacaoV(), subTotal)), "Irrigação - (I)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getOutrosBV(), subTotal)), "Outros - (O)"));


                pieEntries = new ArrayList<>();
                pieDataSet2 = new PieDataSet(pieEntries, "");
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColagemV(), subTotal)), "Preparo do solo - (PS)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().calcularSubTotalPlantil(safra.getCustoB()), subTotal)), "Plantio - (P)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().calcularSubTotalTratosCulturais(safra.getCustoB()), subTotal)), "Tratos culturais - (TC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getColheitaClassificacaoV(), subTotal)), "Colheita - (C)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getIrrigacaoV(), subTotal)), "Irrigação - (I)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoB().getOutrosBV(), subTotal)), "Outros - (O)"));

                pieDataSet.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                                R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10,
                                R.color.color11, R.color.color12, R.color.color13, R.color.color14}, GraficoActivity.this);

                pieDataSet2.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5, R.color.color6}, GraficoActivity.this);

            }


        }

        if (acao.equals("g3")) {
            titulo.setText("Gráficos: Insumos");

            pieEntries = new ArrayList<>();
            pieDataSet = new PieDataSet(pieEntries, "");

            if (safra.getCustoC() != null) {
                String subTotal = safra.getCustoC().getSubTotalC();


                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCalcarioDolomiticoV(), subTotal)), "Calcário Dolomítico - (FC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getSulfatoAmonioV(), subTotal)), "Sulfato de Amônio - (FC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getSuperfosfatoSimplesV(), subTotal)), "Superfosfato Simples - (FC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getCloretoPotassioV(), subTotal)), "Cloreto de Potássio - (FC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getEstercoBovinoV(), subTotal)), "Esterco Bovino - (FC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getYorinV(), subTotal)), "Yorin BZ - (FC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getSementesV(), subTotal)), "Sementes - (SMM)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getConfeccaoMudasV(), subTotal)), "Confecção de mudas - (SMM)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getFungicidasV(), subTotal)), "Fungicidas - (DA)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getHerbicidasV(), subTotal)), "Herbicidas - (DA)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getInseticidasV(), subTotal)), "Inseticidas - (DA)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getOutrosProdutosQuimicosV(), subTotal)), "Outros produtos químicos - (DA)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getOutrosV(), subTotal)), "Outros - (O)"));

                pieEntries = new ArrayList<>();
                pieDataSet2 = new PieDataSet(pieEntries, "");
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().calcularSubTotalFertilizantesCorretivos(safra.getCustoC()), subTotal)), "Fertilizantes/ Corretivos - (FC)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().calcularSubTotalSementesMudasMatPlantio(safra.getCustoC()), subTotal)), "Sementes/ Mudas/ Mat. plantio - (SMM)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().calcularSubTotalDefensivosAgricolas(safra.getCustoC()), subTotal)), "Defensivos agrícolas - (DA)"));
                pieEntries.add(new PieEntry(Float.valueOf(safra.parse3(safra.getCustoC().getOutrosV(), subTotal)), "Outros - (O)"));

                pieDataSet.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                                R.color.color6, R.color.color7, R.color.color8, R.color.color9, R.color.color10,
                                R.color.color11, R.color.color12, R.color.color13}, GraficoActivity.this);

                pieDataSet2.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4}, GraficoActivity.this);
            }

        }
        if (acao.equals("g4")) {
            titulo.setText("Gráficos: Administração");
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

                pieEntries = new ArrayList<>();
                pieDataSet2 = new PieDataSet(pieEntries, "");
                pieDataSet.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5,
                                R.color.color6, R.color.color7}, GraficoActivity.this);
                pieDataSet2.setColors(
                        new int[]{R.color.color1, R.color.color2, R.color.color3, R.color.color4}, GraficoActivity.this);
            } else {

            }

        }

        if (pieDataSet != null || pieData2 != null) {

            if (pieDataSet != null) {
                pieDataSet.setValueTextColor(WHITE);
                pieDataSet.setValueLineColor(WHITE);
                pieDataSet.setValueTextSize(15f);
                pieDataSet.setFormSize(15f);
                pieData = new PieData(pieDataSet);
            }
            if (pieDataSet2 != null) {
                pieDataSet2.setValueTextColor(WHITE);
                pieDataSet2.setValueLineColor(WHITE);
                pieDataSet2.setValueTextSize(15f);
                pieDataSet2.setFormSize(15f);
                pieData2 = new PieData(pieDataSet2);
            }

            if (pieDataSet != null) {
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
            }
            if (pieDataSet2 != null) {
                pieChart2.setData(pieData2);
                pieChart2.setHoleRadius(45);
                pieChart2.setHoleColor(Color.argb(0, 255, 255, 255));
                pieChart2.setDrawHoleEnabled(true);
                pieChart2.getDescription().setEnabled(false);
                pieChart2.setDrawEntryLabels(false);
                pieChart2.setTransparentCircleRadius(10);
                pieChart2.setCenterText("%");
//        pieChart.setCenterTextColor(WHITE);
                pieChart2.setCenterTextSize(18);
                pieChart2.animateX(1000);
                pieChart2.animateY(500);
            }
//        pieChart.getLegend().setTextColor(Color.WHITE);

            if (pieDataSet != null) {
                Legend legend = pieChart.getLegend();
                legend.setForm(Legend.LegendForm.CIRCLE);
                if (acao.equals("g3")) {
                    legend.setTextSize(13);
                    legend.setFormSize(13);

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
            if (pieDataSet2 != null) {
                Legend legend2 = pieChart2.getLegend();
                legend2.setForm(Legend.LegendForm.CIRCLE);
                if (acao.equals("g3")) {
                    legend2.setTextSize(13);
                    legend2.setFormSize(13);

                } else {
                    legend2.setTextSize(15);
                    legend2.setFormSize(20);
                }

                legend2.setFormToTextSpace(2);
                legend2.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
                legend2.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
                legend2.setOrientation(Legend.LegendOrientation.VERTICAL);
                legend2.setDrawInside(false);

            }

        }
    }
}