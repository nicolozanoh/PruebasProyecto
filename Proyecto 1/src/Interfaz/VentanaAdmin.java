package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaAdmin extends JFrame{
	private PanelAdmin panelAdmin;
	private InterfazPrincipal padre;
	
	public VentanaAdmin(InterfazPrincipal papa) {
		padre = papa;
		panelAdmin = new PanelAdmin(this);
		add(panelAdmin);
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
