package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaEstadisticaJornada extends JFrame {
	PanelSuperiorEstadisticasJornada panelSuperior;
	PanelCentralEstadisticasJornada panelCentral;
	InterfazPrincipal padre;
	public VentanaEstadisticaJornada(InterfazPrincipal papa) {
		padre = papa;
		this.panelSuperior = new PanelSuperiorEstadisticasJornada(this);
		this.panelCentral = new PanelCentralEstadisticasJornada(this);

		//setTitle("Fantasy Football");
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(1300, 800));
		setResizable(false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		
	}
	public void buscarInfoJornada(int numJornada) {
		panelCentral.buscarInfoJornada(numJornada);
	}
	public InterfazPrincipal getInterfaz() {
		return this.padre;
	}

}
