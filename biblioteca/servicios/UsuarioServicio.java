package com.app.biblioteca.servicios;

import com.app.biblioteca.entidades.Libro;
import com.app.biblioteca.entidades.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioServicio {

    private ArrayList<Usuario> listadoUsuarios;
    private Scanner read;

    public UsuarioServicio(ArrayList<Usuario> arrayUsuarios) {
        this.listadoUsuarios = arrayUsuarios;
        this.read = new Scanner(System.in).useDelimiter("\n");
    }

    public void crearUsuario() {
        Usuario usuarioNuevo = new Usuario();
        System.out.println("Creemos un usuario");
        System.out.println("Ingresá el nombre");
        usuarioNuevo.setNombre(read.next());
        System.out.println("Ingresa el ID");
        usuarioNuevo.setId(read.next());

        listadoUsuarios.add(usuarioNuevo);
        System.out.println("Usuario creado con éxito");
    }

    public ArrayList<Usuario> listarUsuarios() {

        if (!listadoUsuarios.isEmpty()) {
            System.out.println("Usuarios registrados");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%5s %20s", "ID", "NOMBRE");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            for (Usuario usuario : listadoUsuarios) {
                System.out.printf("%5s %20s", usuario.getId(), usuario.getNombre());
                System.out.println();

            }
            System.out.println("-----------------------------------------------------------------------------");
            return listadoUsuarios;
        } else {
            System.out.println("No hay usuarios registrados");
            return null;
        }


    }

    public Usuario buscarUsuarioPorId() {

        System.out.println("Ingresa el ID del usuario a buscar");
        String idBuscado = read.next();

        if (!listadoUsuarios.isEmpty()) {
            for (Usuario usuario : listadoUsuarios) {
                if (usuario.getId().equals(idBuscado)) {
                    System.out.println("Usuario localizado: " + usuario.getNombre());
                    return usuario;
                }

            }
        }
        System.out.println("No se localizo el usuario");
        return null;
    }

    public void borrarUsuario() {
        System.out.println("Eliminemos un usuario: ");
        Usuario usuarioBorrado = buscarUsuarioPorId();

        if (usuarioBorrado != null) {
            listadoUsuarios.removeIf(usuario -> usuario.getId().equals(usuarioBorrado.getId()));
            System.out.println("El usuario se ha eliminado");
        } else {
            System.out.println("No se pudo localizar el usuario");
        }

    }

    public void actualizarUsuario() {
        System.out.println("Busquemos el usuario a actualizar:");
        Usuario usuarioActualizado = buscarUsuarioPorId();

        if (usuarioActualizado != null) {
            System.out.println("Actualicemos el nombre:");
            usuarioActualizado.setNombre(read.next());

            System.out.println("Usuario actualizado con éxito");
        } else {
            System.out.println("No se pudo localizar el usuario");
        }

    }

}
