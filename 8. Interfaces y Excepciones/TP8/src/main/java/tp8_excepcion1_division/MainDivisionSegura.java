package tp8_excepcion1_division;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDivisionSegura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese el dividendo (numerador): ");
            int dividendo = scanner.nextInt();
            
            System.out.print("Ingrese el divisor: ");
            int divisor = scanner.nextInt();
            
            // 1. Manejar ArithmeticException 
            if (divisor == 0) {
                // Lanzamos la excepción manualmente para que el catch la maneje
                throw new ArithmeticException("División por cero no permitida.");
            }
            
            double resultado = (double) dividendo / divisor;
            System.out.println("El resultado es: " + resultado);
            
        } catch (ArithmeticException e) {
            // Captura la división por cero
            System.out.println("Error: " + e.getMessage());
            
        } catch (InputMismatchException e) {
            // Captura si el usuario no ingresa un número
            System.out.println("Error: Debe ingresar números enteros.");
            
        } finally {
            // Bloque 'finally' se ejecuta siempre
            System.out.println("Cerrando scanner. Programa terminado.");
            scanner.close();
        }
    }
}