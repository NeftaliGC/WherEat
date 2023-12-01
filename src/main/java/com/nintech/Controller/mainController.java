package com.nintech.Controller;

public class mainController {
    public mainController() {
        System.out.println("mainController Activo");
    }

    public boolean iniciarSesion(String correo, String contraseña) {
        System.out.println("Iniciar Sesion");
        validarInicioSesion validarSesion = new validarInicioSesion();
        boolean result = validarSesion.validarInicio(correo, contraseña);
        return result;
    }
    
}
