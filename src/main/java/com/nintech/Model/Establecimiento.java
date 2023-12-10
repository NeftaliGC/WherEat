package com.nintech.Model;

public abstract class Establecimiento {

    private String nombre;
    private String horario;
    private String tipo;
    private Menu menu;

    public Establecimiento(String nombre, String horario, Menu menu, String tipo) {
        this.nombre = nombre;
        this.horario = horario;
        this.menu = menu;
        this.tipo = tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getHorario() {
        return this.horario;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public String getTipo() {
        return this.tipo;
    }

}
