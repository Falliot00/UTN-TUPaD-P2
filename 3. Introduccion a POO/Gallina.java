/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico3;

/**
 *
 * @author FerminA
 */

public class Gallina {
    private final int idGallina;
    private int edad;          // en meses
    private int huevosPuestos; // acumulado

    public Gallina(int idGallina, int edadInicial) {
        this.idGallina = idGallina;
        this.edad = Math.max(0, edadInicial);
        this.huevosPuestos = 0;
    }

    public void ponerHuevo() {
        this.huevosPuestos += 1;
    }

    public void envejecer() {
        this.edad += 1;
    }

    public void mostrarEstado() {
        System.out.printf("Gallina #%d | Edad: %d meses | Huevos: %d\n",
                idGallina, edad, huevosPuestos);
    }
}

