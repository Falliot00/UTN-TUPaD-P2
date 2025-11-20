package tp8_excepcion3y5_archivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainLecturaConRecursos {

    public static void main(String[] args) {
        // El archivo 'saludo.txt' debe estar en la raíz del proyecto
        String nombreArchivo = "saludo.txt";
        
        // 5. Uso de try-with-resources 
        // BufferedReader se cerrará automáticamente al salir del try
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            
            System.out.println("Leyendo archivo '" + nombreArchivo + "':");
            String linea;
            
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            
        } catch (FileNotFoundException e) {
            // 3. Manejar FileNotFoundException 
            System.out.println("Error: El archivo no fue encontrado: " + nombreArchivo);
            
        } catch (IOException e) {
            // 5. Manejar IOException
            System.out.println("Error de E/S (Entrada/Salida) al leer el archivo.");
            e.printStackTrace();
        }
        
        System.out.println("\nLectura finalizada.");
    }
}