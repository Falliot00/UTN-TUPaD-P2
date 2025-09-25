/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio1 {

}

// 1) Pasaporte — Foto — Titular
// a) Composición: Pasaporte crea y posee Foto
class Foto {
    private String imagen;
    private String formato;
    public Foto(String imagen, String formato) {
        this.imagen = imagen; this.formato = formato;
    }
    public String getImagen() { return imagen; }
    public String getFormato() { return formato; }
}

class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Foto foto; // composición
    private Titular titular; // asociación bidireccional

    public Pasaporte(String numero, String fechaEmision, String img, String formato) {
        this.numero = numero; this.fechaEmision = fechaEmision;
        this.foto = new Foto(img, formato); // composición: creación interna
    }
    public void setTitular(Titular t) {
        this.titular = t;
        if (t != null && t.getPasaporte() != this) t.setPasaporte(this);
    }
    public Titular getTitular() { return titular; }
}

class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte; // asociación bidireccional

    public Titular(String nombre, String dni) { this.nombre = nombre; this.dni = dni; }
    public void setPasaporte(Pasaporte p) {
        this.pasaporte = p;
        if (p != null && p.getTitular() != this) p.setTitular(this);
    }
    public Pasaporte getPasaporte() { return pasaporte; }
}


class Main1 {

    public static void main(String[] args) {
        Pasaporte p = new Pasaporte("AR42561122", "2025-01-01", "img", "jpg");
        Titular t = new Titular("Fermín Alliot", "42561122");
        p.setTitular(t);
        System.out.println("OK 1");
    }
}
