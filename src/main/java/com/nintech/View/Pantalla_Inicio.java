package com.nintech.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_Inicio extends JPanel{
    private JPanel p_inicio;
    private JLabel wherEatLabel;
    private JButton iniciarSesionButton;
    private JPanel Botones;
    private JButton registrarseButton;
    private JPanel InicioSesion;
    private JLabel correoLabelInicio;
    private JTextField correoFielInicio;
    private JPasswordField passwordFielInicio;
    private JLabel contraseñaLabelInicio;
    private JButton IniciarSesionButton;
    private JPanel Registrarse;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField2;
    private JPanel centro;
    private JButton regresarButton;
    private JButton regresarButtonRegistro;
    private JButton registrarseButtonForm;

    private CardLayout cardLayout = new CardLayout();

    public Pantalla_Inicio() {

        centro.setLayout(cardLayout);
        centro.add(getBotones(), "Card1");
        centro.add(getInicioSesion(), "Card2");
        centro.add(getRegistrarse(), "Card3");




        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Iniciar Sesion");
                cardLayout.show(getCentro(), "Card2");
                centro.revalidate();
                centro.repaint();
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Regresar");
                cardLayout.show(getCentro(), "Card1");
                centro.revalidate();
                centro.repaint();
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Registrarse");
                cardLayout.show(getCentro(), "Card3");
                centro.revalidate();
                centro.repaint();
            }
        });
        regresarButtonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Regresar");
                cardLayout.show(getCentro(), "Card1");
                centro.revalidate();
                centro.repaint();
            }
        });
    }

    public JPanel getP_inicio() {
        return p_inicio;
    }

    public JPanel getCentro() {
        return centro;
    }

    public JPanel getInicioSesion() {
        return InicioSesion;
    }

    public JPanel getRegistrarse() {
        return Registrarse;
    }

    public JPanel getBotones() {
        return Botones;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}


