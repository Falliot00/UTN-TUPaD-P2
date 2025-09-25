/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajopractico5;

/**
 *
 * @author FerminA
 */
public class Ejercicio13 {

}

// 13) GeneradorQR — Usuario — CódigoQR (creación)
class UsuarioQR {

    private String nombre, email;

    public UsuarioQR(String n, String e) {
        this.nombre = n;
        this.email = e;
    }
}

class CodigoQR {

    private String valor;
    private UsuarioQR usuario;

    public CodigoQR(String v, UsuarioQR u) {
        this.valor = v;
        this.usuario = u;
    }
}

class GeneradorQR {

    public void generar(String valor, UsuarioQR usuario) { // crea y usa sin guardar
        CodigoQR qr = new CodigoQR(valor, usuario); // dependencia de creación
        System.out.println("QR generado para: " + valor);
    }
}

class Main13 {

    public static void main(String[] args) {
        UsuarioQR u = new UsuarioQR("Lola", "lola@gmail.com");
        new GeneradorQR().generar("PAGO#001", u);
    }
}
