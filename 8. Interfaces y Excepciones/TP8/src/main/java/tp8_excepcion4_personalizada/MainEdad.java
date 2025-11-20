package tp8_excepcion4_personalizada;

import java.util.Scanner;

public class MainEdad {

    // Método que valida y 'lanza' (throws) la excepción
    public static void validarEdad(int edad) throws EdadInvalidaException {
        // 4. Lanzarla si la edad es menor a 0 o mayor a 120
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad " + edad + " es inválida. Debe estar entre 0 y 120.");
        }
        System.out.println("Edad ingresada (" + edad + ") es válida.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();
            
            // Llamamos al método que puede lanzar la excepción
            validarEdad(edad);
            
        } catch (EdadInvalidaException e) {
            // 4. Capturarla y mostrar mensaje 
            System.out.println("Error de validación: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("Error: debe ingresar un número.");
            
        } finally {
            scanner.close();
        }
    }
}