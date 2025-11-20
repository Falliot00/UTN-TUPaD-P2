package kata2_figuras;

// Clase abstracta
public abstract class Figura {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto: sin implementación 
    // Las subclases están OBLIGADAS a implementarlo.
    public abstract double calcularArea();

    // Método concreto (con implementación) 
    public String getNombre() {
        return this.nombre;
    }
}