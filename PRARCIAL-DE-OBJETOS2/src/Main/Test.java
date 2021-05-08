package Main;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import Modelo.Combustible;
import Modelo.Comun;
import Modelo.RegistrarVentas;
import Modelo.Super;
import Modelo.Venta;
import Persistencia.RegistraDeVentaEnMemoria;
import junit.framework.Assert;

class Test {

	@org.junit.jupiter.api.Test
	void testCombustibleSuper() throws Exception {
		float resultadoEsperado = 1584.f;

		Combustible com = new Super(90);
		float precioCombustible = com.calcularMonto(20);

		float resultado = com.realizarDescuento(precioCombustible,
				LocalDateTime.of(LocalDate.of(2021, 05, 8), LocalTime.now()));

		Assert.assertEquals(resultadoEsperado, resultado);

	}

	@org.junit.jupiter.api.Test
	void testCombustibleComun() throws Exception {
		float resultadoEsperado = 66.5f;

		Combustible com = new Comun(70);
		float precioCombustible = com.calcularMonto(1);

		float resultado = com.realizarDescuento(precioCombustible,
				LocalDateTime.of(LocalDate.of(2021, 05, 8), LocalTime.now()));

		Assert.assertEquals(resultadoEsperado, resultado);

	}

	@org.junit.jupiter.api.Test
	void testGuardarVenta() throws Exception {
		RegistrarVentas regven = new RegistraDeVentaEnMemoria();

		Venta venta = new Venta(LocalDateTime.of(2021, 05, 8, 11, 0).toString(), "5", "500");
		assertDoesNotThrow(() -> regven.guardarVentas(venta));

	}

	@org.junit.jupiter.api.Test
	void testObtenerListaVentasEntreDosFechas() throws Exception {

		RegistrarVentas regven = new RegistraDeVentaEnMemoria();

		Venta venta1 = new Venta(LocalDateTime.of(2021, 05, 8, 0, 0).toString(), "3", "300");
		Venta venta2 = new Venta(LocalDateTime.of(2021, 05, 10, 11, 0).toString(), "4", "400");
		regven.guardarVentas(venta1);
		regven.guardarVentas(venta2);
		List<Venta> ListaVentas = regven.recuperarVentasEntreDosFechas(LocalDateTime.of(2021, 05, 5, 0, 0),
				LocalDateTime.of(2021, 05, 10, 0, 0));

		assertNotNull(ListaVentas);
	}

}
