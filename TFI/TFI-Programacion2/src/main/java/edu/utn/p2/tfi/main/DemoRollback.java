package edu.utn.p2.tfi.main;

import edu.utn.p2.tfi.entities.CodigoBarras;
import edu.utn.p2.tfi.entities.Producto;
import edu.utn.p2.tfi.service.ProductoService;

public class DemoRollback {
    public static void main(String[] args) {
        ProductoService svc = new ProductoService();
        try {
            CodigoBarras cb = new CodigoBarras(null, "7791234567890", "EAN13", false);
            Producto p = new Producto(null, "DEMO ROLLBACK", "TEST", 100.0, "unidad", false, null);
            System.out.println(">> Intentando crear Producto + CB NUEVO con valor repetido...");
            svc.crearProductoConCodigoBarras(p, cb);
            System.out.println(">> ERROR: no se produjo violación UNIQUE (verifique datos).");
        } catch (Exception e) {
            System.out.println("OK — Rollback demostrado. Excepción esperada: " + e.getMessage());
        }
    }
}
