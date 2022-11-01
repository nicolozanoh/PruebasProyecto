package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaUsuario extends JFrame{
	private PanelUsuario panelUsuario;
	private PanelUsuarioDerecha panelUsuarioDerecha;
	private PanelUsuarioSuperior panelUsuarioSuperior;
	private PanelUsuarioIzquierda panelUsuarioIzquierda;
	private InterfazPrincipal padre;
	
	public VentanaUsuario(InterfazPrincipal papa) {
		padre = papa;
		this.panelUsuario = new PanelUsuario(this);
		this.panelUsuarioDerecha = new PanelUsuarioDerecha(this);
		this.panelUsuarioIzquierda = new PanelUsuarioIzquierda(this);
		this.panelUsuarioSuperior = new PanelUsuarioSuperior(this);

		//setTitle("Fantasy Football");
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1300, 800));
		setResizable(false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		add(panelUsuarioDerecha,  BorderLayout.EAST);
		add(panelUsuario,  BorderLayout.CENTER);
		add(panelUsuarioIzquierda, BorderLayout.WEST);
		add(panelUsuarioSuperior, BorderLayout.NORTH);
	}
	
	public InterfazPrincipal getInterfaz() {
		return this.padre;
		
	}
}
