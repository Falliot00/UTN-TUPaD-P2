package edu.utn.p2.tfi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    Long crear(Connection con, T t) throws SQLException;
    T leerPorId(Connection con, Long id) throws SQLException;
    List<T> leerTodos(Connection con) throws SQLException;
    boolean actualizar(Connection con, T t) throws SQLException;
    boolean eliminarLogico(Connection con, Long id) throws SQLException;
}
