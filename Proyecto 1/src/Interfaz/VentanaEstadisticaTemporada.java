package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaEstadisticaTemporada extends JFrame{
	InterfazPrincipal padre;
	PanelEstadisticaTemporadaEQ panelEquipo;
	PanelEstadisticaTemporadaJG panelJugador;
	public VentanaEstadisticaTemporada(InterfazPrincipal papa) {
		padre=papa;
		this.panelEquipo = new PanelEstadisticaTemporadaEQ(this);
		this.panelJugador = new PanelEstadisticaTemporadaJG(this);

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
