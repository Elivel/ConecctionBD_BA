package service;
import repository.CuentaRepository;
import java.sql.SQLException;
//Lógica de negocio
public class CuentaService {

    private CuentaRepository repository = new CuentaRepository();

    public void asegurarSaldo(String cuenta, double saldoRequerido) throws SQLException {

        double saldoActual = repository.obtenerSaldo(cuenta);

        if (saldoActual != saldoRequerido) {
            repository.actualizarSaldo(cuenta, saldoRequerido);
        }
    }
}
