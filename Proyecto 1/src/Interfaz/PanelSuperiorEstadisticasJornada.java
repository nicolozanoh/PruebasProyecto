package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSuperiorEstadisticasJornada extends JPanel implements ActionListener{
	private static final String BUSCAR = "BUSCAR";
	private JLabel lnumJornada;
	private JTextField numJornada;
	private JButton btnBuscar;
	private JLabel espacio;
	private VentanaEstadisticaJornada padre;
	public PanelSuperiorEstadisticasJornada(VentanaEstadisticaJornada papa) {
		padre = papa;
		lnumJornada = new JLabel("Numero de la jornada");
		numJornada = new JTextField();
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand(BUSCAR);
		btnBuscar.addActionListener(this);
		
		espacio = new JLabel("");
		
		setLayout(new GridLayout(2,2));
		add(lnumJornada);
		add(numJornada);
		add(btnBuscar);
		add(espacio);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equals(BUSCAR)) {
			this.padre.buscarInfoJornada(Integer.parseInt(numJornada.getText()));
			
		}
		
	}
}
