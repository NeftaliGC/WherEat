package com.nintech.Model;
import java.util.ArrayList;

public class Facultad {
    private String nombre;
    private ArrayList<Establecimiento> establecimientos = new ArrayList<Establecimiento>();

    public Facultad(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Establecimiento> getEstablecimientos() {
        return this.establecimientos;
    }

    public void setEstablecimientos(Establecimiento establecimiento) {
        this.establecimientos.add(establecimiento);
    }
}
