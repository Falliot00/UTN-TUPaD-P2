package com.utn.universidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos; // Referencia al lado "Muchos"

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>(); // Inicialización
    }


    public String getId() { return id; }
    public String getNombre() { return nombre; } 
    public List<Curso> getCursos() { return cursos; }
    
    // --- Métodos de Bidireccionalidad y Sincronización ---
    
    // Agrega el curso a su lista y sincroniza el lado del curso.
    public void agregarCurso(Curso c, boolean sincronizar) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            if (sincronizar) {
                // Sincronizar el lado de Curso. Usamos el método interno para evitar recursión.
                c.setProfesorInterno(this); 
            }
        }
    }

    // Quita el curso y sincroniza el lado del curso.
    public void eliminarCurso(Curso c, boolean sincronizar) {
        if (cursos.remove(c)) {
            if (sincronizar) {
                // Sincronizar el lado de Curso. Deja profesor en null si corresponde.
                c.setProfesorInterno(null);
            }
        }
    }

    // --- Métodos de Reporte ---

    public void listarCursos() {
        System.out.printf("--- Cursos dictados por %s (%s) ---\n", nombre, especialidad);
        if (cursos.isEmpty()) {
            System.out.println("No dicta cursos actualmente.");
            return;
        }
        for (Curso c : cursos) {
            System.out.printf("  - %s: %s\n", c.getCodigo(), c.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.printf("Profesor ID: %s | Nombre: %s | Especialidad: %s | Cursos: %d\n",
            id, nombre, especialidad, cursos.size());
    }
}