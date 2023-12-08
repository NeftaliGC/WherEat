package com.nintech;
import com.nintech.Controller.mainController;
import com.nintech.View.Pantalla_Inicio;
import com.nintech.View.Pantalla_Principal;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        mainController mainController = new mainController();

        Pantalla_Inicio pantalla_inicio = new Pantalla_Inicio(mainController);
        JFrame frame = new JFrame("WhereEat");
        frame.setContentPane(pantalla_inicio.getP_inicio());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        while (!pantalla_inicio.confirm) {
            System.out.println("Esperando");
        }

        Pantalla_Principal pantalla_principal = new Pantalla_Principal(mainController);
        frame.setContentPane(pantalla_principal.getP_principal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}