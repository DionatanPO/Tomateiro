package com.example.tomateiro.view.custo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;
import com.example.tomateiro.controller.CustoBController;
import com.example.tomateiro.controller.CustoCController;
import com.example.tomateiro.controller.SafraController;
import com.example.tomateiro.model.CustoB;
import com.example.tomateiro.model.CustoC;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.request.SafraRequest;

import me.abhinay.input.CurrencyEditText;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class CustoC_Activity extends AppCompatActivity {
    private CurrencyEditText editA_q1, editA_q2, editA_q3, editA_q4, editA_q5, editA_q6, editA_q7, editA_q8,
            editA_q9, editA_q10, editA_q11, editA_q12, editA_q13, editA_q14, editA_q15, editA_q16, editA_q17;

    private CurrencyEditText editA_v1, editA_v2, editA_v3, editA_v4, editA_v5, editA_v6, editA_v7, editA_v8,
            editA_v9, editA_v10, editA_v11, editA_v12, editA_v13, editA_v14, editA_v15, editA_v16, editA_v17;

    private Button btn_concluir;

    private TextView custo_subtotal;

    private CustoC custoC;
    private Safra safra;
    private Context context;

    private CustoCController custoCController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        setContentView(R.layout.activity_custo_c);

        btn_concluir = findViewById(R.id.button);
        custo_subtotal = findViewById(R.id.custo_subtotal);

        editA_q1 = findViewById(R.id.editA_q1);
        editA_q2 = findViewById(R.id.editA_q2);
        editA_q3 = findViewById(R.id.editA_q3);
        editA_q4 = findViewById(R.id.editA_q4);
        editA_q5 = findViewById(R.id.editA_q5);
        editA_q6 = findViewById(R.id.editA_q6);
        editA_q7 = findViewById(R.id.editA_q7);
        editA_q8 = findViewById(R.id.editA_q8);
        editA_q9 = findViewById(R.id.editA_q9);
        editA_q10 = findViewById(R.id.editA_q10);
        editA_q11 = findViewById(R.id.editA_q11);
        editA_q12 = findViewById(R.id.editA_q12);
        editA_q13 = findViewById(R.id.editA_q13);
        editA_q14 = findViewById(R.id.editA_q14);
        editA_q15 = findViewById(R.id.editA_q15);
        editA_q16 = findViewById(R.id.editA_q16);
        editA_q17 = findViewById(R.id.editA_q17);

        editA_v1 = findViewById(R.id.editA_v1);
        editA_v2 = findViewById(R.id.editA_v2);
        editA_v3 = findViewById(R.id.editA_v3);
        editA_v4 = findViewById(R.id.editA_v4);
        editA_v5 = findViewById(R.id.editA_v5);
        editA_v6 = findViewById(R.id.editA_v6);
        editA_v7 = findViewById(R.id.editA_v7);
        editA_v8 = findViewById(R.id.editA_v8);
        editA_v9 = findViewById(R.id.editA_v9);
        editA_v10 = findViewById(R.id.editA_v10);
        editA_v11 = findViewById(R.id.editA_v11);
        editA_v12 = findViewById(R.id.editA_v12);
        editA_v13 = findViewById(R.id.editA_v13);
        editA_v14 = findViewById(R.id.editA_v14);
        editA_v15 = findViewById(R.id.editA_v15);
        editA_v16 = findViewById(R.id.editA_v16);
        editA_v17 = findViewById(R.id.editA_v17);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            if (safra.getCustoA() != null) {
                custoC = safra.getCustoC();
                try {
                editA_q1.setText(custoC.getCalcarioDolomiticoQ());
                editA_q2.setText(custoC.getSulfatoAmonioQ());
                editA_q3.setText(custoC.getSuperfosfatoSimplesQ());
                editA_q4.setText(custoC.getCloretoPotassioQ());
                editA_q5.setText(custoC.getEstercoBovinoQ());
                editA_q6.setText(custoC.getYorinQ());
                editA_q7.setText(custoC.getSementesQ());
                editA_q8.setText(custoC.getConfeccaoMudasQ());
                editA_q9.setText(custoC.getEstacasBambuQ());
                editA_q10.setText(custoC.getArame16Q());
                editA_q11.setText(custoC.getMouroesEucaQ());
                editA_q12.setText(custoC.getArame20Q());
                editA_q13.setText(custoC.getFungicidasQ());
                editA_q14.setText(custoC.getHerbicidasQ());
                editA_q15.setText(custoC.getInseticidasQ());
                editA_q16.setText(custoC.getOutrosProdutosQuimicosQ());
                editA_q17.setText(custoC.getOutrosQ());

                editA_v1.setText(custoC.getCalcarioDolomiticoV());
                editA_v2.setText(custoC.getSulfatoAmonioV());
                editA_v3.setText(custoC.getSuperfosfatoSimplesV());
                editA_v4.setText(custoC.getCloretoPotassioV());
                editA_v5.setText(custoC.getEstercoBovinoV());
                editA_v6.setText(custoC.getYorinV());
                editA_v7.setText(custoC.getSementesV());
                editA_v8.setText(custoC.getConfeccaoMudasV());
                editA_v9.setText(custoC.getEstacasBambuV());
                editA_v10.setText(custoC.getArame16V());
                editA_v11.setText(custoC.getMouroesEucaV());
                editA_v12.setText(custoC.getArame20V());
                editA_v13.setText(custoC.getFungicidasV());
                editA_v14.setText(custoC.getHerbicidasV());
                editA_v15.setText(custoC.getInseticidasV());
                editA_v16.setText(custoC.getOutrosProdutosQuimicosV());
                editA_v17.setText(custoC.getOutrosV());

                custo_subtotal.setText("SubTotal = R$ " + custoC.getSubTotalC());

                } catch (Exception e) {

                }
            } else {
                custoC = new CustoC();
            }


        } else {

        }




        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                custoC.setCalcarioDolomiticoQ(editA_q1.getText().toString().substring(1));
                custoC.setSulfatoAmonioQ(editA_q2.getText().toString().substring(1));
                custoC.setSuperfosfatoSimplesQ(editA_q3.getText().toString().substring(1));
                custoC.setCloretoPotassioQ(editA_q4.getText().toString().substring(1));
                custoC.setEstercoBovinoQ(editA_q5.getText().toString().substring(1));
                custoC.setYorinQ(editA_q6.getText().toString().substring(1));
                custoC.setSementesQ(editA_q7.getText().toString().substring(1));
                custoC.setConfeccaoMudasQ(editA_q8.getText().toString().substring(1));
                custoC.setEstacasBambuQ(editA_q9.getText().toString().substring(1));
                custoC.setArame16Q(editA_q10.getText().toString().substring(1));
                custoC.setMouroesEucaQ(editA_q11.getText().toString().substring(1));
                custoC.setArame20Q(editA_q12.getText().toString().substring(1));
                custoC.setFungicidasQ(editA_q13.getText().toString().substring(1));
                custoC.setHerbicidasQ(editA_q14.getText().toString().substring(1));
                custoC.setInseticidasQ(editA_q15.getText().toString().substring(1));
                custoC.setOutrosProdutosQuimicosQ(editA_q16.getText().toString().substring(1));
                custoC.setOutrosQ(editA_q17.getText().toString().substring(1));

                custoC.setCalcarioDolomiticoV(editA_v1.getText().toString().substring(1));
                custoC.setSulfatoAmonioV(editA_v2.getText().toString().substring(1));
                custoC.setSuperfosfatoSimplesV(editA_v3.getText().toString().substring(1));
                custoC.setCloretoPotassioV(editA_v4.getText().toString().substring(1));
                custoC.setEstercoBovinoV(editA_v5.getText().toString().substring(1));
                custoC.setYorinV(editA_v6.getText().toString().substring(1));
                custoC.setSementesV(editA_v7.getText().toString().substring(1));
                custoC.setConfeccaoMudasV(editA_v8.getText().toString().substring(1));
                custoC.setEstacasBambuV(editA_v9.getText().toString().substring(1));
                custoC.setMouroesEucaV(editA_v10.getText().toString().substring(1));
                custoC.setArame16V(editA_v11.getText().toString().substring(1));
                custoC.setArame20V(editA_v12.getText().toString().substring(1));
                custoC.setFungicidasV(editA_v13.getText().toString().substring(1));
                custoC.setHerbicidasV(editA_v14.getText().toString().substring(1));
                custoC.setInseticidasV(editA_v15.getText().toString().substring(1));
                custoC.setOutrosProdutosQuimicosV(editA_v16.getText().toString().substring(1));
                custoC.setOutrosV(editA_v17.getText().toString().substring(1));


                custoCController = new CustoCController(context);
                try {
                    if (custoCController.validar_custo(custoC)) {
                        custo_subtotal.setText("SubTotal = R$ " + custoC.calcularSubTotal(custoC).getSubTotalC());
                        safra.setCustoC(custoC);
                        SafraRequest safraRequest = new SafraRequest(context);
                        SafraController safraController = new SafraController(context);

                        safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), CustoC_Activity.this);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void request_cadastrar_custo(Safra s) {
        safra = s;
    }
}