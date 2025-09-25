/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio10 {

}

// 10) CuentaBancaria — ClaveSeguridad — Titular
class ClaveSeguridad {

    private String codigo, ultimaModificacion;

    public ClaveSeguridad(String c, String f) {
        this.codigo = c;
        this.ultimaModificacion = f;
    }
}

class TitularCB {

    private String nombre, dni;
    private CuentaBancaria cuenta;

    public TitularCB(String n, String d) {
        this.nombre = n;
        this.dni = d;
    }

    public void setCuenta(CuentaBancaria c) {
        this.cuenta = c;
        if (c != null && c.getTitular() != this) {
            c.setTitular(this);
        }
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }
}

class CuentaBancaria {

    private String cbu;
    private double saldo;
    private ClaveSeguridad clave;
    private TitularCB titular;

    public CuentaBancaria(String cbu, double saldo, String codigo, String fecha) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = new ClaveSeguridad(codigo, fecha); // composición
    }

    public void setTitular(TitularCB t) {
        this.titular = t;
        if (t != null && t.getCuenta() != this) {
            t.setCuenta(this);
        }
    }

    public TitularCB getTitular() {
        return titular;
    }
}

class Main10 {

    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria("000-123", 1500.0, "X1Y2Z3", "2025-08-01");
        TitularCB t = new TitularCB("Nora", "22333999");
        cb.setTitular(t);
        System.out.println("OK 10");
    }
}
