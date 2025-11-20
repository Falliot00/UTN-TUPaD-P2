package tp8_excepcion2_conversion;

import java.util.Scanner;

public class MainConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un texto (que intente ser un número): ");
        String texto = scanner.nextLine();
        
        try {
            // 2. Intentar convertir a int 
            int numero = Integer.parseInt(texto);
            System.out.println("¡Conversión exitosa! El número es: " + numero);
            
        } catch (NumberFormatException e) {
            // 2. Manejar NumberFormatException 
            System.out.println("Error: El texto '" + texto + "' no es un número entero válido.");
            
        } finally {
            scanner.close();
        }
    }
}