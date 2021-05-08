package Main;

import Persistencia.RegistroEnArchivoVentas;
import UI.MenuPrincipal;

public class MainDisco {
	public static void main(String[] args) {

		MenuPrincipal mp = new MenuPrincipal(new RegistroEnArchivoVentas(
				"C:\\Users\\lauta\\Desktop\\Archivos Tipo Documento de POO 2\\Primer Parcial Ventas.txt"));
		mp.setVisible(true);
	}
}
