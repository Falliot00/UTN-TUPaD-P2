package com.tienda.inventario;

public enum CategoriaProducto {
    // Valores y su descripción
    ALIMENTOS("Productos comestibles"), // [cite: 50]
    ELECTRONICA("Dispositivos electrónicos"), // [cite: 51]
    ROPA("Prendas de vestir"), // [cite: 52]
    HOGAR("Artículos para el hogar"); // [cite: 53]

    private final String descripcion; // [cite: 54]

    // Constructor privado [cite: 55-57]
    CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter [cite: 59-61]
    public String getDescripcion() {
        return descripcion;
    }
}