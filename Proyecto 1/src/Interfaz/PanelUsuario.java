package Interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelUsuario extends JPanel{
	private VentanaUsuario padre;
	
	public PanelUsuario(VentanaUsuario papa) {
		padre = papa;
		setBorder(new TitledBorder("Bienvenido "+ padre.getInterfaz().getAplicacion().getUsuarioActivo().getNombreUsuario()+"!"));
	}
}
