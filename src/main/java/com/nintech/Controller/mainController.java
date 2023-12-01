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

    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contraseña) {
        System.out.println("Registrar Usuario");
        registro registro = new registro();
        boolean result = registro.registrarUsuario(nombres, apellidos, correo, contraseña);
        return result;
    }
    
}
