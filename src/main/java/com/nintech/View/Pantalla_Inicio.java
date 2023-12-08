package com.nintech.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.nintech.Controller.mainController;

public class Pantalla_Inicio extends JPanel{

    private mainController mainController;
    public boolean confirm = false;
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
    private JTextField textFieldNombres;
    private JTextField textFieldApellidos;
    private JTextField textFieldCorreo;
    private JPasswordField passwordFieldRegistro;
    private JPanel centro;
    private JButton regresarButton;
    private JButton regresarButtonRegistro;
    private JButton registrarseButtonForm;
    private JLabel inicioSesionErrorField;
    private JLabel errorRegistroField;

    private CardLayout cardLayout = new CardLayout();

    public Pantalla_Inicio(mainController mainController) {
        this.mainController = mainController;
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
                System.out.println("INICIANDO SESION -----------------------------");
                inicioSesionErrorField.setVisible(false);
                String correo = correoFielInicio.getText();
                String contraseña = passwordFielInicio.getText();
                if(mainController.iniciarSesion(correo, contraseña)) {
                    confirm = true;
                } else {
                    inicioSesionErrorField.setText("Correo o contraseña incorrectos!!!");
                    inicioSesionErrorField.setForeground(Color.red);
                    inicioSesionErrorField.setVisible(true);
                }
            }
        });
        registrarseButtonForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombres = textFieldNombres.getText();
                String apellidos = textFieldApellidos.getText();
                String correo = textFieldCorreo.getText();
                String contraseña = passwordFieldRegistro.getText();

                if(mainController.registrarUsuario(nombres, apellidos, correo, contraseña)) {
                    cardLayout.show(getCentro(), "Card1");
                    centro.revalidate();
                    centro.repaint();
                } else {
                    errorRegistroField.setText("El correo ya existe!!!");
                    errorRegistroField.setForeground(Color.red);
                    errorRegistroField.setVisible(true);
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

    private void ocultarLogin(boolean confirm) {
        if (confirm) {
            InicioSesion.setVisible(false);
        } else {
            InicioSesion.setVisible(true);
        }
    }

}


