/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio5 {

}

// 5) Computadora — PlacaMadre — Propietario
class PlacaMadre {

    private String modelo, chipset;

    public PlacaMadre(String m, String c) {
        this.modelo = m;
        this.chipset = c;
    }
}

class Propietario {

    private String nombre, dni;
    private Computadora pc;

    public Propietario(String n, String d) {
        this.nombre = n;
        this.dni = d;
    }

    public void setPc(Computadora pc) {
        this.pc = pc;
        if (pc != null && pc.getPropietario() != this) {
            pc.setPropietario(this);
        }
    }

    public Computadora getPropietarioPc() {
        return pc;
    }
}

class Computadora {

    private String marca, numeroSerie;
    private PlacaMadre placa;
    private Propietario propietario;

    public Computadora(String marca, String numeroSerie, String modeloPlaca, String chipset) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.placa = new PlacaMadre(modeloPlaca, chipset); // composición
    }

    public void setPropietario(Propietario p) {
        this.propietario = p;
        if (p != null && p.getPropietarioPc() != this) {
            p.setPc(this);
        }
    }

    public Propietario getPropietario() {
        return propietario;
    }
}

class Main5 {

    public static void main(String[] args) {
        Computadora pc = new Computadora("Dell", "SN-001", "B760", "Intel");
        Propietario pr = new Propietario("Marta", "27444555");
        pc.setPropietario(pr);
        System.out.println("OK 5");
    }
}
