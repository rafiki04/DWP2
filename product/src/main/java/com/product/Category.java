package com.product;

import java.util.Scanner;
import java.util.ArrayList;

public class Category {
    int id;
    String nombre;
    String tag;
    int status;

    // Lista de categorías
    static ArrayList<Category> categorias = new ArrayList<>();

    // Metodo constructor
    public Category(int id, String nombre, String tag, int status) {
        this.id = id;
        this.nombre = nombre;
        this.tag = tag;
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return nombre;
    }

    public String gettag() {
        return tag;
    }

    public int getStatus() {
        return status;
    }

    // Método para mostrar las categorías activas
    public static void mostrarCategorias() {
        boolean categoriasExistentes = false;
        
        // Recorrer la lista de categorías
        for (int i = 0; i < categorias.size(); i++) {
            Category cat = categorias.get(i);
            if (cat.status == 1) {
                System.out.println("{" + cat.id + ", \"" + cat.nombre + "\", \"" + cat.tag + "\", " + cat.status + "}");
                categoriasExistentes = true;
            }
        }

       
        if (!categoriasExistentes) {
            System.out.println("No existen categorías registradas.");
        }
    }

    // Método para crear una categoría nueva
    public static void crearCategoria(int id, String nombre, String tag, int status) {
        // Verificar si el id, nombre o tag ya existe
        for (int i = 0; i < categorias.size(); i++) {
            Category cat = categorias.get(i);
            if (cat.id == id || cat.nombre.equals(nombre) || cat.tag.equals(tag)) {
                System.out.println("Error: Ya existe una categoría con ese id, nombre o tag.");
                return;
            }
        }

       
        Category nuevaCategoria = new Category(id, nombre, tag, status);
        categorias.add(nuevaCategoria);
        System.out.println("Categoría creada: {" + id + ", \"" + nombre + "\", \"" + tag + "\", " + status + "}");
    }

    // Método para eliminar una categoría
    public static void eliminarCategoria(int id) {
        for (int i = 0; i < categorias.size(); i++) {
            Category cat = categorias.get(i);
            if (cat.id == id) {
                cat.status = 0;
                System.out.println("Categoría con id " + id + " cambiada a estatus 0.");
                return;
            }
        }
        System.out.println("Error: No se encontró una categoría con el id " + id);
    }

}
