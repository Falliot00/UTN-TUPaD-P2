package edu.utn.p2.tfi.entities;

public class CodigoBarras {
    private Long id;
    private String valor; // EAN/UPC
    private String tipo;  // 'EAN13','UPC','EAN8' (validado en DB)
    private boolean eliminado;

    public CodigoBarras() {}

    public CodigoBarras(Long id, String valor, String tipo, boolean eliminado) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.eliminado = eliminado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }

    @Override
    public String toString() {
        return "CodigoBarras{id=" + id + ", valor='" + valor + "', tipo='" + tipo + "', eliminado=" + eliminado + "}";
    }
}
