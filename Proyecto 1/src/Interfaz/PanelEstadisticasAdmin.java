package Interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelEstadisticasAdmin extends JPanel implements ActionListener{
	private static final String EQUIPOS = "EQUIPOS";
	private static final String JUGADORES = "JUGADORES";
	private static final String JEQUIPO = "JEQUIPO";
	private JButton btnEstComparacionRankEquipos;
	private JButton btnEstJugadoresMayorAporte;
	private JButton btnEstJugadoresMasPuntosUnEquipo;
	private VentanaEstadisticaAdmin padre;
	public PanelEstadisticasAdmin(VentanaEstadisticaAdmin papa) {
		padre = papa;
		
		btnEstComparacionRankEquipos = new JButton("Comparacion Entre los mejores equipos");
		btnEstComparacionRankEquipos.setActionCommand(EQUIPOS);
		btnEstComparacionRankEquipos.addActionListener(this);
		
		btnEstJugadoresMayorAporte = new JButton("Jugadores Mayor Aporte");
		btnEstJugadoresMayorAporte.setActionCommand(JUGADORES);
		btnEstJugadoresMayorAporte.addActionListener(this);
		
		btnEstJugadoresMasPuntosUnEquipo = new JButton("Jugadores Mas Puntos en un equipo");
		btnEstJugadoresMasPuntosUnEquipo.setActionCommand(JEQUIPO);
		btnEstJugadoresMasPuntosUnEquipo.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		add(btnEstComparacionRankEquipos);
		add(btnEstJugadoresMayorAporte);
		add(btnEstJugadoresMasPuntosUnEquipo);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equals(EQUIPOS)) {
			this.padre.mostrarComparacionRankEquipos();
		}
		if(evento.equals(JUGADORES)) {
			this.padre.mostrarJugadoresMayorAporte();
		}
		if(evento.equals(JEQUIPO)) {
			this.padre.mostrarJugadoresMasPuntosUnEquipo();
		}
	}
}

