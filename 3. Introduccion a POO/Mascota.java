/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico3;

/**
 *
 * @author FerminA
 */

public class Mascota {
    private final String nombre;
    private final String especie;
    private int edad; // en años

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = Math.max(0, edad);
    }

    public void cumplirAnios() {
        this.edad += 1;
    }

    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre + " (" + especie + ")");
        System.out.println("Edad: " + edad + " anios");
        System.out.println("---------------------------");
    }
}

