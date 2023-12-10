package com.nintech.Controller;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class GetTable {
    public Map<String, Integer> table = new HashMap<String, Integer>();

    public GetTable() {
        // Usuarios, Turismo, Arquitectura, Geografia, Ingenieria, Biblioteca Central, Humanidades, Contaduria, Economia
        table.put("Usuarios", 0);
        table.put("Turismo", 1);
        table.put("Arquitectura", 2);
        table.put("Geografia", 3);
        table.put("Ingenieria", 4);
        table.put("Biblioteca Central", 5);
        table.put("Humanidades", 6);
        table.put("Contaduria", 7);
        table.put("Economia", 8);
        table.put("Cafe EDG", 9);
        table.put("Cafe Arqui", 10);
    }


    public List<String[]> getTableFrom(Object tabla) {

        int index;
        if(tabla instanceof String){
            index = table.get(tabla);
        } else {
            index = (int) tabla;
        }

        List<String[]> filas = new ArrayList<String[]>();
        String excelFileName = "menus.xlsx";
        String excelFileLocation = "src/main/resources/Data/" + excelFileName;
        File document = new File(excelFileLocation);
        System.out.println(document.getAbsolutePath());

        try {
            File file = new File(document.getAbsolutePath());
            FileInputStream fileInputStream = new FileInputStream(file);

            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(index); // Obtén la hoja del libro (índice del HashMap)

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
        return filas;
    }

}
