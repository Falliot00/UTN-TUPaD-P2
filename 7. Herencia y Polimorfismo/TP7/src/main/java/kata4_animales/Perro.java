package kata4_animales;

public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    // Sobrescritura con @Override 
    @Override
    public void hacerSonido() {
        System.out.println(this.nombre + " dice: ¡Guau! ¡Guau!");
    }
}