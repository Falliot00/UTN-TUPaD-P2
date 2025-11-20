package tp8_ecommerce;

public class MainEcommerce {

    public static void main(String[] args) {
        // 5. Crear cliente
        Cliente cliente1 = new Cliente("Juan Perez", "juan.perez@email.com");

        // 3. Crear pedido
        Pedido pedido1 = new Pedido(cliente1);

        // 2. Crear productos y añadirlos
        pedido1.agregarProducto(new Producto("Laptop", 1200.50));
        pedido1.agregarProducto(new Producto("Mouse", 45.99));

        System.out.println("-----------------------------------");

        // 1. Calcular total (usando la interfaz Pagable)
        double totalPedido = pedido1.calcularTotal();
        System.out.printf("El total del pedido es: $%.2f%n", totalPedido);
        System.out.println("-----------------------------------");

        // 4. Seleccionar método de pago (con descuento)
        Pago metodoPagoConDesc = new TarjetaCredito();
        
        // Finalizar la compra. 
        // El pedido notificará al cliente en cada cambio de estado.
        pedido1.finalizarCompra(metodoPagoConDesc);
        
        // --- Prueba con otro método de pago (sin descuento) ---
        // Cliente cliente2 = new Cliente("Ana Gomez", "ana.gomez@email.com");
        // Pedido pedido2 = new Pedido(cliente2);
        // pedido2.agregarProducto(new Producto("Teclado", 80.00));
        // Pago metodoPagoSimple = new PayPal();
        // pedido2.finalizarCompra(metodoPagoSimple);
    }
}
