package kata3_empleados;

// EmpleadoPlanta (o permanente)
public class EmpleadoPlanta extends Empleado {
    private double sueldoBase;

    public EmpleadoPlanta(String nombre, double sueldoBase) {
        super(nombre);
        this.sueldoBase = sueldoBase;
    }

    @Override
    public double calcularSueldo() {
        // Lógica simple de ejemplo
        return sueldoBase * 1.15; // Sueldo base + 15% de bonos
    }
}