package edu.utn.p2.tfi.dao;

import edu.utn.p2.tfi.entities.CodigoBarras;

import java.sql.Connection;
import java.sql.SQLException;

public interface CodigoBarrasDao extends GenericDao<CodigoBarras> {
    CodigoBarras buscarPorValor(Connection con, String valor) throws SQLException;
}
