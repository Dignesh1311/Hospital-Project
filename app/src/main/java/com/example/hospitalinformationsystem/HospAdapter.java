package com.example.hospitalinformationsystem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HospAdapter extends RecyclerView.Adapter<HospAdapter.ViewHolder> {
    private Hospital[] hos;
    static Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_list,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hname.setText(hos[position].getHospName());
        holder.hadress.setText(hos[position].getAddress());
        holder.nobed.setText(hos[position].getAmtbed());
        holder.amtoxy.setText(hos[position].getAmtoxy());
        holder.amtamb.setText(hos[position].getAmtamb());
        holder.logo.setImageResource(hos[position].getLogo());
    }

    @Override
    public int getItemCount() {
        return hos.length;
    }

    public void setItems(Hospital[] hos) {
        this.hos =hos;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView hname;
        private final TextView hadress;
        private final TextView nobed;
        private final TextView amtoxy;
        private final TextView amtamb;
        private final ImageView logo;
        private final Button breq;
        private final Button ctran;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hname=itemView.findViewById(R.id.hname);
            hadress=itemView.findViewById(R.id.address);
            nobed=itemView.findViewById(R.id.bamt);
            amtoxy=itemView.findViewById(R.id.oamt);
            amtamb=itemView.findViewById(R.id.amtamb);
            logo=itemView.findViewById(R.id.logo);
            breq=itemView.findViewById(R.id.breq);
            ctran=itemView.findViewById(R.id.ctran);
            breq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,BedRequest.class);
                    context.startActivity(intent);

                }
            });

           ctran.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(context,Case_Transfer.class);
                   intent.putExtra("Hospital Name",hname.getText().toString());
                   context.startActivity(intent);
               }
           });
        }
    }
}
