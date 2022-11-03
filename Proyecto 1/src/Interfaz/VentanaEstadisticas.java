package Interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaEstadisticas extends JFrame{
	
	private InterfazPrincipal padre;
	private PanelEstadisticas panel;
	public VentanaEstadisticas(InterfazPrincipal papa) {
		padre = papa;
		
		panel = new PanelEstadisticas(this);
		
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(300, 150));
		setResizable(false);
		setVisible(true);
		
		add(panel);
		
	}
}