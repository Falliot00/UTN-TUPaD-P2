/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico2;

/**
 *
 * @author FerminA
 */

public class Ej13ArrayRecursivo {
    public static void main(String[] args) {
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};

        System.out.println("Precios originales:");
        imprimirRecursivo(precios, 0);

        // Modificar el tercer precio (índice 2)
        precios[2] = 129.99;

        System.out.println("\nPrecios modificados:");
        imprimirRecursivo(precios, 0);
    }

    private static void imprimirRecursivo(double[] arr, int i) {
        if (i == arr.length) {
            return; // caso base
        }
        System.out.println("Precio: $" + arr[i]);
        imprimirRecursivo(arr, i + 1); // paso recursivo
    }
}
