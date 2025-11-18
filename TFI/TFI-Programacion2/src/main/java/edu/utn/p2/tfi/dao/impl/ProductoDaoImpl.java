package edu.utn.p2.tfi.dao.impl;

import edu.utn.p2.tfi.dao.ProductoDao;
import edu.utn.p2.tfi.entities.CodigoBarras;
import edu.utn.p2.tfi.entities.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {

    @Override
    public Long crear(Connection con, Producto p) throws SQLException {
        String sql = "INSERT INTO Producto(nombre, marca, precio, unidad_medida, eliminado, codigo_barras_id) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            ps.setDouble(3, p.getPrecio());
            ps.setString(4, p.getUnidadMedida());
            ps.setBoolean(5, p.isEliminado());
            if (p.getCodigoBarras() != null) ps.setLong(6, p.getCodigoBarras().getId());
            else ps.setNull(6, Types.BIGINT);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getLong(1);
            }
        }
        return null;
    }

    @Override
    public Producto leerPorId(Connection con, Long id) throws SQLException {
        String sql = "SELECT p.id pid, p.nombre, p.marca, p.precio, p.unidad_medida, p.eliminado pelim, " +
                     "cb.id cbid, cb.valor, cb.tipo, cb.eliminado cbelim " +
                     "FROM Producto p LEFT JOIN CodigoBarras cb ON p.codigo_barras_id = cb.id WHERE p.id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        }
        return null;
    }

    @Override
    public List<Producto> leerTodos(Connection con) throws SQLException {
        String sql = "SELECT p.id pid, p.nombre, p.marca, p.precio, p.unidad_medida, p.eliminado pelim, " +
                     "cb.id cbid, cb.valor, cb.tipo, cb.eliminado cbelim " +
                     "FROM Producto p LEFT JOIN CodigoBarras cb ON p.codigo_barras_id = cb.id ORDER BY p.id";
        List<Producto> out = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
        }
        return out;
    }

    @Override
    public boolean actualizar(Connection con, Producto p) throws SQLException {
        String sql = "UPDATE Producto SET nombre=?, marca=?, precio=?, unidad_medida=?, eliminado=?, codigo_barras_id=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            ps.setDouble(3, p.getPrecio());
            ps.setString(4, p.getUnidadMedida());
            ps.setBoolean(5, p.isEliminado());
            if (p.getCodigoBarras() != null) ps.setLong(6, p.getCodigoBarras().getId());
            else ps.setNull(6, Types.BIGINT);
            ps.setLong(7, p.getId());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean eliminarLogico(Connection con, Long id) throws SQLException {
        String sql = "UPDATE Producto SET eliminado=1 WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public List<Producto> buscarPorCodigoBarrasValor(Connection con, String valor) throws SQLException {
        String sql = "SELECT p.id pid, p.nombre, p.marca, p.precio, p.unidad_medida, p.eliminado pelim, " +
                     "cb.id cbid, cb.valor, cb.tipo, cb.eliminado cbelim " +
                     "FROM Producto p INNER JOIN CodigoBarras cb ON p.codigo_barras_id = cb.id WHERE cb.valor=?";
        List<Producto> out = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, valor);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) out.add(map(rs));
            }
        }
        return out;
    }

    private Producto map(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("pid"));
        p.setNombre(rs.getString("nombre"));
        p.setMarca(rs.getString("marca"));
        p.setPrecio(rs.getDouble("precio"));
        p.setUnidadMedida(rs.getString("unidad_medida"));
        p.setEliminado(rs.getBoolean("pelim"));
        long cbid = rs.getLong("cbid");
        if (!rs.wasNull()) {
            CodigoBarras cb = new CodigoBarras();
            cb.setId(cbid);
            cb.setValor(rs.getString("valor"));
            cb.setTipo(rs.getString("tipo"));
            cb.setEliminado(rs.getBoolean("cbelim"));
            p.setCodigoBarras(cb);
        }
        return p;
    }
}
