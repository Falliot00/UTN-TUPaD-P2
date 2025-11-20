package kata1_vehiculos;

// Clase base (Superclase)
public class Vehiculo {
    protected String marca;
    protected String modelo;

    // Constructor de la superclase 
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método que luego será sobrescrito
    public void mostrarInfo() {
        System.out.println("Vehículo:");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
    }
}