package com.nintech.Controller;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class registro {

    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contraseña){
        String excelFileName = "menus.xlsx";
        String excelFileLocation = "src/main/resources/Data/" + excelFileName;
        File document = new File(excelFileLocation);
        System.out.println(document.getAbsolutePath());
        try {
            FileInputStream fileInputStream = new FileInputStream(document.getAbsolutePath());
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);

            int lastRow = sheet.getLastRowNum();

            // Encontrar la próxima fila vacía para insertar datos
            int newRow = lastRow + 1;
            boolean foundEmptyRow = false;

            for (int i = lastRow; i >= 0; i--) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    newRow = i;
                    foundEmptyRow = true;
                    break;
                } else {
                    boolean isEmpty = true;
                    for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                        Cell cell = currentRow.getCell(j);
                        if (cell != null && !cell.toString().isEmpty()) {
                            isEmpty = false;
                            break;
                        }
                    }
                    if (isEmpty) {
                        newRow = i;
                        foundEmptyRow = true;
                        break;
                    }
                }
            }

            if (!foundEmptyRow) {
                newRow = lastRow + 1;
            }

            Row row = sheet.createRow(newRow);

            row.createCell(0).setCellValue(nombres);
            row.createCell(1).setCellValue(apellidos);
            validarInicioSesion validarSesion = new validarInicioSesion();
            //Validar que la contraseña contenga al menos una letra
            if (!contraseña.matches(".*[a-zA-Z]+.*")) {
                System.out.println("La contraseña debe contener al menos una letra");
                fileInputStream.close();
                workbook.close();
                return false;
            }
            if (!validarSesion.correoIsExist(correo)) {
                row.createCell(2).setCellValue(correo);
                row.createCell(3).setCellValue(contraseña);
            } else {
                System.out.println("El correo ya existe");
                fileInputStream.close();
                workbook.close();
                return false;
            }

            FileOutputStream fileOutputStream = new FileOutputStream(document.getAbsolutePath());
            workbook.write(fileOutputStream);

            fileInputStream.close();
            fileOutputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
