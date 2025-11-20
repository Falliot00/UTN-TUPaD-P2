package kata4_animales;

public class Vaca extends Animal {
    public Vaca(String nombre) {
        super(nombre);
    }

    // Sobrescritura con @Override 
    @Override
    public void hacerSonido() {
        System.out.println(this.nombre + " dice: ¡Muuuu!");
    }
}