package Interfaz;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelAdmin extends JPanel{
	private VentanaAdmin padre;
	
	private JButton cargarJugadores;
	private JButton cargarUnPartido;
	private JButton cargarPartidos;
	
	
	public PanelAdmin(VentanaAdmin papa) {
		padre = papa;
		
		cargarJugadores = new JButton("Cargar la información de los jugadores");
		cargarUnPartido = new JButton("Cargar la información de un partido");
		cargarPartidos = new JButton("Cargar la información de los partidos");
		setBorder(new TitledBorder("Bienvenido admin!"));
		
		setLayout(new FlowLayout());
		
		add(cargarJugadores);
		add(cargarUnPartido);
		add(cargarPartidos);
		
	}
}
