package com.example.ejerciciopropuestoagendarecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener{

    Context context;
    View.OnClickListener listener;
    View.OnLongClickListener longClickListener;

    public Adaptador(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumno, parent, false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder hd, int position) {
        ((Holder)hd).bind(((Faltas)context).alumnos.get(position));
    }

    @Override
    public int getItemCount() {
        return ((Faltas)context).alumnos.size();
    }

    public void setClickListener(View.OnClickListener listener){
        if(listener!=null)
            this.listener = listener;
    }
    @Override
    public void onClick(View view){
        if(listener!=null)
            listener.onClick(view);
    }
    public void setLongClickListener(View.OnLongClickListener listener){
        if(listener!=null)
            longClickListener = listener;
    }
    @Override
    public boolean onLongClick(View view){
        if(longClickListener!=null){
            longClickListener.onLongClick(view);
        }
        return true;
    }
}
