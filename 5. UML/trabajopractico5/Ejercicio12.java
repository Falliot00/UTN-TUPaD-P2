/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio12 {

}

// 12) Impuesto — Contribuyente — Calculadora (uso)
class Contribuyente {

    private String nombre, cuil;

    public Contribuyente(String n, String c) {
        this.nombre = n;
        this.cuil = c;
    }
}

class Impuesto {

    private double monto;
    private Contribuyente contribuyente;

    public Impuesto(double m, Contribuyente c) {
        this.monto = m;
        this.contribuyente = c;
    }

    public double getMonto() {
        return monto;
    }
}

class Calculadora {

    public void calcular(Impuesto imp) { // uso temporal
        double total = imp.getMonto() * 1.21; // ej. aplica IVA a modo didáctico
        System.out.println("Total calculado: " + total);
    }
}

class Main12 {

    public static void main(String[] args) {
        Contribuyente ct = new Contribuyente("Fermín", "20-42561122-5");
        Impuesto imp = new Impuesto(1000.0, ct);
        new Calculadora().calcular(imp);
    }
}
