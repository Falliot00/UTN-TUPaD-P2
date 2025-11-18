package edu.utn.p2.tfi.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Properties loadProps() {
        try (InputStream in = DatabaseConnection.class.getClassLoader()
                .getResourceAsStream("database.properties")) {
            if (in == null) throw new RuntimeException("database.properties no encontrado en resources/");
            Properties p = new Properties();
            p.load(in);
            return p;
        } catch (Exception e) {
            throw new RuntimeException("Error cargando properties: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties p = loadProps();
        String host = p.getProperty("db.host");
        String port = p.getProperty("db.port");
        String name = p.getProperty("db.name");
        String user = p.getProperty("db.user");
        String pass = p.getProperty("db.password");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        return DriverManager.getConnection(url, user, pass);
    }

    public static void closeQuietly(AutoCloseable c) {
        if (c != null) {
            try { c.close(); } catch (Exception ignored) {}
        }
    }
}
