package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaAdmin extends JFrame{
	private PanelAdmin panelAdmin;
	private InterfazPrincipal padre;
	
	public VentanaAdmin(InterfazPrincipal papa) {
		padre = papa;
		this.panelAdmin = new PanelAdmin(this);
		
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1300, 800));
		setResizable(false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		add(panelAdmin, BorderLayout.NORTH);
	}
	public InterfazPrincipal getInterfaz() {
		return this.padre;
	}
}
