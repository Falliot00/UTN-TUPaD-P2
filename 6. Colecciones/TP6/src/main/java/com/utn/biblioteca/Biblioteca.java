package com.utn.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros; // Colección de libros (relación 1:N)

    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>(); // Inicialización de la colección
    }
    
    // Getter añadido para solucionar el error "cannot find symbol: method getNombre()"
    public String getNombre() {
        return nombre;
    }
    
    // --- Métodos Requeridos ---

    // 1. agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor)
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        // Crea una instancia de Libro y la añade a la colección
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro);
    }

    // 2. listarLibros()
    public void listarLibros() {
        System.out.printf("--- LISTA DE LIBROS EN %s ---\n", nombre);
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) { // Uso de ciclo for-each
            l.mostrarInfo();
        }
    }

    // Método auxiliar para buscar un libro por ISBN
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null; // Si no se encuentra
    }

    // 3. eliminarLibro(String isbn)
    public boolean eliminarLibro(String isbn) {
        Libro libroAEliminar = buscarLibroPorIsbn(isbn);
        if (libroAEliminar != null) {
            return libros.remove(libroAEliminar);
        }
        return false;
    }

    // 4. obtenerCantidadLibros()
    public int obtenerCantidadLibros() {
        return libros.size();
    }

    // 5. filtrarLibrosPorAnio(int anio)
    public void filtrarLibrosPorAnio(int anio) {
        System.out.printf("--- LIBROS PUBLICADOS EN %d ---\n", anio);
        boolean encontrado = false;
        for (Libro l : libros) {
            if (l.getAnioPublicacion() == anio) {
                l.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros publicados en ese año.");
        }
    }

    // 6. mostrarAutoresDisponibles()
    public void mostrarAutoresDisponibles() {
        System.out.println("--- AUTORES DISPONIBLES EN LA BIBLIOTECA ---");
        // Usamos una lista temporal para guardar los IDs de autores y evitar duplicados
        List<String> autoresIds = new ArrayList<>(); 

        for (Libro l : libros) {
            // Si el ID del autor no está en la lista de IDs ya mostrados
            if (!autoresIds.contains(l.getAutor().getId())) {
                l.getAutor().mostrarInfo();
                // Añadimos el ID para no mostrarlo de nuevo
                autoresIds.add(l.getAutor().getId());
            }
        }
        if(autoresIds.isEmpty()){
             System.out.println("No hay autores registrados.");
        }
    }
}