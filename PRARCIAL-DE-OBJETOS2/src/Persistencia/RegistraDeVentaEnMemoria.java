package Persistencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Modelo.RegistrarVentas;
import Modelo.Venta;

public class RegistraDeVentaEnMemoria implements RegistrarVentas {
	private List<Venta> ListaVentas = new ArrayList<>();

	public void guardarVentas(Venta venta) {
		ListaVentas.add(venta);
	}

	/*
	 * public List<Venta> obtenerVentas() throws Exception { return ListaVentas; }
	 */

	public List<Venta> recuperarVentasEntreDosFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception {
		List<Venta> ListaVentaEntreFechas = new ArrayList<>();

		for (Venta ven : ListaVentas) {

			try {
				String ventaString = ven.obtenerfecha();
				String[] split = ventaString.split("-");

				LocalDateTime fecha = LocalDateTime.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]),
						Integer.parseInt(split[0]), 0, 0);

				if (fecha.isAfter(inicio) && fecha.isBefore(fin)) {
					ListaVentaEntreFechas.add(ven);
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		return ListaVentaEntreFechas;

	}
}
