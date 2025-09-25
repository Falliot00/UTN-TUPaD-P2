/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio9 {

}

// 9) CitaMédica — Paciente — Profesional
class Paciente {

    private String nombre, obraSocial;

    public Paciente(String n, String o) {
        this.nombre = n;
        this.obraSocial = o;
    }
}

class Profesional {

    private String nombre, especialidad;

    public Profesional(String n, String e) {
        this.nombre = n;
        this.especialidad = e;
    }
}

class CitaMedica {

    private String fecha, hora;
    private Paciente paciente;
    private Profesional profesional;

    public CitaMedica(String fecha, String hora, Paciente p, Profesional pr) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = p;
        this.profesional = pr;
    }
}

class Main9 {

    public static void main(String[] args) {
        Paciente p = new Paciente("Juan", "OSDE");
        Profesional pr = new Profesional("Dra. Pérez", "Clínica");
        CitaMedica c = new CitaMedica("2025-09-30", "10:00", p, pr);
        System.out.println("OK 9");
    }
}
