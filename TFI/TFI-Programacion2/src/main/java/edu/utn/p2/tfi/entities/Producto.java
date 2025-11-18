package edu.utn.p2.tfi.entities;

public class Producto {
    private Long id;
    private String nombre;
    private String marca;
    private double precio;
    private String unidadMedida;
    private boolean eliminado;
    private CodigoBarras codigoBarras; // A -> B (1..1 unidireccional)

    public Producto() {}

    public Producto(Long id, String nombre, String marca, double precio, String unidadMedida, boolean eliminado, CodigoBarras codigoBarras) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
        this.eliminado = eliminado;
        this.codigoBarras = codigoBarras;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }

    public CodigoBarras getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(CodigoBarras codigoBarras) { this.codigoBarras = codigoBarras; }

    @Override
    public String toString() {
        String cb = (codigoBarras == null ? "null" : "{" + codigoBarras.getId() + "," + codigoBarras.getValor() + "}");
        return "Producto{id=" + id + ", nombre='" + nombre + "', marca='" + marca + "', precio=" + precio +
               ", unidadMedida='" + unidadMedida + "', eliminado=" + eliminado + ", codigoBarras=" + cb + "}";
    }
}
