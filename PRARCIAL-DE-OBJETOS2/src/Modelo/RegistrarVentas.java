package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistrarVentas {

	void guardarVentas(Venta venta) throws Exception;

	List<Venta> recuperarVentasEntreDosFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception;

}
