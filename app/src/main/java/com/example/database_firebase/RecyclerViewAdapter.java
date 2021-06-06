package com.example.database_firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    ArrayList<Model> list;
    Context mcontext;

    public RecyclerViewAdapter(ArrayList<Model> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_number.setText(list.get(position).getMobile());
        holder.tv_adress.setText(list.get(position).getAdress());
        holder.tv_pass.setText(list.get(position).getPass());
    }

    @Override
    public int getItemCount() {
       return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_number,tv_adress,tv_pass;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.tv_name);
            tv_number=itemView.findViewById(R.id.tv_number);
            tv_adress=itemView.findViewById(R.id.tv_adress);
            tv_pass=itemView.findViewById(R.id.tv_pass);
        }
    }
}
