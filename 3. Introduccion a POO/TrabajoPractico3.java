/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajopractico3;

/**
 *
 * @author FerminA
 */
public class TrabajoPractico3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // Ejercicio 1
        Estudiante e1 = new Estudiante("Ana", "Perez", "Programacion II", 7.5);
        e1.mostrarInfo();

        e1.subirCalificacion(1.2);   // 7.5 -> 8.7
        e1.bajarCalificacion(3.5);   // 8.7 -> 5.2

        // Intentos fuera de rango
        e1.subirCalificacion(10);    // tope en 10

        e1.mostrarInfo();

        // Ejercicio 2
        Mascota m1 = new Mascota("Luna", "Perro", 2);
        m1.mostrarInfo();
        m1.cumplirAnios();
        m1.cumplirAnios();
        m1.mostrarInfo();

        // Ejercicio 3
        Libro l1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        System.out.println(l1.info());

        l1.setAnioPublicacion(1200); // inválido, se rechaza
        l1.setAnioPublicacion(2005); // válido
        System.out.println(l1.info());
        
        // Ejercicio 4
        Gallina g1 = new Gallina(1, 10);
        Gallina g2 = new Gallina(2, 8);

        
        g1.envejecer();
        g1.ponerHuevo();
        g1.ponerHuevo();

        g2.envejecer();
        g2.ponerHuevo();

        g1.mostrarEstado();
        g2.mostrarEstado();


        // Ejercicio 5
        NaveEspacial nave = new NaveEspacial("Aurora", 50, 100);
        nave.mostrarEstado();

        nave.despegar();
        nave.avanzar(60);      // falla por falta de combustible
        nave.recargarCombustible(20); // 50 -> 70
        nave.avanzar(60);      // ahora sí
        nave.mostrarEstado();

    }
    
}
