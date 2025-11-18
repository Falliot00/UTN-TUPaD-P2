package edu.utn.p2.tfi.dao;

import edu.utn.p2.tfi.entities.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProductoDao extends GenericDao<Producto> {
    List<Producto> buscarPorCodigoBarrasValor(Connection con, String valor) throws SQLException;
}
