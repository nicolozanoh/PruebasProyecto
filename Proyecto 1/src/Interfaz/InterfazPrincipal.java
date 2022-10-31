package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;

public class InterfazPrincipal extends JFrame{
	
	private PanelInicio panelInicio;

	public InterfazPrincipal() {
		
		panelInicio = new PanelInicio(this);
		
		add(panelInicio);
		
		//Configuraci�n de la ventana
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(300, 200));
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		InterfazPrincipal ip = new InterfazPrincipal();
	}
	
}
