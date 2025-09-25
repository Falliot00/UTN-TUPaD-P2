/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio6 {

}

// 6) Reserva — Cliente — Mesa
class ClienteR {

    private String nombre, telefono;

    public ClienteR(String n, String t) {
        this.nombre = n;
        this.telefono = t;
    }
}

class Mesa {

    private int numero, capacidad;

    public Mesa(int n, int c) {
        this.numero = n;
        this.capacidad = c;
    }
}

class Reserva {

    private String fecha, hora;
    private ClienteR cliente;
    private Mesa mesa;

    public Reserva(String fecha, String hora, ClienteR cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }
}

class Main6 {

    public static void main(String[] args) {
        ClienteR cli = new ClienteR("Sofía", "342555222");
        Mesa m = new Mesa(7, 4);
        Reserva r = new Reserva("2025-09-24", "21:00", cli, m);
        System.out.println("OK 6");
    }
}
