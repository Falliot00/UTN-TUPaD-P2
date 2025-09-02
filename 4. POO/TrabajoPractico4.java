/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajopractico4;

/**
 *
 * @author FerminA
 */

public class TrabajoPractico4 {
    public static void main(String[] args) {
        // Instancias con ambos constructores
        Empleado e1 = new Empleado(100, "Ana Gomez", "Desarrolladora", 1350000.0);
        Empleado e2 = new Empleado("Carlos Diaz", "QA Analyst"); // id y salario por defecto
        Empleado e3 = new Empleado("Lucia Perez", "Tech Lead");

        // Aplicación de métodos sobrecargados
        e1.actualizarSalario(10.0);   // +10%
        e2.actualizarSalario(30000);  // +$30.000 (monto fijo)

        // Impresión de información (usando toString())
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        // Total de empleados creados (método estático)
        System.out.println("Total de empleados: " + Empleado.mostrarTotalEmpleados());
    }
}

