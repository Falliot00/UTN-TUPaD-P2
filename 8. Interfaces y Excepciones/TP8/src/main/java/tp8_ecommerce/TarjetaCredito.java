package tp8_ecommerce;

// 4. Clase que implementa PagoConDescuento
public class TarjetaCredito implements PagoConDescuento {
    private double DESCUENTO_TASA = 0.05; // 5% de descuento

    @Override
    public double aplicarDescuento(double monto) {
        return monto * (1 - DESCUENTO_TASA);
    }

    @Override
    public boolean procesarPago(double monto) {
        double montoFinal = aplicarDescuento(monto);
        System.out.println("Procesando pago con Tarjeta de Crédito.");
        System.out.printf("Monto original: $%.2f%n", monto);
        System.out.printf("Monto con descuento: $%.2f%n", montoFinal);
        System.out.println("Pago Aprobado.");
        return true;
    }
}