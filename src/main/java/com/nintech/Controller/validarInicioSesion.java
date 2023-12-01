package com.nintech.Controller;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class validarInicioSesion {

    public boolean validarInicio(String correo, String contraseña) {
        List<String[]> filas = new ArrayList<String[]>();

        try {
            File file = new File("D:\\Nintech\\Proyectos\\Programas\\java\\WherEat\\WherEat\\src\\main\\resources\\Data\\menus.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);

            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Obtén la primera hoja del libro (índice 0)

            // Leer todas las filas y guardarlas en un ArrayList
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                List<String> valoresCelda = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            valoresCelda.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            valoresCelda.add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        // Puedes manejar otros tipos de celda según sea necesario
                        default:
                            valoresCelda.add(""); // Agregar un valor vacío para otros tipos de celda
                    }
                }
                filas.add(valoresCelda.toArray(new String[0]));
            }

            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        return false; // Si no se encuentra, retornar false
    }



}
