package com.nintech.Model;

public class Facultad {
    private String nombre;
    private Establecimiento establecimientos[];

    public Facultad(String nombre, Establecimiento establecimientos[]) {
        this.nombre = nombre;
        this.establecimientos = establecimientos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Establecimiento[] getEstablecimientos() {
        return this.establecimientos;
    }
}
