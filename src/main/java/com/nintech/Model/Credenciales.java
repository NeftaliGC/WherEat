package com.nintech.Model;

public class Credenciales {
    private String Correo;
    private String Contrasena;
    private int IdUsuario;

    public Credenciales(String Correo, String Contrasena, int IdUsuario) {
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.IdUsuario = IdUsuario;
    }

    public int getIdUsuario() {
        return this.IdUsuario;
    }
}
