package edu.utn.p2.tfi.dao.impl;

import edu.utn.p2.tfi.dao.CodigoBarrasDao;
import edu.utn.p2.tfi.entities.CodigoBarras;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CodigoBarrasDaoImpl implements CodigoBarrasDao {

    @Override
    public Long crear(Connection con, CodigoBarras cb) throws SQLException {
        String sql = "INSERT INTO CodigoBarras(valor, tipo, eliminado) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cb.getValor());
            ps.setString(2, cb.getTipo());
            ps.setBoolean(3, cb.isEliminado());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getLong(1);
            }
        }
        return null;
    }

    @Override
    public CodigoBarras leerPorId(Connection con, Long id) throws SQLException {
        String sql = "SELECT id, valor, tipo, eliminado FROM CodigoBarras WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<CodigoBarras> leerTodos(Connection con) throws SQLException {
        String sql = "SELECT id, valor, tipo, eliminado FROM CodigoBarras ORDER BY id";
        List<CodigoBarras> out = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
        }
        return out;
    }

    @Override
    public boolean actualizar(Connection con, CodigoBarras cb) throws SQLException {
        String sql = "UPDATE CodigoBarras SET valor=?, tipo=?, eliminado=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cb.getValor());
            ps.setString(2, cb.getTipo());
            ps.setBoolean(3, cb.isEliminado());
            ps.setLong(4, cb.getId());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean eliminarLogico(Connection con, Long id) throws SQLException {
        String sql = "UPDATE CodigoBarras SET eliminado=1 WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public CodigoBarras buscarPorValor(Connection con, String valor) throws SQLException {
        String sql = "SELECT id, valor, tipo, eliminado FROM CodigoBarras WHERE valor=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, valor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        }
        return null;
    }

    private CodigoBarras map(ResultSet rs) throws SQLException {
        CodigoBarras cb = new CodigoBarras();
        cb.setId(rs.getLong("id"));
        cb.setValor(rs.getString("valor"));
        cb.setTipo(rs.getString("tipo"));
        cb.setEliminado(rs.getBoolean("eliminado"));
        return cb;
    }
}
