package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import modelo.EquipoFantasia;

public class VentanaEstadisticaEquipo extends JFrame{
	InterfazPrincipal padre;
	PanelEstadisticaEquipoEQ panelEquipo;
	PanelEstadisticaEquipoJG panelJugador;
	public VentanaEstadisticaEquipo(InterfazPrincipal papa, EquipoFantasia equipo) {
		padre=papa;
		this.panelEquipo = new PanelEstadisticaEquipoEQ(this, equipo);
		this.panelJugador = new PanelEstadisticaEquipoJG(this, equipo);

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
