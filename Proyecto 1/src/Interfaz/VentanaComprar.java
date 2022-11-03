package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Jugador;

public class VentanaComprar extends JFrame{
	private InterfazPrincipal padre;
	private PanelSuperiorComprar panelSuperior;
	private PanelInferiorComprar panelInferior;
	public VentanaComprar(InterfazPrincipal papa) {
		padre= papa;
		this.panelSuperior = new PanelSuperiorComprar(this);
		this.panelInferior = new PanelInferiorComprar(this);
		
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(1300, 800));
		setResizable(false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		add(panelSuperior,  BorderLayout.NORTH);
		add(panelInferior,  BorderLayout.CENTER);
	}
	public InterfazPrincipal getInterfaz() {
		return this.padre;
		
	}
	public void comprarJugador(ArrayList<Jugador> jugadoresComprar) {
		this.padre.comprarJugador(jugadoresComprar);
	}
}
