package com.tienda.inventario;

public class Producto {
    // Atributos privados (Encapsulamiento) [cite: 27-32]
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    // Constructor para inicializar todos los atributos
    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    // --- Getters ---
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }
    
    // --- Setter para actualizar stock (cantidad) [cite: 75] ---
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    // Método para mostrar la información [cite: 34]
    public void mostrarInfo() {
        System.out.printf("ID: %s | Nombre: %s | Precio: $%.2f | Stock: %d | Categoría: %s (%s)\n",
            id, nombre, precio, cantidad, categoria.name(), categoria.getDescripcion());
    }
}