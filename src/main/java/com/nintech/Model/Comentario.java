package com.nintech.Model;

public class Comentario {
    private Usuario usuario;
    private String contenido;

    public Comentario(Usuario usuario, String contenido) {
        this.usuario = usuario;
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public String getContenido() {
        return this.contenido;
    }

}
