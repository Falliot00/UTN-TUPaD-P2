package kata4_animales;

public class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    // Sobrescritura con @Override 
    @Override
    public void hacerSonido() {
        System.out.println(this.nombre + " dice: ¡Miau!");
    }
}