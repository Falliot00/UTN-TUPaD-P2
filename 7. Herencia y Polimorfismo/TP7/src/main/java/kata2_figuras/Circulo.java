package kata2_figuras;

public class Circulo extends Figura {
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    // Implementación obligatoria del método abstracto 
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}