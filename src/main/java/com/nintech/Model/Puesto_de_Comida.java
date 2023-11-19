package com.nintech.Model;

public class Puesto_de_Comida extends Establecimiento{

    private String especialidad;

    public Puesto_de_Comida(String nombre, String horario, Menu menu, String especialidad) {
        super(nombre, horario, menu);
        this.especialidad = especialidad;
    }

}
