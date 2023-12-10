package com.nintech.Model;

public class Cafeteria extends Establecimiento{

    private int numeroMesas;

    public Cafeteria(String nombre, String horario, Menu menu, String tipo, int numeroMesas) {
        super(nombre, horario, menu, tipo);
        this.numeroMesas = numeroMesas;
    }

    public int getNumeroMesas() {
        return this.numeroMesas;
    }

}
