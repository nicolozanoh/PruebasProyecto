package Interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelEstadisticas extends JPanel implements ActionListener{
	private static final String EQUIPO = "EQUIPO";
	private static final String TEMPORADA = "TEMPORADA";
	private static final String JORNADA = "JORNADA";
	private JButton btnEstEquipo;
	private JButton btnEstJornada;
	private JButton btnEstTemporada;
	private VentanaEstadisticas padre;
	public PanelEstadisticas(VentanaEstadisticas papa) {
		padre = papa;
		
		btnEstEquipo = new JButton("Resultados del equipo");
		btnEstEquipo.setActionCommand(EQUIPO);
		btnEstEquipo.addActionListener(this);
		
		btnEstJornada = new JButton("Resultados por jornada");
		btnEstJornada.setActionCommand(JORNADA);
		btnEstJornada.addActionListener(this);
		
		btnEstTemporada = new JButton("Resultados de la temporada");
		btnEstTemporada.setActionCommand(TEMPORADA);
		btnEstTemporada.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		add(btnEstEquipo);
		add(btnEstJornada);
		add(btnEstTemporada);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equals(EQUIPO)) {
			this.padre.mostrarEstadisticasEquipo();
		}
		if(evento.equals(JORNADA)) {
			this.padre.mostrarEstadisticasJornada();
		}
		if(evento.equals(TEMPORADA)) {
			this.padre.mostrarEstadisticasTemporada();
		}
	}
}
