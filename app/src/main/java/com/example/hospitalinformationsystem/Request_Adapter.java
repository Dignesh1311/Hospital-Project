package com.example.hospitalinformationsystem;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Request_Adapter extends RecyclerView.Adapter<Request_Adapter.ViewHolder> {
    private Request req;

    @NonNull
    @Override
    public Request_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_status, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Request_Adapter.ViewHolder holder, int position) {
        holder.date.setText(req.getDate());
        holder.pname.setText(req.getPname());
        holder.req.setText(req.getReqtype());
        if (req.getStatus().equals("Pending")) ;
        {
            holder.status.setTextColor(Color.YELLOW);
            holder.status.setText(req.getStatus());
        }
        if (req.getStatus().equals("Approved")) ;
        {
            holder.status.setTextColor(Color.GREEN);
            holder.status.setText(req.getStatus());
        }
        if (req.getStatus().equals("Rejected")) ;
        {
            holder.status.setTextColor(Color.RED);
            holder.status.setText(req.getStatus());
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setItems(Request req) {
        this.req = req;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView date;
        private final TextView pname;
        private final TextView req;
        private final TextView status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dattim);
            pname = itemView.findViewById(R.id.patname);
            req = itemView.findViewById(R.id.reqtype);
            status = itemView.findViewById(R.id.rstatus);
        }
    }
}