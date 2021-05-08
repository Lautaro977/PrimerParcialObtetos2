package Main;

import Persistencia.RegistrarEnBD;
import UI.Conexion;
import UI.MenuPrincipal;

public class MainBD {
	public static void main(String[] args) {

		MenuPrincipal mp = new MenuPrincipal(new RegistrarEnBD(new Conexion()));
		mp.setVisible(true);
	}
}
