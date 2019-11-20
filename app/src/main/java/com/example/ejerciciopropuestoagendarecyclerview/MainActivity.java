package com.example.ejerciciopropuestoagendarecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Alumno> alumnos;
    private Button faltasButton;
    private Button GuardarButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alumnos = getIntent().getParcelableArrayListExtra("Alumnos");
        faltasButton = (Button)findViewById(R.id.faltasButton);
        faltasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargaAlumnos();
                Intent intent = new Intent(MainActivity.this, Faltas.class);
                intent.putParcelableArrayListExtra("Alumnos", alumnos);
                startActivity(intent);
            }
        });
        GuardarButton = (Button)findViewById(R.id.guardarButton);
        GuardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribeXML();
            }
        });
    }

    protected void cargaAlumnos(){
        alumnos = new ArrayList<>();
        Alumno alumno = new Alumno("Soto", "Aitor", false, false, false, false, "Es un maquina");
        alumnos.add(alumno);
        Alumno a = new Alumno("Ramos", "Sergio", false, false, false, true, "Otro maquina");
        alumnos.add(a);
        Alumno al = new Alumno("Marcos", "Marcos", true, false, false, true, "Ste men :v");
        alumnos.add(al);
        Alumno alu = new Alumno("Collado", "Ismael", true, false, false, true, "Isamel lmao");
        alumnos.add(alu);
    }

    public void escribeXML(){
        FileOutputStream fout = null;
        try{
            fout = openFileOutput("alumnos.xml", MODE_PRIVATE);
        }catch (FileNotFoundException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        XmlSerializer serializer = Xml.newSerializer();
        try{
            serializer.setOutput(fout, "UTF-8");
            serializer.startDocument(null, true);
            serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

            serializer.startTag(null, "alumnos");
            for(Alumno alumno : alumnos){
                añadeXML(serializer, alumno);
            }
            serializer.endTag(null,"alumnos");
            serializer.endDocument();
            serializer.flush();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void añadeXML(XmlSerializer serializer, Alumno alumno) throws IOException {
        serializer.startTag(null, "alumno");
        serializer.startTag(null, "Apellido");
        serializer.attribute(null, "Nombre", alumno.getNombre());
        serializer.attribute(null, "Falta", String.valueOf(alumno.isFalta()));
        serializer.text(alumno.getApellido());
        serializer.endTag(null, "Apellido");
        serializer.startTag(null, "Comportamiento");
        serializer.attribute(null, "Trabaja", String.valueOf(alumno.isTrabaja()));
        serializer.attribute(null, "NoTrabaja", String.valueOf(alumno.isNoTrabaja()));
        serializer.attribute(null, "Molesta", String.valueOf(alumno.isMolesta()));
        serializer.text(alumno.getComportamiento());
        serializer.endTag(null, "Comportamiento");
        serializer.endTag(null, "alumno");
    }
}
