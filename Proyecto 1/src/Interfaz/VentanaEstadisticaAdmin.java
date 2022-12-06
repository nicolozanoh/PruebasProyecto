package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaEstadisticaAdmin extends JFrame{

		private InterfazPrincipal padre;
		private PanelEstadisticasAdmin panel;
		public VentanaEstadisticaAdmin(InterfazPrincipal papa) {
			padre = papa;
			
			panel = new PanelEstadisticasAdmin(this);
			
			setTitle("Fantasy Football");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(new Dimension(300, 150));
			setResizable(false);
			setVisible(true);
			
			add(panel);
			
		
	}
	public void mostrarComparacionRankEquipos() {
		this.padre.mostrarComparacionRankEquipos();
	}
	public void mostrarJugadoresMayorAporte() {
		this.padre.mostrarJugadoresMayorAporte();
	}
	public void mostrarJugadoresMasPuntosUnEquipo() {
		this.padre.mostrarJugadoresMasPuntosUnEquipo();
	}
	
}
