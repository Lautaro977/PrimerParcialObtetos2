package Modelo;

public class Venta {

	private FechaVenta fechaVenta;
	private LitrosCargadosVenta litrosCargados;
	private MontoFacturadoVenta montoFacturado;

	public Venta(String fechaVenta, String litrosCargados, String montoFacturado) throws ValidarException {
		this.fechaVenta = new FechaVenta(fechaVenta);
		this.litrosCargados = new LitrosCargadosVenta(litrosCargados);
		this.montoFacturado = new MontoFacturadoVenta(montoFacturado);
	}

	public String obtenerfecha() {
		return this.fechaVenta.obtenerFechaVenta();
	}

	public String obtenerLitrosCargados() {
		return this.litrosCargados.obtenerLitrosVenta();
	}

	public String obtenerMontoFactura() {
		return this.montoFacturado.obtenerMontoVenta();
	}

}
