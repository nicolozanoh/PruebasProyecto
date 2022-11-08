package Interfaz;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.EquipoFantasia;
import modelo.Jugador;

public class PanelCentralEstadisticasJornada extends JPanel{
	private PanelEstadisticaJornadaEQ panelEquipo;
	private PanelEstadisticaJornadaJG panelJugador;
	private VentanaEstadisticaJornada padre;
	public PanelCentralEstadisticasJornada (VentanaEstadisticaJornada papa) {
		padre = papa;
		this.panelEquipo = new PanelEstadisticaJornadaEQ(this);
		this.panelJugador = new PanelEstadisticaJornadaJG(this);
		setLayout(new GridLayout(1,2));
		add(panelEquipo);
		add(panelJugador);
	}
	public void buscarInfoJornada(int numJornada) {
		EquipoFantasia equipo = this.padre.getInterfaz().getAplicacion().mejorEquipoFecha(numJornada);
		Jugador jugador = this.padre.getInterfaz().getAplicacion().mejorJugadorFecha(numJornada);
		if(jugador != null && equipo != null) {
			this.panelEquipo.actualizarInfo(equipo);
			this.panelJugador.actualizarInfo(jugador);
		}
		else {
			JOptionPane.showMessageDialog(this, "No hay información de la jornada seleccionada, por favor seleccione otra.","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public VentanaEstadisticaJornada getVentanaJornada() {
		return this.padre;
	}

	
}
