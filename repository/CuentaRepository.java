package repository;
import conecction.OracleConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Queries puras
public class CuentaRepository {

    public double obtenerSaldo(String numeroCuenta) throws SQLException {

        String sql = "SELECT SALDO FROM CUENTAS WHERE NUMERO_CUENTA = ?";

        PreparedStatement stmt = OracleConnection.getConnection().prepareStatement(sql);
        stmt.setString(1, numeroCuenta);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getDouble("SALDO");
        }

        return 0;
    }

    public void actualizarSaldo(String numeroCuenta, double nuevoSaldo) throws SQLException {

        String sql = "UPDATE CUENTAS SET SALDO = ? WHERE NUMERO_CUENTA = ?";

        PreparedStatement stmt = OracleConnection.getConnection().prepareStatement(sql);
        stmt.setDouble(1, nuevoSaldo);
        stmt.setString(2, numeroCuenta);

        stmt.executeUpdate();
    }
}

