/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio11 {

}

// 11) Reproductor — Canción — Artista (uso)
class Artista {

    private String nombre, genero;

    public Artista(String n, String g) {
        this.nombre = n;
        this.genero = g;
    }
}

class Cancion {

    private String titulo;
    private Artista artista;

    public Cancion(String t, Artista a) {
        this.titulo = t;
        this.artista = a;
    }

    public String getTitulo() {
        return titulo;
    }
}

class Reproductor {

    public void reproducir(Cancion c) { // dependencia de uso: solo por parámetro
        System.out.println("Reproduciendo: " + c.getTitulo());
    }
}

class Main11 {

    public static void main(String[] args) {
        Artista a = new Artista("Charly", "Rock");
        Cancion c = new Cancion("Demoliendo Hoteles", a);
        new Reproductor().reproducir(c);
    }
}
