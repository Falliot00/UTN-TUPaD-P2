package edu.utn.p2.tfi.service;

import edu.utn.p2.tfi.config.DatabaseConnection;
import edu.utn.p2.tfi.dao.CodigoBarrasDao;
import edu.utn.p2.tfi.dao.impl.CodigoBarrasDaoImpl;
import edu.utn.p2.tfi.entities.CodigoBarras;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CodigoBarrasService {

    private final CodigoBarrasDao dao = new CodigoBarrasDaoImpl();

    public Long crear(CodigoBarras cb) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            validar(cb);
            return dao.crear(con, cb);
        }
    }

    public CodigoBarras leerPorId(Long id) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return dao.leerPorId(con, id);
        }
    }

    public CodigoBarras buscarPorValor(String valor) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return dao.buscarPorValor(con, valor);
        }
    }

    public List<CodigoBarras> leerTodos() throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return dao.leerTodos(con);
        }
    }

    public boolean actualizar(CodigoBarras cb) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            validar(cb);
            return dao.actualizar(con, cb);
        }
    }

    public boolean eliminarLogico(Long id) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            return dao.eliminarLogico(con, id);
        }
    }

    private void validar(CodigoBarras cb) {
        if (cb == null) throw new IllegalArgumentException("CodigoBarras requerido");
        if (cb.getValor() == null || cb.getValor().isBlank()) throw new IllegalArgumentException("valor requerido");
        if (cb.getTipo() == null || cb.getTipo().isBlank()) cb.setTipo("EAN13");
    }
}
