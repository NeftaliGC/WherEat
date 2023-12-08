package com.nintech.Controller;
import java.util.List;

public class validarInicioSesion {

    private GetTable table = new GetTable();

    public boolean validarInicio(String correo, String contraseña) {

        List<String[]> filas = table.getTableFrom("Usuarios");

        try {
            // Realizar la búsqueda en el ArrayList de filas
            System.out.println(filas.size());

            for (String[] fila : filas) {

                boolean correoValido = fila[2].equals(correo);
                boolean contraseñaValida = fila[3].equals(contraseña);
                System.out.println(correoValido + " " + contraseñaValida);

                System.out.println(fila[2] + " " + fila[3]);
                if (fila[2].equals(correo) && fila[3].equals(contraseña)) {
                    return true; // Si se encuentra la combinación de correo y contraseña, retornar true
                }
            }
        } catch (Exception e) {
            return false; // Si ocurre un error en la busqueda, retornar false
        }
        return false; // Si no se encuentra, retornar false
    }

    public boolean correoIsExist(String correo) {

        var filas = table.getTableFrom("Usuarios");

        try {
            // Realizar la búsqueda en el ArrayList de filas
            System.out.println(filas.size());

            for (String[] fila : filas) {

                boolean correoValido = fila[2].equals(correo);
                System.out.println(correoValido);

                System.out.println(fila[2]);
                if (fila[2].equals(correo)) {
                    return true; // Si se encuentra la combinación de correo y contraseña, retornar true
                }
            }
        } catch (Exception e) {
            return false; // Si ocurre un error en la busqueda, retornar false
        }
        return false; // Si no se encuentra, retornar false
    }

}
