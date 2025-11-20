package kata4_animales;

import java.util.ArrayList;
import java.util.List;

public class MainAnimales {

    public static void main(String[] args) {
        // Tarea: Crear lista de animales 
        List<Animal> granja = new ArrayList<>();
        
        // Usamos Upcasting 
        granja.add(new Perro("Fido"));
        granja.add(new Gato("Mishu"));
        granja.add(new Vaca("Lola"));
        granja.add(new Perro("Rex"));

        // Tarea: Mostrar sus sonidos con polimorfismo 
        System.out.println("--- Sonidos de la Granja (Polimorfismo) ---");
        
        for (Animal animal : granja) {
            // Polimorfismo: se llama al 'hacerSonido()' específico
            // de Perro, Gato o Vaca
            animal.hacerSonido(); 
        }
    }
}