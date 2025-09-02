/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico2;

/**
 *
 * @author FerminA
 */

public class Ej12ArrayPrecios {
    
    public static void main(String[] args) {
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};

        System.out.println("Precios originales:");
        for (double p : precios) {
            System.out.println("Precio: $" + p);
        }

        // Modifico el tercer precio (índice 2) a 129.99
        precios[2] = 129.99;

        System.out.println("\nPrecios modificados:");
        for (double p : precios) {
            System.out.println("Precio: $" + p);
        }
    }
}

