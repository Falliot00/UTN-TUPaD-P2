package kata4_animales;

// Clase base 
public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Método que será sobrescrito
    public void hacerSonido() {
        System.out.println("El animal hace un sonido genérico.");
    }

    // Método que no será sobrescrito
    public void describirAnimal() {
        System.out.println("Soy un animal llamado " + nombre);
    }
}