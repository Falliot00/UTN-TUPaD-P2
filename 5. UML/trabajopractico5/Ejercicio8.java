/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio8 {

}

// 8) Documento — FirmaDigital — Usuario
class UsuarioFD {

    private String nombre, email;

    public UsuarioFD(String n, String e) {
        this.nombre = n;
        this.email = e;
    }
}

class FirmaDigital {

    private String codigoHash, fecha;
    private UsuarioFD usuario; // agregación hacia Usuario

    public FirmaDigital(String codigoHash, String fecha, UsuarioFD u) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = u;
    }
}

class Documento {

    private String titulo, contenido;
    private FirmaDigital firma; // composición

    public Documento(String titulo, String contenido, String hash, String fecha, UsuarioFD u) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firma = new FirmaDigital(hash, fecha, u);
    }
}

class Main8 {

    public static void main(String[] args) {
        UsuarioFD u = new UsuarioFD("Lucía", "lucia@gmail.com");
        Documento d = new Documento("Contrato", "Informacion", "abc123", "2025-09-24", u);
        System.out.println("OK 8");
    }
}
