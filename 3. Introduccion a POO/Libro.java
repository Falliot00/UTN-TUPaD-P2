/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico3;

import java.time.Year;

/**
 *
 * @author FerminA
 */

public class Libro {
    private final String titulo;
    private final String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAnioPublicacion(anioPublicacion); // aplica validación inicial
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }

    public void setAnioPublicacion(int anio) {
        int anioActual = Year.now().getValue();
        if (anio >= 1400 && anio <= anioActual) {
            this.anioPublicacion = anio;
        } else {
            System.out.println("Anio invalido: " + anio + ". Se mantiene: " + this.anioPublicacion);
        }
    }

    public String info() {
        return String.format("\"%s\" de %s (%d)", titulo, autor, anioPublicacion);
    }
}
