package Interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Jugador;
import modelo.Participante;

public class PanelEstadisticaTemporadaJG extends JPanel{
	private JLabel lNombre;
	private JLabel lPuntosTotales;
	private JLabel lPuntosJornada;
	private JTextField cNombre;
	private JTextField cPuntosTotales;
	private JTextField cPuntosJornada;
	private VentanaEstadisticaTemporada padre;
	public PanelEstadisticaTemporadaJG(VentanaEstadisticaTemporada papa){
		padre = papa;
		Jugador mejorJugador = this.padre.getInterfaz().getAplicacion().mejorJugadorActual();
		lNombre = new JLabel("Nombre:");
		lPuntosTotales = new JLabel("Puntos Totales:");
		lPuntosJornada= new JLabel("Puntos Jornada:");
		
		cNombre = new JTextField(mejorJugador.getNombre());
		cNombre.setEditable(false);
		
		cPuntosTotales = new JTextField(Double.toString(mejorJugador.getPuntosTotales()));
		cPuntosTotales.setEditable(false);
		
		cPuntosJornada = new JTextField(mejorJugador.puntosJornadaToString());
		cPuntosJornada.setEditable(false);
		
		setLayout(new GridLayout(3,2));
		setBorder(new TitledBorder("Mejor Jugador"));
		
		add(lNombre);
		add(cNombre);
		add(lPuntosTotales);
		add(cPuntosTotales);
		add(lPuntosJornada);
		add(cPuntosJornada);
	}
}
