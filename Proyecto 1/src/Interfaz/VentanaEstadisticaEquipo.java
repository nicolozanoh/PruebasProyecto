package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaEstadisticaEquipo extends JFrame{
	InterfazPrincipal padre;
	PanelEstadisticaEquipoEQ panelEquipo;
	PanelEstadisticaEquipoJG panelJugador;
	public VentanaEstadisticaEquipo(InterfazPrincipal papa) {
		padre=papa;
		this.panelEquipo = new PanelEstadisticaEquipoEQ(this);
		this.panelJugador = new PanelEstadisticaEquipoJG(this);

		//setTitle("Fantasy Football");
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(1300, 800));
		setResizable(false);
		setVisible(true);
		
		setLayout(new GridLayout(1,2));
		add(panelEquipo);
		add(panelJugador);
	}
	public InterfazPrincipal getInterfaz() {
		return this.padre;
	}

}
