package com.example.tomateiro.view.custo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;


import com.example.tomateiro.R;
import com.example.tomateiro.controller.CustoAController;
import com.example.tomateiro.controller.SafraController;
import com.example.tomateiro.model.CustoA;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.request.SafraRequest;


import me.abhinay.input.CurrencyEditText;

public class CustoA_Activity extends AppCompatActivity {
    private EditText editA_q1, editA_q2, editA_q3, editA_q4, editA_q5, editA_q6, editA_q7, editA_q8,
            editA_q9, editA_q10, editA_q11, editA_q12;
    private CurrencyEditText editA_v1, editA_v2, editA_v3, editA_v4, editA_v5, editA_v6, editA_v7, editA_v8,
            editA_v9, editA_v10, editA_v11, editA_v12;
    private Button btn_concluir;
    private TextView custo_subtotal;
    private CustoA custoA;
    private CustoAController custoAController;
    private Context context;

    private Safra safra;
    private SafraController safraController;
    private SafraRequest safraRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_a);
        context = this;
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.btn_animation);
        safraController = new SafraController(context);
        safraRequest = new SafraRequest(context);

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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");

            if (safra.getCustoA() != null) {
                custoA = safra.getCustoA();
                try {
                    editA_q1.setText(custoA.getAracaoQ());
                    editA_q2.setText(custoA.getGradeacaoQ());
                    editA_q3.setText(custoA.getSubsolagemQ());
                    editA_q4.setText(custoA.getCalagemQ());
                    editA_q5.setText(custoA.getSulcamentoQ());
                    editA_q6.setText(custoA.getAdubacaoBasicaQ());
                    editA_q7.setText(custoA.getAplicacaoEstercoQ());
                    editA_q8.setText(custoA.getAdubacaoCoberturaQ());
                    editA_q9.setText(custoA.getPulverizacaoQ());
                    editA_q10.setText(custoA.getColheitaClassificacaoQ());
                    editA_q11.setText(custoA.getIrrigacoesQ());
                    editA_q12.setText(custoA.getOutrosAQ());

                    editA_v1.setText(custoA.getAracaoV());
                    editA_v2.setText(custoA.getGradeacaoV());
                    editA_v3.setText(custoA.getSubsolagemV());
                    editA_v4.setText(custoA.getCalagemV());
                    editA_v5.setText(custoA.getSulcamentoV());
                    editA_v6.setText(custoA.getAdubacaoBasicaV());
                    editA_v7.setText(custoA.getAplicacaoEstercoV());
                    editA_v8.setText(custoA.getAdubacaoCoberturaV());
                    editA_v9.setText(custoA.getPulverizacaoV());
                    editA_v10.setText(custoA.getColheitaClassificacaoV());
                    editA_v11.setText(custoA.getIrrigacoesV());
                    editA_v12.setText(custoA.getOutrosAV());

                    custo_subtotal.setText("SubTotal = R$ " + custoA.getSubTotalA());
                } catch (Exception e) {

                }
            }else{
                custoA = new CustoA();
            }


        } else {

        }



        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                btn_concluir.startAnimation(myAnim);
                custoA.setAracaoQ(editA_q1.getText().toString());
                custoA.setGradeacaoQ(editA_q2.getText().toString());
                custoA.setSubsolagemQ(editA_q3.getText().toString());
                custoA.setCalagemQ(editA_q4.getText().toString());
                custoA.setSulcamentoQ(editA_q5.getText().toString());
                custoA.setAdubacaoBasicaQ(editA_q6.getText().toString());
                custoA.setAplicacaoEstercoQ(editA_q7.getText().toString());
                custoA.setAdubacaoCoberturaQ(editA_q8.getText().toString());
                custoA.setPulverizacaoQ(editA_q9.getText().toString());
                custoA.setColheitaClassificacaoQ(editA_q10.getText().toString());
                custoA.setIrrigacoesQ(editA_q11.getText().toString());
                custoA.setOutrosAQ(editA_q12.getText().toString());


                custoA.setAracaoV(editA_v1.getText().toString().substring(1));
                custoA.setGradeacaoV(editA_v2.getText().toString().substring(1));
                custoA.setSubsolagemV(editA_v3.getText().toString().substring(1));
                custoA.setCalagemV(editA_v4.getText().toString().substring(1));
                custoA.setSulcamentoV(editA_v5.getText().toString().substring(1));
                custoA.setAdubacaoBasicaV(editA_v6.getText().toString().substring(1));
                custoA.setAplicacaoEstercoV(editA_v7.getText().toString().substring(1));
                custoA.setAdubacaoCoberturaV(editA_v8.getText().toString().substring(1));
                custoA.setPulverizacaoV(editA_v9.getText().toString().substring(1));
                custoA.setColheitaClassificacaoV(editA_v10.getText().toString().substring(1));
                custoA.setIrrigacoesV(editA_v11.getText().toString().substring(1));
                custoA.setOutrosAV(editA_v12.getText().toString().substring(1));


                custoAController = new CustoAController(context);
                try {

                    if (custoAController.validar_custo(custoA)) {

                        custo_subtotal.setText("SubTotal = R$ " + custoA.calcularSubTotal(custoA).getSubTotalA());

                        safra.setCustoA(custoA);
                        safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), CustoA_Activity.this);

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