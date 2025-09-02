/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico2;

import java.util.Scanner;

/**
 *
 * @author FerminA
 */

public class Ej4DescuentoPorCategoria {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese la categoria del producto (A, B o C): ");
        char cat = sc.next().trim().toUpperCase().charAt(0);

        double descuentoPct;
        switch (cat) {
            case 'A' -> descuentoPct = 0.10;
            case 'B' -> descuentoPct = 0.15;
            case 'C' -> descuentoPct = 0.20;
            default -> {
                System.out.println("Categoria invalida. Use A/B/C.");
                return;
            }
        }

        double descuento = precio * descuentoPct;
        double precioFinal = precio - descuento;
        System.out.println("Descuento aplicado: " + (descuentoPct * 100) + "%");
        System.out.println("Precio final: " + precioFinal);
    }
}
