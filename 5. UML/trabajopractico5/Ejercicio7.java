/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio7 {

}

// 7) Vehículo — Motor — Conductor
class MotorV {

    private String tipo, numeroSerie;

    public MotorV(String t, String ns) {
        this.tipo = t;
        this.numeroSerie = ns;
    }
}

class Conductor {

    private String nombre, licencia;
    private Vehiculo vehiculo;

    public Conductor(String n, String l) {
        this.nombre = n;
        this.licencia = l;
    }

    public void setVehiculo(Vehiculo v) {
        this.vehiculo = v;
        if (v != null && v.getConductor() != this) {
            v.setConductor(this);
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}

class Vehiculo {

    private String patente, modelo;
    private MotorV motor;
    private Conductor conductor;

    public Vehiculo(String patente, String modelo, MotorV motor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor;
    }

    public void setConductor(Conductor c) {
        this.conductor = c;
        if (c != null && c.getVehiculo() != this) {
            c.setVehiculo(this);
        }
    }

    public Conductor getConductor() {
        return conductor;
    }
}

class Main7 {

    public static void main(String[] args) {
        MotorV m = new MotorV("Nafta", "M-001");
        Vehiculo v = new Vehiculo("AB123CD", "Fiesta", m);
        Conductor c = new Conductor("Pedro", "B1");
        v.setConductor(c);
        System.out.println("OK 7");
    }
}
