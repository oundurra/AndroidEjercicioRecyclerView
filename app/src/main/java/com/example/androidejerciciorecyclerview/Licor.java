package com.example.androidejerciciorecyclerview;

public class Licor {
    private String nombre;
    private String tipo;
    private String pais;
    private String presentacion;
    private String foto;
    private int precio;

    public Licor(String nombre, String tipo, String pais, String presentacion, String foto, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.pais = pais;
        this.presentacion = presentacion;
        this.foto = foto;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
