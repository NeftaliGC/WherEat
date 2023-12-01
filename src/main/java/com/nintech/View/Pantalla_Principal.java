package com.nintech.View;

import javax.swing.*;
import java.awt.*;

public class Pantalla_Principal extends JPanel{
    private JPanel pantalla;
    private JTextField busqueda;
    private JComboBox filtros;
    private JButton buscarButton;
    private JLabel wherEatLabel;
    private JPanel header;
    private JPanel footer;
    private JScrollBar scrollBar;

    public Pantalla_Principal() {

    }

    public JPanel getP_principal() {
        return pantalla;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
