package com.nintech.Controller;

import java.util.List;

public class FindUser {

    public String[] findUser(String correo, String contraseña) {
        GetTable table = new GetTable();
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
                    String[] user = {fila[0], fila[1], fila[2], fila[3]};
                    return user;
                }
            }
        } catch (Exception e) {
            return null; // Si ocurre un error en la busqueda, retornar null
        }
        return null; // Si no se encuentra, retornar null
    }

}
