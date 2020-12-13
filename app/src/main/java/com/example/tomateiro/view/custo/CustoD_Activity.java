package com.example.tomateiro.view.custo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;
import com.example.tomateiro.model.CustoC;
import com.example.tomateiro.model.CustoD;
import com.example.tomateiro.model.Safra;

import me.abhinay.input.CurrencyEditText;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class CustoD_Activity extends AppCompatActivity {
    private CurrencyEditText editA_q1, editA_q2, editA_q3, editA_q4, editA_q5, editA_q6, editA_q7;
    private CurrencyEditText editA_v1, editA_v2, editA_v3, editA_v4, editA_v5, editA_v6, editA_v7;
    private Button btn_concluir;

    private TextView custo_subtotal;

    private CustoD custoD;

    private Safra safra;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custo_d);

        context = this;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            safra = (Safra) getIntent().getSerializableExtra("safra");
           editA_q1.setText( custoD.getArrendamentoQ());
           editA_q2.setText( custoD.getMoAdministrativaQ());
            editA_q3.setText(custoD.getContabilidadeEscritorioQ());
            editA_q4.setText(custoD.getLuzTelefoneQ());
            editA_q5.setText(custoD.getViagensQ());
            editA_q6.setText(custoD.getImpostosTaxasQ());
           editA_q7.setText(custoD.getOutrosQ());

            editA_v1.setText( custoD.getArrendamentoV());
            editA_v2.setText( custoD.getMoAdministrativaV());
            editA_v3.setText(custoD.getContabilidadeEscritorioV());
            editA_v4.setText(custoD.getLuzTelefoneV());
            editA_v5.setText(custoD.getViagensV());
            editA_v6.setText(custoD.getImpostosTaxasV());
            editA_v7.setText(custoD.getOutrosV());

            custo_subtotal.setText("SubTotal = R$ " + custoD.getSubTotalD());


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

        editA_v1 = findViewById(R.id.editA_v1);
        editA_v2 = findViewById(R.id.editA_v2);
        editA_v3 = findViewById(R.id.editA_v3);
        editA_v4 = findViewById(R.id.editA_v4);
        editA_v5 = findViewById(R.id.editA_v5);
        editA_v6 = findViewById(R.id.editA_v6);
        editA_v7 = findViewById(R.id.editA_v7);

        custoD = new CustoD();

        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                custoD.setArrendamentoQ(editA_q1.getText().toString());
                custoD.setMoAdministrativaQ(editA_q2.getText().toString());
                custoD.setContabilidadeEscritorioQ(editA_q3.getText().toString());
                custoD.setLuzTelefoneQ(editA_q4.getText().toString());
                custoD.setViagensQ(editA_q5.getText().toString());
                custoD.setImpostosTaxasQ(editA_q6.getText().toString());
                custoD.setOutrosQ(editA_q7.getText().toString());

                custoD.setArrendamentoV(editA_v1.getText().toString());
                custoD.setMoAdministrativaV(editA_v2.getText().toString());
                custoD.setContabilidadeEscritorioV(editA_v3.getText().toString());
                custoD.setLuzTelefoneV(editA_v4.getText().toString());
                custoD.setViagensV(editA_v5.getText().toString());
                custoD.setImpostosTaxasV(editA_v6.getText().toString());
                custoD.setOutrosV(editA_v7.getText().toString());

                custo_subtotal.setText("SubTotal = R$ " + custoD.calcularSubTotal(custoD).getSubTotalD());
                safra.setCustoD(custoD);

                viewToast(context, "Custo caclculado");
            }
        });

    }
}