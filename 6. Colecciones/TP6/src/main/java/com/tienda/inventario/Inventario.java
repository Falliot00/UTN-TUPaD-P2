package com.tienda.inventario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario {
    // Relación 1:N - El Inventario (1) tiene una lista de Productos (N)
    private List<Producto> productos; // Atributo: ArrayList<Producto> productos [cite: 666]

    // Constructor: Inicialización del ArrayList (crucial para evitar NullPointerException) [cite: 352]
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // --- Métodos Requeridos (Tareas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10) ---

    // 1. agregarProducto(Producto p) [cite: 667]
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // 2. listarProductos() [cite: 668]
    public void listarProductos() {
        System.out.println("--- LISTA DE PRODUCTOS ---");
        // Uso de for-each para recorrer la colección (más legible y simple) [cite: 409, 415, 605]
        for (Producto p : productos) {
            p.mostrarInfo();
        }
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        }
    }

    // 3. buscarProductoPorId(String id) [cite: 669]
    public Producto buscarProductoPorId(String id) {
        // Búsqueda lineal: examina cada elemento secuencialmente [cite: 489]
        for (Producto p : productos) { // Uso de for-each [cite: 605]
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null; // Retorna null si no lo encuentra
    }
    
    // 5. eliminarProducto(String id) [cite: 670]
    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            return productos.remove(p);
        }
        return false;
    }

    // 6. actualizarStock(String id, int nuevaCantidad) [cite: 671]
    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    // 4. filtrarPorCategoria(CategoriaProducto categoria) [cite: 672]
    public void filtrarPorCategoria(CategoriaProducto categoria) {
        System.out.printf("--- PRODUCTOS EN CATEGORÍA: %s (%s) ---\n", categoria.name(), categoria.getDescripcion());
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos en esta categoría.");
        }
    }

    // 7. obtenerTotalStock() [cite: 673]
    public int obtenerTotalStock() {
        int totalStock = 0;
        for (Producto p : productos) {
            totalStock += p.getCantidad();
        }
        return totalStock;
    }

    // 8. obtenerProductoConMayorStock() [cite: 674]
    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }

        Producto mayorStock = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = p;
            }
        }
        return mayorStock;
    }

    // 9. filtrarProductosPorPrecio(double min, double max) [cite: 675, 685]
    public void filtrarProductosPorPrecio(double min, double max) {
        System.out.printf("--- PRODUCTOS CON PRECIO ENTRE $%.2f y $%.2f ---\n", min, max);
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos en el rango de precio especificado.");
        }
    }

    // 10. mostrarCategoriasDisponibles() [cite: 675, 686]
    public void mostrarCategoriasDisponibles() {
        System.out.println("--- CATEGORÍAS DISPONIBLES ---");
        // Itera sobre todos los valores del enum CategoriaProducto
        for (CategoriaProducto cat : CategoriaProducto.values()) { 
            System.out.printf("- %s: %s\n", cat.name(), cat.getDescripcion());
        }
    }

} 