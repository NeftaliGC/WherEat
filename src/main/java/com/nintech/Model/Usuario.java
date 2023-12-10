package com.nintech.Model;

public class Usuario {
    private Nombre nombre;
    private Credenciales credenciales;

    public Usuario(Nombre nombre, Credenciales credenciales) {
        this.nombre = nombre;
        this.credenciales = credenciales;
    }

    public Nombre getNombre() {
        return this.nombre;
    }

}
