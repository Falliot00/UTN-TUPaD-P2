package tp8_ecommerce;

// 4. Clase que implementa Pago
public class PayPal implements Pago {

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal.");
        System.out.printf("Monto final: $%.2f%n", monto);
        System.out.println("Pago Aprobado.");
        return true;
    }
}