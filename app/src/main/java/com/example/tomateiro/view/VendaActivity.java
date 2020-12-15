package com.example.tomateiro.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tomateiro.R;

import static com.example.tomateiro.model.CustonToast.viewToast;

public class VendaActivity extends AppCompatActivity {
    private Button btn_venda_menu;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);
        context = this;

        btn_venda_menu = findViewById(R.id.btn_venda_menu);
        btn_venda_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(context, btn_venda_menu);

                popup.getMenuInflater()
                        .inflate(R.menu.painek_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    AlertDialog alerta;
                    LayoutInflater inflater = LayoutInflater.from(context);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    View layout;

                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nova_venda:
                                layout = inflater.inflate(R.layout.nova_venda_fragmento, null);

                                Button btn_concluir = layout.findViewById(R.id.btn_concluir);
                                final EditText et_nova_venda_data = layout.findViewById(R.id.nova_venda_data);
                                final EditText et_nova_venda_quantidade = layout.findViewById(R.id.nova_venda_quantidade);
                                final EditText et_nova_venda_preco = layout.findViewById(R.id.nova_venda_preco);


                                btn_concluir.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        viewToast(context, "Venda cadastrada!");
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
    }
}