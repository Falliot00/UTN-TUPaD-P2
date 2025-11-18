package edu.utn.p2.tfi.main;

import edu.utn.p2.tfi.entities.CodigoBarras;
import edu.utn.p2.tfi.entities.Producto;
import edu.utn.p2.tfi.service.CodigoBarrasService;
import edu.utn.p2.tfi.service.ProductoService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppMenu {

    private final Scanner sc = new Scanner(System.in);
    private final ProductoService productoService = new ProductoService();
    private final CodigoBarrasService codigoBarrasService = new CodigoBarrasService();

    public static void main(String[] args) {
        new AppMenu().run();
    }

    private void run() {
        int op;
        do {
            System.out.println("\n=== TFI Programación 2 -- Producto --> CodigoBarras (1-->1) ===");
            System.out.println("1) Alta CodigoBarras");
            System.out.println("2) Alta Producto + CodigoBarras NUEVO (transacción)");
            System.out.println("3) Alta Producto usando CodigoBarras EXISTENTE (transacción)");
            System.out.println("4) Listar Productos");
            System.out.println("5) Buscar Producto por valor de CodigoBarras");
            System.out.println("6) Eliminar lógico Producto");
            System.out.println("7) Listar Codigos de Barras");
            System.out.println("8) Eliminar lógico CodigoBarras");
            System.out.println("9) Demostración de rollback (UNIQUE valor)");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = leerInt();

            try {
                switch (op) {
                    case 1 -> altaCodigoBarras();
                    case 2 -> altaProductoConCbNuevo();
                    case 3 -> altaProductoConCbExistente();
                    case 4 -> listarProductos();
                    case 5 -> buscarProductoPorValor();
                    case 6 -> eliminarLogicoProducto();
                    case 7 -> listarCodigos();
                    case 8 -> eliminarLogicoCodigo();
                    case 9 -> demoRollback();
                    case 0 -> System.out.println("Fin.");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        } while (op != 0);
    }

    private void altaCodigoBarras() throws SQLException {
        System.out.print("Valor (EAN/UPC): ");
        String valor = sc.nextLine().trim();
        System.out.print("Tipo [EAN13|UPC|EAN8] (default EAN13): ");
        String tipo = sc.nextLine().trim();
        if (tipo.isBlank()) tipo = "EAN13";

        CodigoBarras cb = new CodigoBarras(null, valor, tipo, false);
        Long id = codigoBarrasService.crear(cb);
        System.out.println("Creado CodigoBarras id=" + id);
    }

    private void altaProductoConCbNuevo() throws SQLException {
        CodigoBarras cb = new CodigoBarras();
        System.out.print("CB valor (EAN/UPC): ");
        cb.setValor(sc.nextLine().trim());
        System.out.print("CB tipo [EAN13|UPC|EAN8] (default EAN13): ");
        String tipo = sc.nextLine().trim();
        cb.setTipo(tipo.isBlank() ? "EAN13" : tipo);
        cb.setEliminado(false);

        Producto p = leerProductoInteractivo();
        Long id = productoService.crearProductoConCodigoBarras(p, cb);
        System.out.println("Creado Producto id=" + id + " con CodigoBarras id=" + p.getCodigoBarras().getId());
    }

    private void altaProductoConCbExistente() throws SQLException {
        System.out.print("Valor de CodigoBarras existente: ");
        String valor = sc.nextLine().trim();
        Producto p = leerProductoInteractivo();
        Long id = productoService.crearProductoConCodigoBarrasExistente(p, valor);
        System.out.println("Creado Producto id=" + id);
    }

    private void listarProductos() throws SQLException {
        List<Producto> lista = productoService.leerTodos();
        lista.forEach(System.out::println);
    }

    private void buscarProductoPorValor() throws SQLException {
        System.out.print("Valor de CodigoBarras: ");
        String valor = sc.nextLine().trim();
        List<Producto> lista = productoService.buscarPorCodigoBarrasValor(valor);
        if (lista.isEmpty()) System.out.println("Sin resultados");
        else lista.forEach(System.out::println);
    }

    private void eliminarLogicoProducto() throws SQLException {
        System.out.print("ID de Producto: ");
        long id = leerLong();
        boolean ok = productoService.eliminarLogico(id);
        System.out.println(ok ? "Eliminado lógico OK" : "No se encontró");
    }

    private void listarCodigos() throws SQLException {
        for (CodigoBarras c : codigoBarrasService.leerTodos()) System.out.println(c);
    }

    private void eliminarLogicoCodigo() throws SQLException {
        System.out.print("ID de CodigoBarras: ");
        long id = leerLong();
        boolean ok = codigoBarrasService.eliminarLogico(id);
        System.out.println(ok ? "Eliminado lógico OK" : "No se encontró");
    }

    private void demoRollback() {
        try {
            String valor = "7791234567899"; // Debe existir por seed
            System.out.println("Forzando violación UNIQUE con valor CB=" + valor);
            Producto p = new Producto(null, "PROD_DUP", "TEST", 10.0, "unidad", false, null);
            CodigoBarras cb = new CodigoBarras(null, valor, "EAN13", false);
            productoService.crearProductoConCodigoBarras(p, cb);
            System.out.println("No se produjo la violación UNIQUE (verifique que el valor exista).");
        } catch (Exception e) {
            System.out.println("Rollback OK — Excepción esperada: " + e.getMessage());
        }
    }

    private Producto leerProductoInteractivo() {
        Producto p = new Producto();
        System.out.print("Nombre: ");
        p.setNombre(sc.nextLine().trim());
        System.out.print("Marca: ");
        p.setMarca(sc.nextLine().trim());
        System.out.print("Precio: ");
        p.setPrecio(leerDouble());
        System.out.print("Unidad de medida [unidad|kg|lt|pz]: ");
        String um = sc.nextLine().trim();
        p.setUnidadMedida(um.isBlank() ? "unidad" : um);
        p.setEliminado(false);
        return p;
    }

    private int leerInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { return -1; }
    }
    private long leerLong() {
        try { return Long.parseLong(sc.nextLine().trim()); } catch (Exception e) { return -1; }
    }
    private double leerDouble() {
        try { return Double.parseDouble(sc.nextLine().trim()); } catch (Exception e) { return 0.0; }
    }
}
