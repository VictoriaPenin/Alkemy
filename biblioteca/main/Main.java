package com.app.biblioteca.main;

import com.app.biblioteca.entidades.Libro;
import com.app.biblioteca.entidades.Prestamo;
import com.app.biblioteca.entidades.Usuario;
import com.app.biblioteca.servicios.LibroServicio;
import com.app.biblioteca.servicios.PrestamoServicio;
import com.app.biblioteca.servicios.UsuarioServicio;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> arrayLibros = new ArrayList<>();
        ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
        ArrayList<Prestamo> arrayPrestamos = new ArrayList<>();

        Scanner read = new Scanner(System.in).useDelimiter("\n");
        LibroServicio libroServicio = new LibroServicio(arrayLibros);
        UsuarioServicio usuarioServicio = new UsuarioServicio(arrayUsuarios);
        PrestamoServicio prestamoServicio = new PrestamoServicio(arrayPrestamos, arrayLibros, arrayUsuarios);


        System.out.println("Bienvenido a nuestra biblioteca");
        int opcion;
        do {
            System.out.println();
            System.out.println("Elija una opcion del menu");
            System.out.println("1. Crear libro");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Listar libros prestados");
            System.out.println("6. Buscar libro por ISBN");
            System.out.println("7. Buscar libros por genero");
            System.out.println("8. Buscar libro por autor");
            System.out.println("9. Actualizar libro");
            System.out.println("10. Eliminar libro");
            System.out.println("11. Crear usuario");
            System.out.println("12. Eliminar usuario");
            System.out.println("13. Modificar usuario");
            System.out.println("14. Listar usuarios");
            System.out.println("15. Salir");
            System.out.println();
            opcion = read.nextInt();

            switch (opcion) {
                case 1:
                    libroServicio.crearLibro();
                    break;
                case 2:
                    libroServicio.listarLibros();
                    break;
                case 3:
                    prestamoServicio.crearPrestamo();
                    break;
                case 4:
                    prestamoServicio.devolucionPrestamo();
                    break;
                case 5:
                    libroServicio.listarLibrosPrestados();
                    break;
                case 6:
                    libroServicio.buscarLibroPorIsbn();
                    break;
                case 7:
                    libroServicio.buscarLibroPorGenero();
                    break;
                case 8:
                    libroServicio.buscarLibroPorAutor();
                    break;
                case 9:
                    libroServicio.actualizarLibro();
                    break;
                case 10:
                    libroServicio.eliminarLibro();
                    break;
                case 11:
                    usuarioServicio.crearUsuario();
                    break;
                case 12:
                    usuarioServicio.borrarUsuario();
                    break;
                case 13:
                    usuarioServicio.actualizarUsuario();
                    break;
                case 14:
                    usuarioServicio.listarUsuarios();
                    break;
            }

        } while (opcion != 15);

        System.out.println("Gracias por utilizar nuestra biblioteca");

    }


}