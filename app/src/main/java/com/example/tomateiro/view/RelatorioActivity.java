package com.example.tomateiro.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tomateiro.R;

import com.example.tomateiro.model.CustoA;
import com.example.tomateiro.model.CustoB;
import com.example.tomateiro.model.CustoC;
import com.example.tomateiro.model.CustoD;
import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.request.SafraRequest;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.WHITE;
import static com.example.tomateiro.model.CustonToast.viewToast;
import static com.example.tomateiro.model.CustonToast.viewToastAlerta;


public class RelatorioActivity extends AppCompatActivity {
    private PieChart pieChart, pieChart2, pieChart3, pieChart4;
    private PieDataSet pieDataSet;
    private PieData pieData;
    private ArrayList<PieEntry> pieEntries;
    private Safra safra;
    private Field[] fields;
    private Button btn_safra_menu;
    private Context context;
    private SafraRequest safraRequest;
    private List<Safra> safrasListConcluidas;
    private Produtor produtor;
    private ListView listView;

    private TextView r_qtd_total_caixa, r_ciclo, r_peso_medio_caixa, r_qtd_pes, r_regiao_referencia,
            r_subTotalA, r_subTotalD, r_subTotalC, r_subTotalB, r_custoTotal_ha, r_custoTotal_cx,
            r_preco_medio_recebido, r_receitaHa, r_resultadoHa, r_resultadoCx, r_margem_venda,
            r_venda_n_total, r_safra_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        context = this;

        btn_safra_menu = findViewById(R.id.btn_safra_menu);

        //Definindo variaves
        r_qtd_total_caixa = findViewById(R.id.relatorio_qtd_total_caixa);
        r_ciclo = findViewById(R.id.relatorio_ciclo);
        r_peso_medio_caixa = findViewById(R.id.relatorio_peso_caixa);
        r_qtd_pes = findViewById(R.id.relatorio_qtde_pes);
        r_safra_data = findViewById(R.id.relatorio_data);
        r_regiao_referencia = findViewById(R.id.relatorio_regiao_referencia);

        r_subTotalA = findViewById(R.id.relatorio_subtotalA);
        r_subTotalC = findViewById(R.id.relatorio_subtotalC);
        r_subTotalB = findViewById(R.id.relatorio_subtotalB);
        r_subTotalD = findViewById(R.id.relatorio_subtotalD);
        r_custoTotal_ha = findViewById(R.id.relatorio_custo_total_ha);
        r_custoTotal_cx = findViewById(R.id.relatorio_custo_total_cx);
        r_preco_medio_recebido = findViewById(R.id.relatorio_preco_medio_recebido);
        r_receitaHa = findViewById(R.id.relatorio_receita);
        r_resultadoHa = findViewById(R.id.relatorio_resultadoHa);
        r_resultadoCx = findViewById(R.id.relatorio_resultadoCx);
        r_margem_venda = findViewById(R.id.relatorio_margem_venda);
        r_venda_n_total = findViewById(R.id.relatorio_n_venda_total);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            produtor = (Produtor) getIntent().getSerializableExtra("produtor");

            r_ciclo.setText(safra.getClicloAno());
            r_qtd_pes.setText(String.valueOf(safra.getQtdePes()));
            r_regiao_referencia.setText(safra.getRegiaoReferencia());
            r_safra_data.setText(safra.getData());

            try {
                safra = safra.calcularCustoTotalHa(safra);

                if (safra.getVendas().size() >= 1) {
                    safra = safra.calcularPesoMedioCaixa(safra);
                    r_peso_medio_caixa.setText(safra.getPesoMedioCaixas());
                    safra = safra.calcularQtdeCaixasVendidas(safra);
                    r_qtd_total_caixa.setText(String.valueOf(safra.getQtdeCaixas()));
                    r_venda_n_total.setText(String.valueOf(safra.getVendas().size()));
                }

                if (safra.getCustoTotalHa() != "0") {
                    if (safra.getVendas().size() >= 1) {
                        safra = safra.calcularQtdeCaixasVendidas(safra);
                        safra = safra.calcularCustoTotalCx(safra);
                        safra = safra.calcularPrecoMedioRecebido(safra);
                        safra = safra.calcularPesoMedioCaixa(safra);

                        safra = safra.calcularReceita(safra);
                        safra = safra.calcularResultadoHa(safra);
                        safra = safra.calcularResultadoCx(safra);
                        safra = safra.calcularMargemVenda(safra);


                        r_peso_medio_caixa.setText(safra.getPesoMedioCaixas());
                        r_qtd_total_caixa.setText(String.valueOf(safra.getQtdeCaixas()));
                        r_custoTotal_ha.setText(safra.getCustoTotalHa());
                        r_custoTotal_cx.setText(safra.getCustoTotalCa());
                        r_preco_medio_recebido.setText(safra.getPreçoMedioRecebidoProdutor());
                        r_receitaHa.setText(safra.getReceitaHa());
                        r_resultadoHa.setText(safra.getResultadoHa());
                        r_resultadoCx.setText(safra.getResultadoCx());
                        r_margem_venda.setText(safra.getMargemVenda() + "%");

                        r_venda_n_total.setText(String.valueOf(safra.getVendas().size()));
                    }

                }

            } catch (Exception e) {
                System.out.println("");
            }


        } else {
            safra = new Safra();
        }

        btn_safra_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(context, btn_safra_menu);

                popup.getMenuInflater()
                        .inflate(R.menu.relatorio_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    AlertDialog alerta;
                    LayoutInflater inflater = LayoutInflater.from(context);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View layout;

                    @SuppressLint("SetTextI18n")
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.historico:

                                safraRequest = new SafraRequest(context);
                                safrasListConcluidas = new ArrayList<>();

                                layout = inflater.inflate(R.layout.lista_safra_fragmento, null);
                                listView = layout.findViewById(R.id.listview);
                                safraRequest.buscar_safra_produtor(produtor.getId(), "Concluida", RelatorioActivity.this);



                                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                                        viewToast(context,"Carregando informações...");
                                        safra = safrasListConcluidas.get(position);

                                        Intent intent = getIntent();
                                        intent.putExtra("safra",safra);
                                        intent.putExtra("produtor",produtor);
                                        finish();
                                        startActivity(intent);
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
        //--------------------------------------------------------

        pieChart = findViewById(R.id.grafico1);
        pieEntries = new ArrayList<>();

        Class<CustoA> custoAClass = CustoA.class;

        fields = custoAClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = null;

            try {
                objeto = field.get(safra.getCustoA());
            } catch (Exception e) {

            }

            if (objeto != null) {
                r_subTotalA.setText(safra.getCustoA().getSubTotalA());

                if (field.getName().contains("Q") || field.getName().contains("subTotal")) {

                } else {
//                    pieEntries.add(new PieEntry(Float.parseFloat(objeto.toString()), field.getName()));
                }

            }
        }

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
        Class<CustoB> custoBClass = CustoB.class;

        fields = custoBClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = null;
            try {
                objeto = field.get(safra.getCustoB());
            } catch (Exception e) {

            }

            if (objeto != null) {
                r_subTotalB.setText(safra.getCustoB().getSubTotalB());
                if (field.getName().contains("Q") || field.getName().contains("subTotal")) {

                } else {
//                    pieEntries.add(new PieEntry(Float.parseFloat(objeto.toString()), field.getName()));
                }

            }
        }

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

        Class<CustoC> custoCClass = CustoC.class;

        fields = custoCClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = null;
            try {
                objeto = field.get(safra.getCustoC());
            } catch (Exception e) {

            }

            if (objeto != null) {
                r_subTotalC.setText(safra.getCustoC().getSubTotalC());
                if (field.getName().contains("Q") || field.getName().contains("subTotal")) {

                } else {
//                    pieEntries.add(new PieEntry(Float.parseFloat(objeto.toString()), field.getName()));
                }

            }
        }

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

        Class<CustoD> custoDClass = CustoD.class;

        fields = custoDClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object objeto = null;
            try {
                objeto = field.get(safra.getCustoD());
            } catch (Exception e) {

            }

            if (objeto != null) {
                r_subTotalD.setText(safra.getCustoD().getSubTotalD());
                if (field.getName().contains("Q") || field.getName().contains("subTotal")) {

                } else {
//                    pieEntries.add(new PieEntry(Float.parseFloat(objeto.toString()), field.getName()));
                }

            }
        }


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
        final BarChart chart = findViewById(R.id.barchart);

        int[] numArr = {1, 2, 3, 4, 5, 6};
        List<BarEntry> entries = new ArrayList<BarEntry>();
        for (int num : numArr) {
            entries.add(new BarEntry(num, num));
        }
        BarDataSet dataSet = new BarDataSet(entries, "Numbers");
        final BarData data = new BarData(dataSet);

        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(chart);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);

        chart.setData(data);
        chart.invalidate();

//        ArrayList barEntries = new ArrayList<>();


//        barEntries.add(new BarEntry(2015, safra.getQtdeCaixas()));
//        barEntries.add(new BarEntry(2016, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 100));
//        barEntries.add(new BarEntry(2017, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));
//        barEntries.add(new BarEntry(2018, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));
//        barEntries.add(new BarEntry(2019, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));
//        barEntries.add(new BarEntry(2020, safra.calcularQtdeCaixasVendidas(safra).getQtdeCaixas() + 25));
//
//
//
//
//
//
//        BarDataSet barDataSet = new BarDataSet(barEntries, "");
//        BarData barData = new BarData(barDataSet);
//        barChart.setData(barData);
//
        dataSet.setColors(WHITE);
        dataSet.setValueTextColor(WHITE);
        dataSet.setValueTextSize(18f);
//
        chart.getAxisLeft().setTextColor(WHITE);
        chart.getAxisRight().setTextColor(WHITE);
        chart.getXAxis().setTextColor(WHITE);
        chart.getLegend().setTextColor(WHITE);
        chart.getDescription().setEnabled(false);
        chart.animateY(4000);
        chart.setFitBars(false);
//
//        XAxis xAxis = barChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setDrawGridLines(false);
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(getAreaCount()));
        //--------------------------------------------------------------------
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                float x = e.getX();
                float y = e.getY();


//                Toast.makeText(RelatorioActivity.this, String.valueOf( e.getData().toString()),
//                        Toast.LENGTH_LONG).show();
                Log.d("Entry selected", e.toString());
//

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    public void request_buscar_safra_concluidas(List<Safra> safras) {
        safrasListConcluidas = safras;
        final ArrayAdapter<Safra> adapter = new ArrayAdapter<>(this, R.layout.spinner_templete, safrasListConcluidas);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public class DayAxisValueFormatter extends ValueFormatter {
        private final BarLineChartBase<?> chart;

        public DayAxisValueFormatter(BarLineChartBase<?> chart) {
            this.chart = chart;
        }

        @Override
        public String getFormattedValue(float value) {
            return "your text " + value;
        }
    }
}