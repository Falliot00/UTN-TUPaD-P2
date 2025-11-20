package tp8_ecommerce;

// 4. Interfaz que hereda de otra
public interface PagoConDescuento extends Pago {
    double aplicarDescuento(double monto);
}