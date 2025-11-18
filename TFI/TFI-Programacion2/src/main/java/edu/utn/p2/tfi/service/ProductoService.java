package edu.utn.p2.tfi.service;

import edu.utn.p2.tfi.config.DatabaseConnection;
import edu.utn.p2.tfi.dao.CodigoBarrasDao;
import edu.utn.p2.tfi.dao.ProductoDao;
import edu.utn.p2.tfi.dao.impl.CodigoBarrasDaoImpl;
import edu.utn.p2.tfi.dao.impl.ProductoDaoImpl;
import edu.utn.p2.tfi.entities.CodigoBarras;
import edu.utn.p2.tfi.entities.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductoService {

    private final ProductoDao productoDao = new ProductoDaoImpl();
    private final CodigoBarrasDao codigoBarrasDao = new CodigoBarrasDaoImpl();

    public Long crearProductoConCodigoBarras(Producto p, CodigoBarras cb) throws SQLException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            con.setAutoCommit(false);

            // 1) Crear B
            if (cb == null) throw new IllegalArgumentException("CodigoBarras requerido");
            validarCodigoBarras(cb);
            Long cbId = codigoBarrasDao.crear(con, cb);
            cb.setId(cbId);

            // 2) Asociar en A
            if (p == null) throw new IllegalArgumentException("Producto requerido");
            validarProducto(p);
            p.setCodigoBarras(cb);

            // 3) Crear A
            Long pId = productoDao.crear(con, p);

            con.commit();
            return pId;
        } catch (Exception e) {
            if (con != null) try { con.rollback(); } catch (Exception ignored) {}
            if (e instanceof SQLException) throw (SQLException) e;
            throw new SQLException("Error en transacción crearProductoConCodigoBarras: " + e.getMessage(), e);
        } finally {
            if (con != null) {
                try { con.setAutoCommit(true); } catch (Exception ignored) {}
                try { con.close(); } catch (Exception ignored) {}
            }
        }
    }

    public Long crearProductoConCodigoBarrasExistente(Producto p, String valorCodigoBarras) throws SQLException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            con.setAutoCommit(false);

            CodigoBarras cb = codigoBarrasDao.buscarPorValor(con, valorCodigoBarras);
            if (cb == null) throw new SQLException("No existe CodigoBarras con valor=" + valorCodigoBarras);

            validarProducto(p);
            p.setCodigoBarras(cb);
            Long id = productoDao.crear(con, p);

            con.commit();
            return id;
        } catch (Exception e) {
            if (con != null) try { con.rollback(); } catch (Exception ignored) {}
            if (e instanceof SQLException) throw (SQLException) e;
            throw new SQLException("Error en transacción crearProductoConCodigoBarrasExistente: " + e.getMessage(), e);
        } finally {
            if (con != null) {
                try { con.setAutoCommit(true); } catch (Exception ignored) {}
                try { con.close(); } catch (Exception ignored) {}
            }
        }
    }

    public Producto leerPorId(Long id) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return productoDao.leerPorId(con, id);
        }
    }

    public List<Producto> leerTodos() throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return productoDao.leerTodos(con);
        }
    }

    public boolean actualizar(Producto p) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            validarProducto(p);
            return productoDao.actualizar(con, p);
        }
    }

    public boolean eliminarLogico(Long id) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return productoDao.eliminarLogico(con, id);
        }
    }

    public List<Producto> buscarPorCodigoBarrasValor(String valor) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return productoDao.buscarPorCodigoBarrasValor(con, valor);
        }
    }

    private void validarProducto(Producto p) {
        if (p.getNombre() == null || p.getNombre().isBlank())
            throw new IllegalArgumentException("nombre requerido");
        if (p.getUnidadMedida() == null || p.getUnidadMedida().isBlank())
            p.setUnidadMedida("unidad");
        if (p.getPrecio() < 0) throw new IllegalArgumentException("precio no puede ser negativo");
    }

    private void validarCodigoBarras(CodigoBarras cb) {
        if (cb.getValor() == null || cb.getValor().isBlank())
            throw new IllegalArgumentException("valor de codigo de barras requerido");
        if (cb.getTipo() == null || cb.getTipo().isBlank())
            cb.setTipo("EAN13");
    }
}
