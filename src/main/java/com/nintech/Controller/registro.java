package com.nintech.Controller;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class registro {

    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contraseña){
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\Nintech\\Proyectos\\Programas\\java\\WherEat\\WherEat\\src\\main\\resources\\Data\\menus.xlsx");
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);

            int lastRow = sheet.getLastRowNum();

            Row row = sheet.createRow(lastRow + 1);

            row.createCell(0).setCellValue(nombres);
            row.createCell(1).setCellValue(apellidos);
            validarInicioSesion validarSesion = new validarInicioSesion();
            if (!validarSesion.correoIsExist(correo)) {
                row.createCell(2).setCellValue(correo);
                row.createCell(3).setCellValue(contraseña);
            } else {
                System.out.println("El correo ya existe");
                fileInputStream.close();
                workbook.close();
                return false;
            }

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Nintech\\Proyectos\\Programas\\java\\WherEat\\WherEat\\src\\main\\resources\\Data\\menus.xlsx");
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
