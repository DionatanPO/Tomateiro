package com.example.tomateiro.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tomateiro.R;

import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.request.SafraRequest;

import java.util.ArrayList;
import java.util.List;

import static com.example.tomateiro.model.CustonToast.viewToast;


public class RelatorioActivity extends AppCompatActivity implements View.OnClickListener {

    private Safra safra;
    private Button btn_safra_menu;
    private Context context;
    private SafraRequest safraRequest;
    private List<Safra> safrasListConcluidas;
    private Produtor produtor;
    private ListView listView;
    private Button btn_g1, btn_g2, btn_g3, btn_g4;

    private TextView r_qtd_total_caixa, r_ciclo, r_peso_medio_caixa, r_qtd_pes, r_regiao_referencia,
            r_subTotalA, r_subTotalD, r_subTotalC, r_subTotalB, r_custoTotal_ha, r_custoTotal_cx,
            r_preco_medio_recebido, r_receitaHa, r_resultadoHa, r_resultadoCx, r_margem_venda,
            r_venda_n_total, r_safra_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        context = this;

        btn_g1 = findViewById(R.id.btn_g1);
        btn_g1.setOnClickListener(this);
        btn_g2 = findViewById(R.id.btn_g2);
        btn_g2.setOnClickListener(this);
        btn_g3 = findViewById(R.id.btn_g3);
        btn_g3.setOnClickListener(this);
        btn_g4 = findViewById(R.id.btn_g4);
        btn_g4.setOnClickListener(this);

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
                System.out.println();
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
                                        viewToast(context, "Carregando informações...");
                                        safra = safrasListConcluidas.get(position);

                                        Intent intent = getIntent();
                                        intent.putExtra("safra", safra);
                                        intent.putExtra("produtor", produtor);
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


        r_subTotalA.setText("R$: "+safra.getCustoA().getSubTotalA());

        r_subTotalB.setText("R$: "+safra.getCustoB().getSubTotalB());

        r_subTotalC.setText("R$: "+safra.getCustoC().getSubTotalC());

        r_subTotalD.setText("R$: "+safra.getCustoD().getSubTotalD());


    }


    public void request_buscar_safra_concluidas(List<Safra> safras) {
        safrasListConcluidas = safras;
        final ArrayAdapter<Safra> adapter = new ArrayAdapter<>(this, R.layout.spinner_templete, safrasListConcluidas);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_g1:
                intent = new Intent(context, GraficoActivity.class);
                intent.putExtra("safra", safra);
                intent.putExtra("acao", "g1");
                startActivity(intent);
                break;

            case R.id.btn_g2:
                intent = new Intent(context, GraficoActivity.class);
                intent.putExtra("safra", safra);
                intent.putExtra("acao", "g2");
                startActivity(intent);
                break;

            case R.id.btn_g3:
                intent = new Intent(context, GraficoActivity.class);
                intent.putExtra("safra", safra);
                intent.putExtra("acao", "g3");
                startActivity(intent);
                break;

            case R.id.btn_g4:
                intent = new Intent(context, GraficoActivity.class);
                intent.putExtra("safra", safra);
                intent.putExtra("acao", "g4");
                startActivity(intent);
                break;
        }
    }
}