package com.example.ejerciciopropuestoagendarecyclerview;

import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Faltas extends AppCompatActivity {
    public ArrayList<Alumno> alumnos;
    RecyclerView recyclerView;
    ImageView falta;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        alumnos = new ArrayList<>();
        alumnos = getIntent().getParcelableArrayListExtra("Alumnos");
        Adaptador adaptador = new Adaptador(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        adaptador.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                falta = (ImageView)findViewById(R.id.falta);
                if (falta.getVisibility() == View.VISIBLE)
                    falta.setVisibility(View.GONE);
                else
                    falta.setVisibility(View.VISIBLE);
            }
        });
        adaptador.setLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Faltas.this);

                LayoutInflater inflater = Faltas.this.getLayoutInflater();
                int pos = recyclerView.getChildAdapterPosition(v);
                builder.setView(inflater.inflate(R.layout.comportamiento_dialog, null))
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();
                return false;
            }
        });
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Faltas.this, MainActivity.class);
                intent.putParcelableArrayListExtra("Alumnos", alumnos);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adaptador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        Toast.makeText(this, alumnos.get(2).getNombre(), Toast.LENGTH_SHORT).show();
    }
}
