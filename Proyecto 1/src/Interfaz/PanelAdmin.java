package Interfaz;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelAdmin extends JPanel{
	private VentanaAdmin padre;
	
	public PanelAdmin(VentanaAdmin papa) {
		padre = papa;
		setBorder(new TitledBorder("Bienvenido admin!"));
	}
}
