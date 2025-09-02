/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico4;

/**
 *
 * @author FerminA
 */

public class Empleado {
    // Atributos de instancia
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    // Atributos estáticos (de clase)
    private static int totalEmpleados = 0;           // contador global
    private static int nextId = 1;                   // generador de IDs automáticos
    private static final double SALARIO_POR_DEFECTO = 1000000.0;

    // Constructor completo
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    // Constructor simplificado: asigna id automático y salario por defecto
    public Empleado(String nombre, String puesto) {
        this(nextId++, nombre, puesto, SALARIO_POR_DEFECTO);
    }

    // --- Métodos sobrecargados para actualizar salario ---
    // 1) Interpreta el parámetro como PORCENTAJE
    public void actualizarSalario(double porcentaje) {
        if (porcentaje < -100) {
            throw new IllegalArgumentException("El porcentaje no puede ser menor a -100.");
        }
        this.salario += this.salario * (porcentaje / 100.0);
    }

    // 2) Interpreta el parámetro como MONTO FIJO (sobrecarga por tipo int)
    public void actualizarSalario(int montoFijo) {
        double nuevo = this.salario + montoFijo;
        if (nuevo < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo.");
        }
        this.salario = nuevo;
    }

    // Representación legible del objeto
    @Override
    public String toString() {
        return "Empleado{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", puesto='" + puesto + '\'' +
               ", salario=" + String.format("%.2f", salario) +
               '}';
    }

    // Método estático para consultar el total creado
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    // --- Getters y Setters  ---
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }

    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setSalario(double salario) {
        if (salario < 0) throw new IllegalArgumentException("El salario no puede ser negativo.");
        this.salario = salario;
    }
}
