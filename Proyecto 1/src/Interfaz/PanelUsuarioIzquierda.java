package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelUsuarioIzquierda extends JPanel implements ActionListener{
	private static final String CALINEACION = "INICIAR";
	private static final String CCAPITAN = "CREAR";
	private VentanaUsuario padre;
	
	private JButton cambiarAlineacion;
	private JButton cambiarCapitan;
	public PanelUsuarioIzquierda(VentanaUsuario papa) {
		padre = papa;
		
		cambiarAlineacion = new JButton("Cambiar Alineación");
		cambiarAlineacion.setActionCommand(CALINEACION);
		cambiarAlineacion.addActionListener(this);
		cambiarCapitan = new JButton("Cambiar Capitan");
		cambiarCapitan.setActionCommand(CCAPITAN);
		cambiarCapitan.addActionListener(this);
		setLayout(new GridLayout(2,1));
		add(cambiarAlineacion);
		add(cambiarCapitan);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals(CALINEACION)) {
			padre.CambiarAlineacion();
		}
		if (evento.equals(CCAPITAN)) {
			padre.CambiarCapitan();
		}
	}

}
