/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico3;

/**
 *
 * @author FerminA
 */

public class Estudiante {
    private final String nombre;
    private final String apellido;
    private final String curso;
    private double calificacion; // 0.0 a 10.0

    public Estudiante(String nombre, String apellido, String curso, double calificacionInicial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = ajustarARango(calificacionInicial);
    }

    private double ajustarARango(double valor) {
        if (valor < 0) return 0;
        if (valor > 10) return 10;
        return valor;
    }

    public void subirCalificacion(double puntos) {
        if (puntos < 0) return; // no sube con valores negativos
        this.calificacion = ajustarARango(this.calificacion + puntos);
    }

    public void bajarCalificacion(double puntos) {
        if (puntos < 0) return; // no baja con valores negativos
        this.calificacion = ajustarARango(this.calificacion - puntos);
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificacion: " + calificacion);
        System.out.println("---------------------------");
    }
}
