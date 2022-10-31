package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaUsuario extends JFrame{
	private PanelUsuario panelUsuario;
	private InterfazPrincipal padre;
	
	public VentanaUsuario(InterfazPrincipal papa) {
		padre = papa;
		panelUsuario = new PanelUsuario(this);
		add(panelUsuario);
		//setTitle("Fantasy Football");
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(700, 700));
		setResizable(false);
		setVisible(true);
	}
	public InterfazPrincipal getInterfaz() {
		return this.padre;
	}
}
