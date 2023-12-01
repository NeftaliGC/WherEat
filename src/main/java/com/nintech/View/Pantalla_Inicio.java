package com.nintech.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.nintech.Controller.mainController;
import com.nintech.View.Pantalla_Principal;

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

        createUIComponents();

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
        IniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController mainController = new mainController();
                String correo = correoFielInicio.getText();
                String contraseña = passwordFielInicio.getText();
                if(mainController.iniciarSesion(correo, contraseña)) {
                    System.out.println("Iniciar Sesion");
                    JFrame frame = new JFrame("WhereEat");
                    frame.setContentPane(new Pantalla_Principal().getP_principal());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    System.out.println("No Iniciar Sesion");
                }
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
        centro.setLayout(cardLayout);
        centro.add(getBotones(), "Card1");
        centro.add(getInicioSesion(), "Card2");
        centro.add(getRegistrarse(), "Card3");
    }

}


