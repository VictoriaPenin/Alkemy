package com.app.biblioteca.entidades;

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String id;
    private ArrayList<Libro> librosPrestados;

    public Usuario() {
    }

    public Usuario(String nombre, String id, ArrayList<Libro> listaLibros) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados= listaLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

}
