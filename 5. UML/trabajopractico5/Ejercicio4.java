/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio4 {

}

// 4) TarjetaDeCredito — Cliente — Banco
class Banco {

    private String nombre;
    private String cuit;

    public Banco(String n, String c) {
        this.nombre = n;
        this.cuit = c;
    }
}

class Cliente {

    private String nombre, dni;
    private TarjetaDeCredito tarjeta;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setTarjeta(TarjetaDeCredito t) {
        this.tarjeta = t;
        if (t != null && t.getCliente() != this) {
            t.setCliente(this);
        }
    }

    public TarjetaDeCredito getTarjeta() {
        return tarjeta;
    }
}

class TarjetaDeCredito {

    private String numero, fechaVencimiento;
    private Cliente cliente;
    private Banco banco;

    public TarjetaDeCredito(String numero, String fechaVencimiento, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.banco = banco; // agregación
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
        if (c != null && c.getTarjeta() != this) {
            c.setTarjeta(this);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }
}

class Main4 {

    public static void main(String[] args) {
        Banco b = new Banco("Banco Nación", "30-00000000-0");
        TarjetaDeCredito t = new TarjetaDeCredito("4509550069871234", "12/28", b);
        Cliente c = new Cliente("Luis", "33444555");
        t.setCliente(c);
        System.out.println("OK 4");
    }
}
