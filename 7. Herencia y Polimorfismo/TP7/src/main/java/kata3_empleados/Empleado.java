package kata3_empleados;

public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método abstracto para calcular sueldo 
    public abstract double calcularSueldo();
}