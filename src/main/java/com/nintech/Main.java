package com.nintech;
import com.nintech.View.Pantalla_Inicio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("WhereEat");
        frame.setContentPane(new Pantalla_Inicio().getP_inicio());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}