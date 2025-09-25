/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio2 {

}

// 2) Celular — Batería — Usuario
class Bateria {

    private String modelo;
    private int capacidadMah;

    public Bateria(String modelo, int capacidadMah) {
        this.modelo = modelo;
        this.capacidadMah = capacidadMah;
    }
}

class Usuario {

    private String nombre;
    private String dni;
    private Celular celular;

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCelular(Celular c) {
        this.celular = c;
        if (c != null && c.getUsuario() != this) {
            c.setUsuario(this);
        }
    }

    public Celular getCelular() {
        return celular;
    }
}

class Celular {

    private String imei, marca, modelo;
    private Bateria bateria;
    private Usuario usuario;

    public Celular(String imei, String marca, String modelo, Bateria bateria) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria; // agregación
    }

    public void setUsuario(Usuario u) {
        this.usuario = u;
        if (u != null && u.getCelular() != this) {
            u.setCelular(this);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

class Main2 {

    public static void main(String[] args) {
        Bateria b = new Bateria("BT-500", 5000);
        Celular c = new Celular("IMEI001", "Xiaomi", "Redmi", b);
        Usuario u = new Usuario("Ana", "123456798");
        c.setUsuario(u);
        System.out.println("OK 2");
    }
}
