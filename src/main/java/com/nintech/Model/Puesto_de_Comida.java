package com.nintech.Model;

public class Puesto_de_Comida extends Establecimiento{

    private String especialidad;

    public Puesto_de_Comida(String nombre, String horario, Menu menu, String tipo, String especialidad) {
        super(nombre, horario, menu, tipo);
        this.especialidad = especialidad;
    }


    public String getEspecialidad() {
        return this.especialidad;
    }

}
