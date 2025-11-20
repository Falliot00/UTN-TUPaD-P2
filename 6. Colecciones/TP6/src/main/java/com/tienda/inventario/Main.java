package com.tienda.inventario;



public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // 1. Crear 5 productos y agregarlos al inventario [cite: 677]
        System.out.println(">> 1. Creando y agregando productos...");
        inventario.agregarProducto(new Producto("P001", "Laptop Pro", 2500.00, 15, CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(new Producto("P002", "Camiseta Algodón", 1250.00, 50, CategoriaProducto.ROPA));
        inventario.agregarProducto(new Producto("P003", "Mesa de Centro", 3500.00, 5, CategoriaProducto.HOGAR));
        inventario.agregarProducto(new Producto("P004", "Manzanas", 500.00, 100, CategoriaProducto.ALIMENTOS));
        inventario.agregarProducto(new Producto("P005", "Smartphone X", 4000.00, 10, CategoriaProducto.ELECTRONICA));
        System.out.println("Productos agregados.\n");

        // 2. Listar todos los productos [cite: 678]
        System.out.println(">> 2. Listado completo de productos:");
        inventario.listarProductos();
        System.out.println();

        // 3. Buscar un producto por ID y mostrar su info [cite: 679]
        String idBuscado = "P002";
        System.out.printf(">> 3. Buscando producto con ID: %s\n", idBuscado);
        Producto pBuscado = inventario.buscarProductoPorId(idBuscado);
        if (pBuscado != null) {
            pBuscado.mostrarInfo();
        } else {
            System.out.printf("Producto con ID %s no encontrado.\n", idBuscado);
        }
        System.out.println();

        // 4. Filtrar por categoría específica (ELECTRONICA) [cite: 680]
        System.out.println(">> 4. Filtrando productos por categoría ELECTRONICA:");
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        System.out.println();

        // 5. Eliminar un producto por su ID (P003) y listar restantes [cite: 681]
        String idEliminar = "P003";
        System.out.printf(">> 5. Eliminando producto con ID: %s\n", idEliminar);
        if (inventario.eliminarProducto(idEliminar)) {
            System.out.printf("Producto %s eliminado.\n", idEliminar);
        } else {
            System.out.printf("Error al eliminar producto %s.\n", idEliminar);
        }
        inventario.listarProductos();
        System.out.println();

        // 6. Actualizar el stock de un producto existente (P001) [cite: 682]
        String idStock = "P001";
        int nuevoStock = 25;
        System.out.printf(">> 6. Actualizando stock de producto %s a %d\n", idStock, nuevoStock);
        if (inventario.actualizarStock(idStock, nuevoStock)) {
            inventario.buscarProductoPorId(idStock).mostrarInfo();
        } else {
            System.out.printf("Error: Producto %s no encontrado para actualizar stock.\n", idStock);
        }
        System.out.println();

        // 7. Mostrar el total de stock disponible [cite: 683]
        System.out.println(">> 7. Stock total disponible en el inventario:");
        System.out.printf("Stock Total: %d unidades.\n", inventario.obtenerTotalStock());
        System.out.println();

        // 8. Obtener y mostrar el producto con mayor stock [cite: 684]
        System.out.println(">> 8. Producto con mayor stock:");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            mayorStock.mostrarInfo();
        } else {
            System.out.println("El inventario está vacío.");
        }
        System.out.println();

        // 9. Filtrar productos con precios entre $1000 y $3000 [cite: 685]
        System.out.println(">> 9. Filtrando productos por precio ($1000 - $3000):");
        inventario.filtrarProductosPorPrecio(1000.00, 3000.00);
        System.out.println();

        // 10. Mostrar las categorías disponibles con sus descripciones [cite: 686]
        System.out.println(">> 10. Categorías disponibles:");
        inventario.mostrarCategoriasDisponibles();
    }
}

