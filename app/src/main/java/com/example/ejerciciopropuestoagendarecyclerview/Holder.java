package com.example.ejerciciopropuestoagendarecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    TextView txtNombre, txtApellido;

    public Holder(@NonNull View itemView) {
        super(itemView);
        txtNombre = (TextView) itemView.findViewById(R.id.nombre);
        txtApellido = (TextView) itemView.findViewById(R.id.apellidos);
    }

    public void bind(Alumno alumno){
        txtApellido.setText(alumno.getApellido());
        txtNombre.setText(alumno.getNombre());
    }
}
