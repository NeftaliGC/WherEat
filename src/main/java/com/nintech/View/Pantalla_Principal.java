package com.nintech.View;

import javax.swing.*;

import com.nintech.Controller.mainController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Pantalla_Principal extends JPanel{

    private mainController mainController;
    private JPanel pantalla;
    private JTextField busquedaJTextField;
    private JComboBox filtros;
    private JButton buscarButton;
    private JLabel wherEatLabel;
    private JPanel header;
    private JPanel footer;
    private JPanel panelesInfo;
    private JPanel Facultades;
    private JScrollPane Facs;
    private JScrollPane Establecimiento;
    private JScrollPane BusquedaView;
    private JPanel Estab;
    private JTable Menu;
    private JLabel establecimientoLabel;
    private JLabel horarioLabel;
    private JLabel especialidadLabel;
    private JLabel numeroDeMesasLabel;
    private JTable resultados;
    private JComboBox seccionesFiltro;

    private CardLayout cardLayout = new CardLayout();

    public Pantalla_Principal(mainController mainController) {
        this.mainController = mainController;
        mainController.añadirEstablecimientos();
        createUIComponents();
        agregarTarjetasClicleables();
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda = busquedaJTextField.getText();
                String filtro = filtros.getSelectedItem().toString();

                if (filtro.equals("Facultad") && busqueda.equals("") && seccionesFiltro.getSelectedItem().toString().equals("Todas")) {
                    cardLayout.show(getPanelesInfo(), "Card1");
                    panelesInfo.revalidate();
                    panelesInfo.repaint();
                    busquedaJTextField.setText("");
                } else {
                    DefaultTableModel tableModel = new DefaultTableModel();
                    // nombreEstablecimiento, ubicacion, tipoEstablecimiento, comida, precio
                    tableModel.addColumn("Nombre");
                    tableModel.addColumn("Ubicacion");
                    tableModel.addColumn("Tipo");
                    tableModel.addColumn("Comida");
                    tableModel.addColumn("Precio");

                    var busquedas = mainController.busqueda(busqueda, filtro, seccionesFiltro.getSelectedItem().toString());



                    for (int i = 0; i < busquedas.size(); i++) {
                        String nombreEstablecimiento = busquedas.get(i)[0];
                        String ubicacion = busquedas.get(i)[1];
                        String tipoEstablecimiento = busquedas.get(i)[2];
                        String comida = busquedas.get(i)[3];
                        String precio = busquedas.get(i)[4];
                        tableModel.addRow(new Object[]{nombreEstablecimiento, ubicacion, tipoEstablecimiento, comida, precio});
                    }
                    resultados.setModel(tableModel);
                    cardLayout.show(getPanelesInfo(), "Card3");
                    panelesInfo.revalidate();
                    panelesInfo.repaint();
                    busquedaJTextField.setText("");
                }
            }
        });
        filtros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seccionesFiltro.removeAllItems();
                String filtro = filtros.getSelectedItem().toString();
                if (filtro.equals("Facultad")) {
                    var facs = mainController.getFacultades();
                    seccionesFiltro.addItem("Todas");
                    for (int i = 0; i < facs.length; i++) {
                        try {
                            seccionesFiltro.addItem(facs[i].getNombre());
                        } catch (Exception exception) {
                            continue;
                        }
                    }
                    seccionesFiltro.setVisible(true);
                } else if (filtro.equals("Especialidad")) {
                    var esp = mainController.getEspecialidades();
                    for (int i = 0; i < esp.length; i++) {
                        System.out.println(esp[i]);
                        try {
                            seccionesFiltro.addItem(esp[i]);
                        } catch (Exception exception) {
                            continue;
                        }
                    }
                    // Eliminar Items repetidos
                    for (int i = 0; i < seccionesFiltro.getItemCount(); i++) {
                        for (int j = 0; j < seccionesFiltro.getItemCount(); j++) {
                            if (i != j) {
                                if (seccionesFiltro.getItemAt(i).equals(seccionesFiltro.getItemAt(j))) {
                                    seccionesFiltro.removeItemAt(j);
                                }
                            }
                        }
                    }
                    seccionesFiltro.setVisible(true);
                }
            }
        });
        seccionesFiltro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion = seccionesFiltro.getSelectedItem().toString();
                if (opcion.equals("Todas")){
                    busquedaJTextField.setEditable(false);
                    busquedaJTextField.setText("");
                } else {
                    busquedaJTextField.setEditable(true);
                }
            }
        });
    }

    public JPanel getP_principal() {
        return pantalla;
    }

    public JPanel getPanelesInfo() {
        return panelesInfo;
    }

    private void agregarTarjetasClicleables() {
        // Crear un panel para el grid 3x3 y agregarlo en la parte inferior
        //int numFacultades = mainController.facultades.length;
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i <= mainController.numeroDeFacultades - 1; i++) {
            String nombreFacultad;
            int numeroEstablecimientos;
            try {
                nombreFacultad = mainController.facultades[i].getNombre();
                numeroEstablecimientos = mainController.facultades[i].getEstablecimientos().size();
            } catch (Exception e) {
                continue; //Desprecia registros vacios
            }

            JPanel tarjeta = crearTarjeta(nombreFacultad, numeroEstablecimientos);
            gridPanel.add(tarjeta);
        }
        Facultades.add(gridPanel, BorderLayout.CENTER);
    }

    // Método para crear una tarjeta como un panel
    private JPanel crearTarjeta(String nombre, int numeroEstablecimientos) {
        JPanel tarjeta = new JPanel(new BorderLayout());
        tarjeta.setBackground(Color.lightGray);
        tarjeta.setBorder(BorderFactory.createLineBorder(Color.black));
        tarjeta.setPreferredSize(new Dimension(150, 100));

        JLabel facultadLabel = new JLabel(nombre);
        facultadLabel.setHorizontalAlignment(JLabel.CENTER); // Centrar texto horizontalmente
        facultadLabel.setVerticalAlignment(JLabel.CENTER); // Centrar texto verticalmente

        JLabel establecimientosLabel = new JLabel("Número de establecimientos: " + numeroEstablecimientos);
        establecimientosLabel.setHorizontalAlignment(JLabel.CENTER); // Centrar texto horizontalmente
        establecimientosLabel.setVerticalAlignment(JLabel.CENTER); // Centrar texto verticalmente

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(facultadLabel);
        textPanel.add(establecimientosLabel);

        tarjeta.add(textPanel, BorderLayout.CENTER);

        tarjeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(getPanelesInfo(), "Card2");
                String tipo = mainController.getDataFacultad(nombre).getEstablecimientos().get(0).getTipo();
                String horario = mainController.getDataEstablecimiento(nombre, "Cafeteria " + nombre).getHorario();
                if (tipo.equals("Cafeteria")) {
                    int numeroMesas = mainController.getNumeroDeMesas(nombre, "Cafeteria " + nombre);
                    infoFacultad(nombre, horario, "null", numeroMesas);
                } else if (tipo.equals("Puesto de Comida")) {
                    String especialidad = mainController.getEspecialidad(nombre, "Cafeteria " + nombre);
                    infoFacultad(nombre, horario, especialidad, 0);
                }

                panelesInfo.revalidate();
                panelesInfo.repaint();
            }
        });

        return tarjeta;
    }

    public void infoFacultad(String nombre, String horario, String especialidad, int numeroMesas) {
        if (horario.equals("null"))
            horario = "No hay horario disponible";

        if (especialidad.equals("null"))
            especialidad = "No hay especialidad disponible";
        establecimientoLabel.setText(nombre);
        horarioLabel.setText("Horario: " + horario);
        especialidadLabel.setText("Especialidad: " + especialidad);
        numeroDeMesasLabel.setText(String.valueOf("Numero de mesas: " + numeroMesas));

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Comida");
        tableModel.addColumn("Precio");

        var menuEstablecimiento = mainController.getDataEstablecimiento(nombre, "Cafeteria " + nombre).getMenu().getPlatillos();

        for (int i = 1; i < menuEstablecimiento.length; i++) {
            String nombrePlatillo = menuEstablecimiento[i].getNombre();
            String precioPlatillo = menuEstablecimiento[i].getPrecio();
            tableModel.addRow(new Object[]{nombrePlatillo, "$"+precioPlatillo});
        }

        // Establecer auto creación de columnas desde el modelo
        Menu.setAutoCreateColumnsFromModel(true);

        Menu.setModel(tableModel);
        // Obtener el encabezado de la tabla y mostrarlo
        JTableHeader header = Menu.getTableHeader();
        header.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        panelesInfo.setLayout(cardLayout);
        panelesInfo.add(Facs, "Card1");
        panelesInfo.add(Establecimiento, "Card2");
        panelesInfo.add(BusquedaView, "Card3");
        seccionesFiltro.setVisible(false);

    }
}
