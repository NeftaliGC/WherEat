package com.nintech.Model;

public class Nombre {
    private String nombre;
    private String apellido;

    public Nombre(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String toString() {
        return this.nombre + " " + this.apellido;
    }
}
