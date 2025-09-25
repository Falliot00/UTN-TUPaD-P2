/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio14 {

}

// 14) EditorVideo — Proyecto — Render (creación)
class Proyecto {

    private String nombre;
    private int duracionMin;

    public Proyecto(String n, int d) {
        this.nombre = n;
        this.duracionMin = d;
    }
}

class Render {

    private String formato;
    private Proyecto proyecto;

    public Render(String f, Proyecto p) {
        this.formato = f;
        this.proyecto = p;
    }
}

class EditorVideo {

    public void exportar(String formato, Proyecto proyecto) {
        Render r = new Render(formato, proyecto); // dependencia de creación
        System.out.println("Exportando en formato: " + formato);
    }
}

class Main14 {

    public static void main(String[] args) {
        Proyecto p = new Proyecto("Spot", 2);
        new EditorVideo().exportar("MP4", p);
    }
}
