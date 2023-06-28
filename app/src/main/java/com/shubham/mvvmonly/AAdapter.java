package com.shubham.mvvmonly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AAdapter extends RecyclerView.Adapter<AAdapter.MyViewHolder> {

    Context context;
    String actor;

    public AAdapter(Context context, String actor) {
        this.context = context;
        this.actor = actor;
    }

    @NonNull
    @Override
    public AAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AAdapter.MyViewHolder holder, int position) {
        holder.fact.setText(actor);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView fact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fact = itemView.findViewById(R.id.name);
        }
    }
}
