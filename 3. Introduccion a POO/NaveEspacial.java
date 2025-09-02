/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico3;

/**
 *
 * @author FerminA
 */

public class NaveEspacial {
    private final String nombre;
    private double combustible;      // unidades actuales
    private final double capacidadMaxima; // tope

    public NaveEspacial(String nombre, double combustibleInicial, double capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = Math.max(0, capacidadMaxima);
        this.combustible = Math.min(Math.max(0, combustibleInicial), this.capacidadMaxima);
    }

    public void despegar() {
        if (combustible > 0) {
            System.out.println(nombre + " ha despegado.");
        } else {
            System.out.println("No hay combustible para despegar.");
        }
    }

    public void avanzar(double distancia) {
        if (distancia <= 0) {
            System.out.println("La distancia debe ser positiva.");
            return;
        }
        if (combustible >= distancia) {
            combustible -= distancia;
            System.out.println(nombre + " avanzo " + distancia + " unidades.");
        } else {
            System.out.println("Combustible insuficiente para avanzar " + distancia + " unidades.");
        }
    }

    public void recargarCombustible(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positiva.");
            return;
        }
        if (combustible + cantidad <= capacidadMaxima) {
            combustible += cantidad;
            System.out.println("Recarga exitosa. Combustible actual: " + combustible);
        } else {
            System.out.println("No se puede superar la capacidad maxima (" + capacidadMaxima + ").");
        }
    }

    public void mostrarEstado() {
        System.out.printf("Nave: %s | Combustible: %.2f / %.2f\n", nombre, combustible, capacidadMaxima);
    }
}

