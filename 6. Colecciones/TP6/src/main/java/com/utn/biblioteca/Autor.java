package com.utn.biblioteca;

public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    // Constructor
    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Getters (necesarios para acceder a los datos)
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }

    // Método para mostrar la información del autor
    public void mostrarInfo() {
        System.out.printf("   [Autor] ID: %s | Nombre: %s | Nacionalidad: %s\n",
            id, nombre, nacionalidad);
    }
}