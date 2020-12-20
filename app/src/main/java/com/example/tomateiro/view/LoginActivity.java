package com.example.tomateiro.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.tomateiro.R;
import com.example.tomateiro.controller.ProdutorController;
import com.example.tomateiro.model.Produtor;
import com.example.tomateiro.request.ProdutorRequest;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class LoginActivity extends AppCompatActivity {
    private EditText editText_codigo, editText_senha;
    private String codigo, senha;
    private Button btn_registrar, getBtn_entrar;
    private Context context;
    private Produtor produtor;
    private ProdutorController produtorController;
    private CheckBox checkBox;
    private ProdutorRequest produtorRequest;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    private Boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        produtor = new Produtor();
        produtorController = new ProdutorController(context);
        produtorRequest = new ProdutorRequest(context);

        btn_registrar = findViewById(R.id.btn_registrar);
        getBtn_entrar = findViewById(R.id.btn_entrar);

        editText_codigo = findViewById(R.id.login_codigo);
        editText_senha = findViewById(R.id.login_senha);

        checkBox = findViewById(R.id.checkbox);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegistroActivity.class);
                startActivity(intent);
            }
        });


        getBtn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                produtor.setCodIdentificacao(editText_codigo.getText().toString());
                produtor.setSenha(editText_senha.getText().toString());

                if (produtorController.validar_login(produtor)) {
                    viewToast(context, "Autenticando...");
                    produtorRequest.login(produtorController.converter_produtor_json(produtor), LoginActivity.this);

                } else {

                }


            }
        });
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        checked = loginPreferences.getBoolean("saveLogin", false);

        if (checked == true) {
            checkBox.setChecked(true);
            editText_codigo.setText(loginPreferences.getString("codigo", ""));
            editText_senha.setText(loginPreferences.getString("senha", ""));
        } else {
            checkBox.setChecked(false);
            editText_codigo.setText(loginPreferences.getString("codigo", ""));
            editText_senha.setText(loginPreferences.getString("senha", ""));
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    codigo = editText_codigo.getText().toString();
                    senha = editText_senha.getText().toString();

                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("codigo", codigo);
                    loginPrefsEditor.putString("senha", senha);
                    loginPrefsEditor.apply();


                } else if (!compoundButton.isChecked()) {
                    editText_codigo.setText("");
                    editText_senha.setText("");
                    loginPrefsEditor.putBoolean("saveLogin", false);
                    loginPrefsEditor.putString("codigo", "");
                    loginPrefsEditor.putString("senha", "");
                    loginPrefsEditor.apply();

                }
            }
        });
    }

    public void login_request(Produtor produtor) {
        Intent intent = new Intent(context, PainelActivity.class);
        intent.putExtra("produtor", produtor);
        startActivity(intent);
    }
}