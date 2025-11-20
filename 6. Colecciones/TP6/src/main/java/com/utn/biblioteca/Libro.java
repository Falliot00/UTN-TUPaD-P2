package com.utn.biblioteca;

public class Libro {
    private String isbn; // Identificador único [cite: 116]
    private String titulo; // Título del libro [cite: 117]
    private int anioPublicacion; // Año de publicación [cite: 118]
    private Autor autor; // Referencia al objeto Autor [cite: 119]

    // Constructor
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public Autor getAutor() { return autor; }

    // Método para mostrar la información del libro y su autor
    public void mostrarInfo() {
        System.out.printf("ISBN: %s | Título: %s | Año: %d\n", 
            isbn, titulo, anioPublicacion);
        // Llama al método del Autor para mostrar su información completa
        autor.mostrarInfo();
    }
}