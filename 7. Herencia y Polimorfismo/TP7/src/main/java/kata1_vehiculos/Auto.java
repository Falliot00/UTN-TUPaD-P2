package kata1_vehiculos;

// Subclase que hereda de Vehiculo 
public class Auto extends Vehiculo {
    private int cantidadPuertas;

    // Constructor de la subclase
    public Auto(String marca, String modelo, int cantidadPuertas) {
        // Llama al constructor de la superclase (Vehiculo) 
        // Debe ser la primera línea [cite: 213]
        super(marca, modelo); 
        this.cantidadPuertas = cantidadPuertas;
    }

    // Sobrescritura del método 
    // Usamos @Override para asegurar que estamos sobrescribiendo 
    @Override
    public void mostrarInfo() {
        System.out.println("Auto:");
        System.out.println("Marca: " + this.marca); // Heredado de Vehiculo
        System.out.println("Modelo: " + this.modelo); // Heredado de Vehiculo
        System.out.println("Puertas: " + this.cantidadPuertas); // Propio de Auto
    }
}
