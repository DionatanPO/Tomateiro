package com.example.tomateiro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.tomateiro.R;
import com.example.tomateiro.request.ProdutorRequest;

import static com.example.tomateiro.model.CustonToast.viewToast;
import static com.example.tomateiro.model.CustonToast.viewToastAlerta;

public class RecuperarActivity extends AppCompatActivity {
    private Button btn_solicitar;
    private EditText email, cod;
    private Context context;
    private ProdutorRequest produtorRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        context = this;

        btn_solicitar = findViewById(R.id.btn_solicitar_senha);
        email = findViewById(R.id.recuperar_email);
        cod = findViewById(R.id.recuperar_codigo);

        produtorRequest = new ProdutorRequest(context);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.btn_animation);


        btn_solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               btn_solicitar.startAnimation(myAnim);
                if (email.getText().toString().equals("") || cod.getText().toString().equals("")) {
                    viewToastAlerta(context, "Preecha todos os campos!");
                } else {

                    viewToast(context, "Aguarde...");
                    produtorRequest.recuperar_senha(Long.parseLong(cod.getText().toString()), email.getText().toString(), RecuperarActivity.this);


                }

            }

        });
    }

    public void request() {
        viewToast(context, "E-mail enviado!");
    }

    private class AsyncTaskExample extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            return null;
        }
    }
}