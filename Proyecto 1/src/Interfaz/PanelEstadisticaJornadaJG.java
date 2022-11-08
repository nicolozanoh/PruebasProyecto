package Interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Jugador;

public class PanelEstadisticaJornadaJG extends JPanel{
	private JLabel lNombre;
	private JLabel lPuntosTotales;
	private JLabel lPuntosJornada;
	//private JLabel lPosicion;
	private JTextField cNombre;
	private JTextField cPuntosTotales;
	private JTextField cPuntosJornada;
	//private JTextField cPosicion;
	private PanelCentralEstadisticasJornada padre;
	public PanelEstadisticaJornadaJG(PanelCentralEstadisticasJornada papa){
		padre = papa;
		//Jugador mejorJugador = this.padre.getInterfaz().getAplicacion().mejorJugadorActual();
		lNombre = new JLabel("Nombre:");
		lPuntosTotales = new JLabel("Puntos Totales:");
		lPuntosJornada= new JLabel("Puntos Jornada:");
		//lPosicion= new JLabel("Posicion Actual:");
		
		cNombre = new JTextField("");
		cNombre.setEditable(false);
		
		cPuntosTotales = new JTextField("");
		cPuntosTotales.setEditable(false);
		
		cPuntosJornada = new JTextField("");
		cPuntosJornada.setEditable(false);
		
		//cPosicion = new JTextField("");
		//cPosicion.setEditable(false);
		
		setLayout(new GridLayout(3,2));
		setBorder(new TitledBorder("Mejor Jugador"));
		
		add(lNombre);
		add(cNombre);
		add(lPuntosTotales);
		add(cPuntosTotales);
		add(lPuntosJornada);
		add(cPuntosJornada);
		/*
		 * add(lPosicion); add(cPosicion);
		 */
	}
	public void actualizarInfo(Jugador jugador) {
		cNombre.setText(jugador.getNombre());
		cNombre.setEditable(false);
		
		cPuntosTotales.setText(Double.toString(jugador.getPuntosTotales()));
		cPuntosTotales.setEditable(false);
		
		cPuntosJornada.setText(jugador.puntosJornadaToString());
		cPuntosJornada.setEditable(false);
		
		/*
		 * int posicion =
		 * this.padre.getVentanaJornada().getInterfaz().getAplicacion().getTemporada().
		 * getRankingJugadores().indexOf(jugador);
		 * 
		 * cPosicion.setText(Integer.toString(posicion+1));
		 * cPosicion.setEditable(false);
		 */
	}
}
