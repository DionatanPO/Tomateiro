package com.example.tomateiro.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.tomateiro.R;

public class  CustonView {

    public void  showDialog(Activity activity, String msg, String titulo) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        TextView titulo_dialog = (TextView) dialog.findViewById(R.id.titulo_dialog);
        titulo_dialog.setText(titulo);

        TextView msg_dialog = (TextView) dialog.findViewById(R.id.text_dialog);
        msg_dialog.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
