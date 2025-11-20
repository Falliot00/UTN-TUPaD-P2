package tp8_ecommerce;

import java.util.ArrayList;
import java.util.List;

// 3. Clase Pedido
public class Pedido implements Pagable {
    private List<Producto> productos;
    private Cliente cliente; // 5. Para notificar
    private String estado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.estado = "Pendiente";
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
        System.out.println("Producto añadido: " + p.getNombre());
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal(); // Polimorfismo (aunque aquí solo hay Productos)
        }
        return total;
    }

    // 5. Método para notificar al cliente
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        // Notificamos al cliente
        this.cliente.notificar("El estado de su pedido ha cambiado a: " + this.estado);
    }
    
    // Método para finalizar la compra
    public void finalizarCompra(Pago metodoPago) {
        double total = calcularTotal();
        actualizarEstado("En proceso de pago");
        
        boolean pagado = metodoPago.procesarPago(total);
        
        if (pagado) {
            actualizarEstado("Pagado y Completado");
        } else {
            actualizarEstado("Error en el pago");
        }
    }
}