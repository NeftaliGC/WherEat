package com.nintech.Model;

public class Menu {
    private Platillo platillos[];

    public Menu(Platillo platillos[]) {
        this.platillos = platillos;
    }

    public Platillo[] getPlatillos() {
        return this.platillos;
    }

}
