package com.app.biblioteca.servicios;

import com.app.biblioteca.entidades.Libro;

import java.util.ArrayList;
import java.util.Scanner;

public class LibroServicio {

    private ArrayList<Libro> listadoLibros;
    private Scanner read;

    public LibroServicio(ArrayList<Libro> arrayLibros) {
        this.listadoLibros = arrayLibros;
        this.read = new Scanner(System.in).useDelimiter("\n");
    }

    public void crearLibro() {

        Libro libroNuevo = new Libro();

        System.out.println("Creemos un libro");
        System.out.println("Ingresá el titulo del libro:");
        libroNuevo.setTitulo(read.next());
        System.out.println("Ingresá el autor del libro:");
        libroNuevo.setAutor(read.next());
        System.out.println("Ingresá el ISBN del libro:");
        libroNuevo.setIsbn(read.next());
        System.out.println("Ingresá el género del libro:");
        libroNuevo.setGenero(read.next());
        libroNuevo.setDisponible(true);
        listadoLibros.add(libroNuevo);

        System.out.println("Libro creado con éxito.");

    }

    public ArrayList<Libro> listarLibros() {
        if (!listadoLibros.isEmpty()) {
            System.out.println("Libros disponibles:");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %20s %20s %20s", "ISBN", "TITULO", "AUTOR", "GENERO", "DISPONIBLE");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------");
            for (Libro libro : listadoLibros) {
                System.out.printf("%5s %20s %20s %20s %20s", libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.isDisponible());
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------------------------------");
            return listadoLibros;

        } else {
            System.out.println("No hay libros disponibles");
            return null;
        }

    }

    public void listarLibrosPrestados() {
        if (!listadoLibros.isEmpty()) {
            System.out.println("Libros prestados:");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%5s %20s %20s %20s", "ISBN", "TITULO", "AUTOR", "GENERO");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            for (Libro libro : listadoLibros) {
                if (!libro.isDisponible()) {
                    System.out.printf("%5s %20s %20s %20s", libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getGenero());
                    System.out.println();
                }
            }
            System.out.println("-----------------------------------------------------------------------------");

        } else {
            System.out.println("No hay libros disponibles");
        }
    }


    public Libro buscarLibroPorIsbn() {
        System.out.println("Ingresa el isbn a buscar");
        String isbnBuscado = read.next().toLowerCase();
        if (!listadoLibros.isEmpty()) {

            for (Libro libro : listadoLibros) {
                if (libro.getIsbn().toLowerCase().equals(isbnBuscado)) {
                    System.out.println("Libro localizado: " + libro.getTitulo());
                    return libro;
                }
            }

        } else {
            System.out.println("No hay libros disponibles");
            return null;
        }
        return null;
    }

    public void buscarLibroPorGenero() {
        System.out.println("Ingresa el genero a buscar:");
        String generoBuscado = read.next().toLowerCase();

        if (!listadoLibros.isEmpty()) {
            System.out.println("Libros disponibles del genero:");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %20s %20s %20s", "ISBN", "TITULO", "AUTOR", "GENERO", "DISPONIBLE");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------");
            for (Libro libro : listadoLibros) {
                if (libro.getGenero().toLowerCase().equals(generoBuscado)) {
                    System.out.printf("%5s %20s %20s %20s %20s", libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.isDisponible());
                    System.out.println();
                }
            }
            System.out.println("------------------------------------------------------------------------------------------");
        } else {
            System.out.println("No hay libros con el genero buscado");
        }
    }

    public void buscarLibroPorAutor() {
        System.out.println("Ingresa el autor a buscar:");
        String autorBuscado = read.next().toLowerCase();

        if (!listadoLibros.isEmpty()) {
            System.out.println("Libros disponibles del Autor:");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %20s %20s %20s", "ISBN", "TITULO", "AUTOR", "GENERO", "DISPONIBLE");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------");
            for (Libro libro : listadoLibros) {
                if (libro.getAutor().toLowerCase().equals(autorBuscado)) {
                    System.out.printf("%5s %20s %20s %20s %20s", libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.isDisponible());
                    System.out.println();
                }
            }
            System.out.println("------------------------------------------------------------------------------------------");
        } else {
            System.out.println("No hay libros con el genero buscado");
        }
    }

    public void actualizarLibro() {
        System.out.println("Actualicemos el libro:");
        Libro libroActualizado = buscarLibroPorIsbn();

        if (libroActualizado != null) {
            System.out.println("Actualicemos el titulo: ");
            libroActualizado.setTitulo(read.next());
            System.out.println("Actualicemos el genero: ");
            libroActualizado.setGenero(read.next());
            System.out.println("Actualicemos el autor: ");
            libroActualizado.setAutor(read.next());

            System.out.println("Libro actualizado con exito");
        }
    }

    public void eliminarLibro() {
        System.out.println("Eliminemos un libro: ");
        Libro libroEliminado = buscarLibroPorIsbn();

        if (libroEliminado != null) {
            listadoLibros.removeIf(libro -> libro.getIsbn().equals(libroEliminado.getIsbn()));
            System.out.println("El libro se ha eliminado");
        } else {
            System.out.println("No se pudo localizar el libro");
        }
    }
}
