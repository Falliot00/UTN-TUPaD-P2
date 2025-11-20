package com.utn.universidad;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores; // [cite: 799]
    private List<Curso> cursos;       // [cite: 800]

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Métodos Auxiliares de Búsqueda
    public Profesor buscarProfesorPorId(String id) { // [cite: 806]
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }
    public Curso buscarCursoPorCodigo(String codigo) { // [cite: 807]
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) return c;
        }
        return null;
    }

    // Métodos de Gestión
    public void agregarProfesor(Profesor p) { profesores.add(p); } // [cite: 802]
    public void agregarCurso(Curso c) { cursos.add(c); }           // [cite: 803]

    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) { // [cite: 804]
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso != null && profesor != null) {
            // Usa el setProfesor del curso, que maneja la sincronización bidireccional
            curso.setProfesor(profesor);
            return true;
        }
        return false;
    }

    public boolean eliminarCurso(String codigo) { // [cite: 808]
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Romper la relación con el profesor si la hubiera
            if (curso.getProfesor() != null) {
                // Usamos el setProfesor(null) para sincronizar ambos lados.
                curso.setProfesor(null); 
            }
            return cursos.remove(curso);
        }
        return false;
    }

    public boolean eliminarProfesor(String id) { // [cite: 809]
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Antes de remover, dejar profesor=null en todos los cursos que dictaba [cite: 809]
            // Creamos una copia para evitar ConcurrentModificationException
            new ArrayList<>(profesor.getCursos()).forEach(c -> c.setProfesor(null));
            return profesores.remove(profesor);
        }
        return false;
    }

    // Métodos de Reporte [cite: 805]
    public void listarProfesores() {
        System.out.println("--- LISTA DE PROFESORES ---");
        profesores.forEach(Profesor::mostrarInfo);
    }
    public void listarCursos() {
        System.out.println("--- LISTA DE CURSOS ---");
        cursos.forEach(Curso::mostrarInfo);
    }
}