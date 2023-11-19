package com.nintech.Model;

public class Establecimiento {

    private String nombre;
    private String horario;

    private Menu menu;

    public Establecimiento(String nombre, String horario, Menu menu) {
        this.nombre = nombre;
        this.horario = horario;
        this.menu = menu;
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

}
