package kata3_empleados;

import java.util.ArrayList;
import java.util.List;

public class MainEmpleados {

    public static void main(String[] args) {
        // Tarea: Crear lista de empleados 
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoPlanta("Ana", 3000));
        empleados.add(new EmpleadoTemporal("Juan", 20, 80));
        empleados.add(new EmpleadoPlanta("Luis", 3200));

        System.out.println("--- Calculando Sueldos (Polimorfismo) ---");
        
        for (Empleado emp : empleados) {
            // Tarea: Invocar calcularSueldo() polimórficamente 
            System.out.println("Empleado: " + emp.getNombre());
            System.out.println("Sueldo: " + emp.calcularSueldo());

            // Tarea: Usar instanceof para clasificar 
            // Verificamos el tipo real del objeto 
            if (emp instanceof EmpleadoPlanta) {
                System.out.println("Tipo: Empleado de Planta");
            } else if (emp instanceof EmpleadoTemporal) {
                System.out.println("Tipo: Empleado Temporal");
            }
            System.out.println("--------------------");
        }
    }
}