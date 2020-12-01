package com.example.tomateiro.view.adapter;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tomateiro.R;
import com.example.tomateiro.model.Safra;
import com.example.tomateiro.view.custo.CustoA_Activity;
import com.example.tomateiro.view.custo.CustoB_Activity;
import com.example.tomateiro.view.custo.CustoC_Activity;
import com.example.tomateiro.view.custo.CustoD_Activity;
import com.example.tomateiro.view.custo.CustoE_Activity;

import java.util.List;


public class SafraAdapter extends RecyclerView.Adapter<SafraAdapter.SafraViewHolder> {
    private Context context;
    private List<Safra> safraList;
    private Intent intent;
    private int position;

    public SafraAdapter(Context context, List<Safra> safragemslis) {
        this.context = context;
        this.safraList = safragemslis;

    }

    @NonNull
    @Override
    public SafraAdapter.SafraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_safra, parent, false);
        return new SafraViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SafraAdapter.SafraViewHolder holder, int position) {

    }

    public class SafraViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        Button cardButtonMenu;


        public SafraViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view_safra);
            cardButtonMenu = itemView.findViewById(R.id.card_btn_menu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {

//                        }

                    }

                }
            });

            cardButtonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        PopupMenu popup = new PopupMenu(context, view);
                        popup.inflate(R.menu.custo_menu);

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                switch (menuItem.getItemId()) {
                                    case R.id.custoA:
                                        intent = new Intent(context, CustoA_Activity.class);
                                        context.startActivity(intent);

                                        return true;
                                    case R.id.custoB:
                                        intent = new Intent(context, CustoB_Activity.class);
                                        context.startActivity(intent);

                                        return true;
                                    case R.id.custoC:
                                        intent = new Intent(context, CustoC_Activity.class);
                                        context.startActivity(intent);

                                        return true;
                                    case R.id.custoD:
                                        intent = new Intent(context, CustoD_Activity.class);
                                        context.startActivity(intent);

                                        return true;
                                    case R.id.custoE:
                                        intent = new Intent(context, CustoE_Activity.class);
                                        context.startActivity(intent);

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popup.show();

                    }
                }
            });

        }

    }

    public List<Safra> getSafraList() {
        return safraList;
    }

    public void setSafraList(List<Safra> safraList) {
        this.safraList = safraList;
    }

    @Override
    public int getItemCount() {
        return safraList.size();
    }

}
