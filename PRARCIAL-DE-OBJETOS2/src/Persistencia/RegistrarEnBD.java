package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Modelo.RegistrarVentas;
import Modelo.Venta;
import UI.Conexion;

public class RegistrarEnBD implements RegistrarVentas {

	private Conexion conexion;

	public RegistrarEnBD(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public void guardarVentas(Venta venta) throws Exception {

		// TODO Auto-generated method stub
		String sqlUpdate = "Insert ventas SET fecha = ? ,litros = ? ,monto = ?";

		try {

			Connection conexion = (Connection) Conexion.conexion();
			PreparedStatement ps = (PreparedStatement) ((java.sql.Connection) conexion).prepareStatement(sqlUpdate);
			ps.setString(1, venta.obtenerfecha());
			ps.setString(2, venta.obtenerLitrosCargados());
			ps.setString(3, venta.obtenerMontoFactura());

			ps.executeUpdate();

			ps.close();
			conexion.close();

		} catch (SQLException e) {
			throw new Exception("Error No se pudo Guardar Venta");
		}

	}

	@Override
	public List<Venta> recuperarVentasEntreDosFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception {
		// TODO Auto-generated method stub

		List<Venta> ListaVentas = new ArrayList<Venta>();

		try {

			Connection conexion = Conexion.conexion();
			Statement sent = conexion.createStatement();

			ResultSet resul = sent.executeQuery("select * from ventas");

			while (resul.next()) {

				String[] stringSplit = resul.getString(1).split("-");
				LocalDateTime fecha = LocalDateTime.of(Integer.parseInt(stringSplit[0]),
						Integer.parseInt(stringSplit[1]), Integer.parseInt(stringSplit[2]), 0, 0);

				if (fecha.isAfter(inicio) && fecha.isBefore(fin)) {
					ListaVentas.add(new Venta(resul.getString(1), resul.getString("litros"), resul.getString("monto")));
				}
			}

		} catch (SQLException e) {
			throw new Exception("Error" + e.getMessage());
		}

		return ListaVentas;
	}
}
