package com.example.tomateiro.view.custo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;
import com.example.tomateiro.model.CustoC;
import com.example.tomateiro.model.Safra;

import me.abhinay.input.CurrencyEditText;

public class CustoC_Activity extends AppCompatActivity {
    CurrencyEditText editA_q1, editA_q2, editA_q3, editA_q4, editA_q5, editA_q6, editA_q7, editA_q8,
            editA_q9, editA_q10, editA_q11, editA_q12, editA_q13, editA_q14, editA_q15, editA_q16, editA_q17;

    CurrencyEditText editA_v1, editA_v2, editA_v3, editA_v4, editA_v5, editA_v6, editA_v7, editA_v8,
            editA_v9, editA_v10, editA_v11, editA_v12, editA_v13, editA_v14, editA_v15, editA_v16, editA_v17;

    Button btn_concluir;

    TextView custo_subtotal;

    CustoC custoC;
    Safra safra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_c);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");

        } else {
            safra = new Safra();
        }

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


        custoC = new CustoC();

        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                custoC.setCalcarioDolomiticoQ(editA_q1.getText().toString());
                custoC.setSulfatoAmonioQ(editA_q2.getText().toString());
                custoC.setSuperfosfatoSimplesQ(editA_q3.getText().toString());
                custoC.setCloretoPotassioQ(editA_q4.getText().toString());
                custoC.setEstercoBovinoQ(editA_q5.getText().toString());
                custoC.setYorinQ(editA_q6.getText().toString());
                custoC.setSementesQ(editA_q7.getText().toString());
                custoC.setConfeccaoMudasQ(editA_q8.getText().toString());
                custoC.setEstacasBambuQ(editA_q9.getText().toString());
                custoC.setArame16Q(editA_q10.getText().toString());
                custoC.setMouroesEucaQ(editA_q11.getText().toString());
                custoC.setArame20Q(editA_q12.getText().toString());
                custoC.setFungicidasQ(editA_q13.getText().toString());
                custoC.setHerbicidasQ(editA_q14.getText().toString());
                custoC.setInseticidasQ(editA_q15.getText().toString());
                custoC.setOutrosProdutosQuimicosQ(editA_q16.getText().toString());
                custoC.setOutrosQ(editA_q17.getText().toString());

                custoC.setCalcarioDolomiticoV(editA_v1.getText().toString());
                custoC.setSulfatoAmonioV(editA_v2.getText().toString());
                custoC.setSuperfosfatoSimplesV(editA_v3.getText().toString());
                custoC.setCloretoPotassioV(editA_v4.getText().toString());
                custoC.setEstercoBovinoV(editA_v5.getText().toString());
                custoC.setYorinV(editA_v6.getText().toString());
                custoC.setSementesV(editA_v7.getText().toString());
                custoC.setConfeccaoMudasV(editA_v8.getText().toString());
                custoC.setEstacasBambuV(editA_v9.getText().toString());
                custoC.setMouroesEucaV(editA_v10.getText().toString());
                custoC.setArame16V(editA_v11.getText().toString());
                custoC.setArame20V(editA_v12.getText().toString());
                custoC.setFungicidasV(editA_v13.getText().toString());
                custoC.setHerbicidasV(editA_v14.getText().toString());
                custoC.setInseticidasV(editA_v15.getText().toString());
                custoC.setOutrosProdutosQuimicosV(editA_v16.getText().toString());
                custoC.setOutrosV(editA_v17.getText().toString());

                custo_subtotal.setText("SubTotal = R$ "+ custoC.calcularSubTotal(custoC).getSubTotalC());
                safra.setCustoC(custoC);
            }
        });

    }
}