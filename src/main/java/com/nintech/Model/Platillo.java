package com.nintech.Model;

public class Platillo {

    private String nombre;
    private String precio;

    public Platillo(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPrecio() {
        return this.precio;
    }

}
