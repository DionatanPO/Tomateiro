package com.example.tomateiro.view.custo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;
import com.example.tomateiro.controller.CustoAController;
import com.example.tomateiro.controller.CustoBController;
import com.example.tomateiro.controller.SafraController;
import com.example.tomateiro.model.CustoA;
import com.example.tomateiro.model.CustoB;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.request.SafraRequest;

import me.abhinay.input.CurrencyEditText;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class CustoB_Activity extends AppCompatActivity {
    private CurrencyEditText editA_q1, editA_q2, editA_q3, editA_q4, editA_q5, editA_q6, editA_q7, editA_q8,
            editA_q9, editA_q10, editA_q11, editA_q12, editA_q13, editA_q14, editA_q15, editA_q16;

    private CurrencyEditText editA_v1, editA_v2, editA_v3, editA_v4, editA_v5, editA_v6, editA_v7, editA_v8,
            editA_v9, editA_v10, editA_v11, editA_v12, editA_v13, editA_v14, editA_v15, editA_v16;

    private Button btn_concluir;

    private TextView custo_subtotal;

    private CustoB custoB;
    private Safra safra;


    private CustoBController custoBController;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_b);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.btn_animation);
        context = this;
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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
            if (safra.getCustoB() != null) {
                custoB = safra.getCustoB();
                try {
                    editA_q1.setText(custoB.getColagemQ());
                    editA_q2.setText(custoB.getTransplantioQ());
                    editA_q3.setText(custoB.getEstaqueamentoQ());
                    editA_q4.setText(custoB.getAmontoaQ());
                    editA_q5.setText(custoB.getAmarracaoQ());
                    editA_q6.setText(custoB.getAdubacaoBasicaQ());
                    editA_q7.setText(custoB.getAplicacaoEstercoQ());
                    editA_q8.setText(custoB.getDesbrotaQ());
                    editA_q9.setText(custoB.getAdubacaoCoberturaQ());
                    editA_q10.setText(custoB.getPulverizacaoCostalQ());
                    editA_q11.setText(custoB.getCapinasManuaisQ());
                    editA_q12.setText(custoB.getColheitaClassificacaoQ());
                    editA_q13.setText(custoB.getIrrigacaoQ());
                    editA_q14.setText(custoB.getOutrosBQ());

                    editA_v1.setText(custoB.getColagemV());
                    editA_v2.setText(custoB.getTransplantioV());
                    editA_v3.setText(custoB.getEstaqueamentoV());
                    editA_v4.setText(custoB.getAmontoaV());
                    editA_v5.setText(custoB.getAmarracaoV());
                    editA_v6.setText(custoB.getAdubacaoBasicaV());
                    editA_v7.setText(custoB.getAplicacaoEstercoV());
                    editA_v8.setText(custoB.getDesbrotaV());
                    editA_v9.setText(custoB.getAdubacaoCoberturaV());
                    editA_v10.setText(custoB.getPulverizacaoCostalV());
                    editA_v11.setText(custoB.getCapinasManuaisV());
                    editA_v12.setText(custoB.getColheitaClassificacaoV());
                    editA_v13.setText(custoB.getIrrigacaoV());
                    editA_v14.setText(custoB.getOutrosBV());

                    custo_subtotal.setText("SubTotal = R$ " + custoB.getSubTotalB());
                } catch (Exception e) {

                }
            } else {
                custoB = new CustoB();
            }


        } else {

        }


        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                btn_concluir.startAnimation(myAnim);
                custoB.setColagemQ(editA_q1.getText().toString().substring(1));
                custoB.setTransplantioQ(editA_q2.getText().toString().substring(1));
                custoB.setEstaqueamentoQ(editA_q3.getText().toString().substring(1));
                custoB.setAmontoaQ(editA_q4.getText().toString().substring(1));
                custoB.setAmarracaoQ(editA_q5.getText().toString().substring(1));
                custoB.setAdubacaoBasicaQ(editA_q6.getText().toString().substring(1));
                custoB.setAplicacaoEstercoQ(editA_q7.getText().toString().substring(1));
                custoB.setDesbrotaQ(editA_q8.getText().toString().substring(1));
                custoB.setAdubacaoCoberturaQ(editA_q9.getText().toString().substring(1));
                custoB.setPulverizacaoCostalQ(editA_q10.getText().toString().substring(1));
                custoB.setCapinasManuaisQ(editA_q11.getText().toString().substring(1));
                custoB.setColheitaClassificacaoQ(editA_q12.getText().toString().substring(1));
                custoB.setIrrigacaoQ(editA_q13.getText().toString().substring(1));
                custoB.setOutrosBQ(editA_q14.getText().toString().substring(1));

                custoB.setColagemV(editA_v1.getText().toString().substring(1));
                custoB.setTransplantioV(editA_v2.getText().toString().substring(1));
                custoB.setEstaqueamentoV(editA_v3.getText().toString().substring(1));
                custoB.setAmontoaV(editA_v4.getText().toString().substring(1));
                custoB.setAmarracaoV(editA_v5.getText().toString().substring(1));
                custoB.setAdubacaoBasicaV(editA_v6.getText().toString().substring(1));
                custoB.setAplicacaoEstercoV(editA_v7.getText().toString().substring(1));
                custoB.setDesbrotaV(editA_v8.getText().toString().substring(1));
                custoB.setAdubacaoCoberturaV(editA_v9.getText().toString().substring(1));
                custoB.setPulverizacaoCostalV(editA_v10.getText().toString().substring(1));
                custoB.setCapinasManuaisV(editA_v11.getText().toString().substring(1));
                custoB.setColheitaClassificacaoV(editA_v12.getText().toString().substring(1));
                custoB.setIrrigacaoV(editA_v13.getText().toString().substring(1));
                custoB.setOutrosBV(editA_v14.getText().toString().substring(1));


                custoBController = new CustoBController(context);
                try {
                    if (custoBController.validar_custo(custoB)) {

                        custo_subtotal.setText("SubTotal = R$ " + custoB.calcularSubTotal(custoB).getSubTotalB());
                        safra.setCustoB(custoB);

                        SafraRequest safraRequest = new SafraRequest(context);
                        SafraController safraController = new SafraController(context);

                        safraRequest.alterrar_safra(safraController.converter_safra_json(safra), safra.getId(), CustoB_Activity.this);

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