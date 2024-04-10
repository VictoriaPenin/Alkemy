package com.app.biblioteca.servicios;

import com.app.biblioteca.entidades.Libro;
import com.app.biblioteca.entidades.Prestamo;
import com.app.biblioteca.entidades.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class PrestamoServicio {
    private Scanner read;
    private ArrayList<Prestamo> listadoPrestamo;
    private ArrayList<Libro> listadoLibros;
    private ArrayList<Usuario> listadoUsuarios;


    public PrestamoServicio(ArrayList<Prestamo> prestamos, ArrayList<Libro> libros, ArrayList<Usuario> usuarios) {
        this.read = new Scanner(System.in).useDelimiter("\n");
        this.listadoPrestamo = prestamos;
        this.listadoUsuarios = usuarios;
        this.listadoLibros = libros;
    }

    public void crearPrestamo() {
        Prestamo prestamo = new Prestamo();
        boolean encontradoUsuario = false;
        boolean encontradoLibro = false;
        Usuario usuarioPrestamo = new Usuario();
        System.out.println("Cual usuario va a realizar el prestamo? Ingresa ID");
        String idUsuario = read.next();
        for (Usuario usuario : listadoUsuarios) {
            if (usuario.getId().equals(idUsuario)) {
                System.out.println("Usuario localizado!");
                prestamo.setUsuario(usuario);
                encontradoUsuario = true;
                usuarioPrestamo = usuario;
                ArrayList<Libro> librosUsuarioPrestamo = new ArrayList<>();
                usuarioPrestamo.setLibrosPrestados(librosUsuarioPrestamo);

            }
        }
        if (!encontradoUsuario) {
            System.out.println("El libro no se localizo o no se encuentra disponible.");
        }

        System.out.println("Cual es el libro que le vamos a prestar? Ingresa ISBN");
        String isbnLibro = read.next();
        for (Libro libro : listadoLibros) {
            if (libro.getIsbn().equals(isbnLibro) && libro.isDisponible() == true) {
                System.out.println("Libro localizado");
                prestamo.setLibro(libro);
                encontradoLibro = true;
                usuarioPrestamo.getLibrosPrestados().add(libro);
                libro.setDisponible(false);
            }
        }
        if (!encontradoLibro) {
            System.out.println("El libro no se localizo o no se encuentra disponible.");
        }
    }

    public void devolucionPrestamo() {
        System.out.println("Cual usuario va a realizar la devolución? Ingresa ID");
        String idUsuario = read.next();
        boolean encontradoUsuario = false;
        for (Usuario usuario : listadoUsuarios) {
            if (usuario.getId().equals(idUsuario)) {
                System.out.println("Libros devueltos!");
                encontradoUsuario = true;
                ArrayList<Libro> librosUsuario = usuario.getLibrosPrestados();
                for (Libro libro : librosUsuario) {
                    libro.setDisponible(true);
                }


                ArrayList<Libro> librosUsuarioPrestamo = new ArrayList<>();
                usuario.setLibrosPrestados(librosUsuarioPrestamo);

            }
        }

        if (!encontradoUsuario) {
            System.out.println("El libro no se localizo o no se encuentra disponible.");
        }
    }
}