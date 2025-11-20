package com.utn.universidad;

public class MainUniversidad {
    public static void main(String[] args) {
        Universidad utn = new Universidad("Universidad Tecnológica Nacional");

        // 1. Crear 3 profesores y 5 cursos
        Profesor p1 = new Profesor("P101", "Dr. Juan Pérez", "Algoritmos y Estructuras");
        Profesor p2 = new Profesor("P102", "Ing. Ana García", "Desarrollo Web");
        Profesor p3 = new Profesor("P103", "Lic. Luis Torres", "Base de Datos");

        Curso c1 = new Curso("C201", "Programación II");
        Curso c2 = new Curso("C202", "Estructuras de Datos");
        Curso c3 = new Curso("C301", "Bases de Datos I");
        Curso c4 = new Curso("C401", "Introducción a Spring");
        Curso c5 = new Curso("C501", "Algoritmos Avanzados");

        // 2. Agregar a la universidad
        utn.agregarProfesor(p1); utn.agregarProfesor(p2); utn.agregarProfesor(p3);
        utn.agregarCurso(c1); utn.agregarCurso(c2); utn.agregarCurso(c3); utn.agregarCurso(c4); utn.agregarCurso(c5);
        System.out.println(">> Profesores y cursos agregados a la Universidad.\n");

        // 3. Asignar profesores a cursos
        utn.asignarProfesorACurso("C201", "P101"); // Programación II -> Pérez
        utn.asignarProfesorACurso("C202", "P101"); // Estructuras -> Pérez
        utn.asignarProfesorACurso("C301", "P103"); // Bases de Datos -> Torres
        System.out.println(">> 3. Asignaciones iniciales realizadas.\n");

        // 4. Listar cursos con su profesor y profesores con sus cursos
        System.out.println(">> 4. Listado de Cursos y Profesores:");
        utn.listarCursos();
        System.out.println("---");
        p1.listarCursos();
        p3.listarCursos();
        System.out.println();
        
        // 5. Cambiar el profesor de un curso (C201: Pérez -> García)
        System.out.println(">> 5. Cambiando profesor de C201 (Pérez -> García):");
        utn.asignarProfesorACurso("C201", "P102"); 
        
        System.out.println("\n--- VERIFICACIÓN DE SINCRONIZACIÓN ---");
        System.out.print("Pérez (P101) ahora dicta: "); p1.listarCursos(); // C201 debe haber desaparecido
        System.out.print("García (P102) ahora dicta: "); p2.listarCursos(); // C201 debe haber aparecido
        System.out.print("Curso C201 ahora tiene: "); utn.buscarCursoPorCodigo("C201").mostrarInfo();
        System.out.println();
        
        // 6. Remover un curso (C301)
        System.out.println(">> 6. Removiendo curso C301 (Dictado por Torres):");
        utn.eliminarCurso("C301");
        System.out.println("--- VERIFICACIÓN DESPUÉS DE ELIMINAR CURSO ---");
        System.out.print("Cursos restantes: "); utn.listarCursos();
        System.out.print("Torres (P103) ahora dicta: "); p3.listarCursos(); // C301 debe haber desaparecido
        System.out.println();
        
        // 7. Remover un profesor (P102 - García)
        System.out.println(">> 7. Removiendo profesor P102 (García) y dejando sus cursos en null:");
        utn.eliminarProfesor("P102");
        System.out.println("--- VERIFICACIÓN DESPUÉS DE ELIMINAR PROFESOR ---");
        utn.listarProfesores(); // García no debe aparecer
        System.out.print("Curso C201 ahora tiene: "); utn.buscarCursoPorCodigo("C201").mostrarInfo(); // Debe estar 'Sin asignar'
        System.out.println();
        
        // 8. Mostrar un reporte: cantidad de cursos por profesor
        System.out.println(">> 8. Reporte: Cantidad de cursos por profesor:");
        utn.listarProfesores();
    }
}