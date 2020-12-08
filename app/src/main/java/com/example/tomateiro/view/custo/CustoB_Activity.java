package com.example.tomateiro.view.custo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;
import com.example.tomateiro.model.CustoB;

import me.abhinay.input.CurrencyEditText;

public class CustoB_Activity extends AppCompatActivity {
    CurrencyEditText editA_q1, editA_q2, editA_q3, editA_q4, editA_q5, editA_q6, editA_q7, editA_q8,
            editA_q9, editA_q10, editA_q11, editA_q12, editA_q13, editA_q14, editA_q15, editA_q16;

    CurrencyEditText editA_v1, editA_v2, editA_v3, editA_v4, editA_v5, editA_v6, editA_v7, editA_v8,
            editA_v9, editA_v10, editA_v11, editA_v12, editA_v13, editA_v14, editA_v15, editA_v16;

    Button btn_concluir;

    TextView custo_subtotal;

    CustoB custoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_b);


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


        custoB = new CustoB();

        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                custoB.setColagemQ(editA_q1.getText().toString());
                custoB.setTransplantioQ(editA_q2.getText().toString());
                custoB.setEstaqueamentoQ(editA_q3.getText().toString());
                custoB.setAmontoaQ(editA_q4.getText().toString());
                custoB.setAmarracaoQ(editA_q5.getText().toString());
                custoB.setAdubacaoBasicaQ(editA_q6.getText().toString());
                custoB.setAplicacaoEstercoQ(editA_q7.getText().toString());
                custoB.setDesbrotaQ(editA_q8.getText().toString());
                custoB.setAdubacaoCoberturaQ(editA_q9.getText().toString());
                custoB.setPulverizacaoCostalQ(editA_q10.getText().toString());
                custoB.setCapinasManuaisQ(editA_q11.getText().toString());
                custoB.setColheitaClassificaçãoQ(editA_q12.getText().toString());
                custoB.setIrrigacaoQ(editA_q13.getText().toString());

                custoB.setOutrosBQ(editA_q14.getText().toString());

                custoB.setColagemV(editA_q1.getText().toString());
                custoB.setTransplantioV(editA_q2.getText().toString());
                custoB.setEstaqueamentoV(editA_q3.getText().toString());
                custoB.setAmontoaV(editA_q4.getText().toString());
                custoB.setAmarracaoV(editA_q5.getText().toString());
                custoB.setAdubacaoBasicaV(editA_q6.getText().toString());
                custoB.setAplicacaoEstercoV(editA_q7.getText().toString());
                custoB.setDesbrotaV(editA_q8.getText().toString());
                custoB.setAdubacaoCoberturaV(editA_q9.getText().toString());
                custoB.setPulverizacaoCostalV(editA_q10.getText().toString());
                custoB.setCapinasManuaisV(editA_q11.getText().toString());
                custoB.setColheitaClassificaçãoV(editA_q12.getText().toString());
                custoB.setIrrigacaoV(editA_q13.getText().toString());

                custoB.setOutrosBV(editA_q14.getText().toString());


                custo_subtotal.setText(custo_subtotal.getText().toString() + custoB.calcularSubTotal(custoB).getSubTotalB());

            }
        });
    }
}