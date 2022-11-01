package Interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelUsuarioIzquierda extends JPanel{
	
	private VentanaUsuario padre;
	
	private JButton cambiarAlineacion;
	private JButton cambiarCapitan;
	public PanelUsuarioIzquierda(VentanaUsuario papa) {
		padre = papa;
		
		cambiarAlineacion = new JButton("Cambiar Alineación");
		cambiarCapitan = new JButton("Cambiar Capitan");
		setLayout(new GridLayout(2,1));
		add(cambiarAlineacion);
		add(cambiarCapitan);
	}

}
