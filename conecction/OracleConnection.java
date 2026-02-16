package conecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.DatabaseConfig;

//Conexión técnica a Oracle
public class OracleConnection {
    

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        DatabaseConfig.getUrl(),
                        DatabaseConfig.getUser(),
                        DatabaseConfig.getPassword()
                );
            } catch (SQLException e) {
                throw new RuntimeException("Error conectando a Oracle", e);
            }
        }

        return connection;
    }
}
