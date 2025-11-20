package kata2_figuras;

public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    // Implementación obligatoria del método abstracto 
    @Override
    public double calcularArea() {
        return base * altura;
    }
}