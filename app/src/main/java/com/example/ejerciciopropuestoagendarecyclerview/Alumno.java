package com.example.ejerciciopropuestoagendarecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Alumno implements Parcelable {
    public String Apellido;
    public String Nombre;
    public boolean Falta;
    public boolean Trabaja;
    public boolean NoTrabaja;
    public boolean Molesta;
    public String Comportamiento;

    public Alumno() {
    }

    public Alumno(String apellido, String nombre, boolean falta, boolean trabaja, boolean noTrabaja, boolean molesta, String comportamiento) {
        Apellido = apellido;
        Nombre = nombre;
        Falta = falta;
        Trabaja = trabaja;
        NoTrabaja = noTrabaja;
        Molesta = molesta;
        Comportamiento = comportamiento;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public boolean isFalta() {
        return Falta;
    }

    public void setFalta(boolean falta) {
        Falta = falta;
    }

    public boolean isTrabaja() {
        return Trabaja;
    }

    public void setTrabaja(boolean trabaja) {
        Trabaja = trabaja;
    }

    public boolean isNoTrabaja() {
        return NoTrabaja;
    }

    public void setNoTrabaja(boolean noTrabaja) {
        NoTrabaja = noTrabaja;
    }

    public boolean isMolesta() {
        return Molesta;
    }

    public void setMolesta(boolean molesta) {
        Molesta = molesta;
    }

    public String getComportamiento() {
        return Comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        Comportamiento = comportamiento;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "Apellido='" + Apellido + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Falta=" + Falta +
                ", Trabaja=" + Trabaja +
                ", NoTrabaja=" + NoTrabaja +
                ", Molesta=" + Molesta +
                ", Comportamiento='" + Comportamiento + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Apellido);
        dest.writeString(this.Nombre);
        dest.writeByte(this.Falta ? (byte) 1 : (byte) 0);
        dest.writeByte(this.Trabaja ? (byte) 1 : (byte) 0);
        dest.writeByte(this.NoTrabaja ? (byte) 1 : (byte) 0);
        dest.writeByte(this.Molesta ? (byte) 1 : (byte) 0);
        dest.writeString(this.Comportamiento);
    }

    protected Alumno(Parcel in) {
        this.Apellido = in.readString();
        this.Nombre = in.readString();
        this.Falta = in.readByte() != 0;
        this.Trabaja = in.readByte() != 0;
        this.NoTrabaja = in.readByte() != 0;
        this.Molesta = in.readByte() != 0;
        this.Comportamiento = in.readString();
    }

    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel source) {
            return new Alumno(source);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };
}
