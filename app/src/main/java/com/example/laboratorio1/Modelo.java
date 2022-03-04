package com.example.laboratorio1;

public class Modelo {

    //Declaracion de los atributos de la clase
    private String categoria;
    private String descripcion;
    private int icono;


    //constructor de la clase
    public Modelo(String categoria, String descripcion, int icono) {
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.icono = icono;
    }


    //Metodos Getter y Setter
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }


}
