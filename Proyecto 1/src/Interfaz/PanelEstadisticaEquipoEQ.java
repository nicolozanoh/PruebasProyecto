package Interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.EquipoFantasia;
import modelo.Participante;


public class PanelEstadisticaEquipoEQ extends JPanel{
	private JLabel lNombreEquipo;
	private JLabel lPuntosTotales;
	private JLabel lPuntosJornada;
	private JTextField campoNombre;
	private JTextField campoPuntosTotales;
	private JTextField campoPuntosJornada;
	private VentanaEstadisticaEquipo padre;
	public PanelEstadisticaEquipoEQ(VentanaEstadisticaEquipo papa) {
		padre = papa;
		EquipoFantasia equipo = ((Participante)this.padre.getInterfaz().getAplicacion().getUsuarioActivo()).getEquipo();
		lNombreEquipo = new JLabel("Nombre:");
		lPuntosTotales = new JLabel("Puntos Totales:");
		lPuntosJornada= new JLabel("Puntos Jornada:");
		
		campoNombre = new JTextField(equipo.getNombre());
		campoNombre.setEditable(false);
		
		campoPuntosTotales = new JTextField(Double.toString(equipo.getPuntosTotales()));
		campoPuntosTotales.setEditable(false);
		
		campoPuntosJornada = new JTextField(equipo.puntosJornadaToString());
		campoPuntosJornada.setEditable(false);
		
		setLayout(new GridLayout(3,2));
		setBorder(new TitledBorder("Resultados Equipo"));
		
		add(lNombreEquipo);
		add(campoNombre);
		add(lPuntosTotales);
		add(campoPuntosTotales);
		add(lPuntosJornada);
		add(campoPuntosJornada);
		
		
	}
}
