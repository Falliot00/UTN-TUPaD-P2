/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio3 {

}

// 3) Libro — Autor — Editorial
class Autor {

    private String nombre, nacionalidad;

    public Autor(String n, String nac) {
        this.nombre = n;
        this.nacionalidad = nac;
    }
}

class Editorial {

    private String nombre, direccion;

    public Editorial(String n, String d) {
        this.nombre = n;
        this.direccion = d;
    }
}

class Libro {

    private String titulo, isbn;
    private Autor autor;
    private Editorial editorial; // asoc+agreg

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }
}

class Main3 {

    public static void main(String[] args) {
        Autor a = new Autor("Borges", "Argentina");
        Editorial e = new Editorial("Salamanca", "CABA");
        Libro l = new Libro("Ficciones", "978-1-23", a, e);
        System.out.println("OK 3");
    }
}
