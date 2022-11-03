package Interfaz;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelSuperiorComprar extends JPanel{
	private JLabel instrucciones;
	private VentanaComprar padre;
	public PanelSuperiorComprar(VentanaComprar papa) {
		padre = papa;
		instrucciones = new JLabel("Para comprar un nuevo jugador, debe haber vendido uno antes. \nEl nuevo jugador debe tener la misma posición del jugador que vendio. \nSolo puede comprar un jugador a la vez");
		setBorder(new TitledBorder("ComprarJugador"));
		
		setLayout(new FlowLayout());
		
		add(instrucciones);
	}
}
