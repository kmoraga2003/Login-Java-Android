package com.example.myapplication;

import java.util.ArrayList;

public class Datos {

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Tarea> listaTareas = new ArrayList<>();
    public static Usuario usuarioLogueado = null;

    static {
        // Usuario demo para probar inmediatamente
        Usuario usuarioDemo = new Usuario(
                "Juan Pérez",
                "12345678-9",
                "+56 9 1234 5678",
                "admin@santotomas.cl",
                "Admin123!",
                "Estándar"
        );
        listaUsuarios.add(usuarioDemo);

        // Tareas demo
        listaTareas.add(new Tarea("Estudiar Android Java", "Estudio", true, 5, false));
        listaTareas.add(new Tarea("Preparar Informe", "Trabajo", false, 3, true));
        listaTareas.add(new Tarea("Comprar materiales", "Personal", false, 2, true));
    }
}
