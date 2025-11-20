package tp8_ecommerce;

// 5. Clase Cliente
public class Cliente implements Notificable {
    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void notificar(String mensaje) {
        // Simulación de notificación
        System.out.println("Notificación para " + nombre + " (" + email + "):");
        System.out.println(mensaje);
        System.out.println("-----------------------------------");
    }
}