package Interfaz;

import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaEstadisticas extends JFrame{
	
	private InterfazPrincipal padre;
	private PanelEstadisticas panel;
	public VentanaEstadisticas(InterfazPrincipal papa) {
		padre = papa;
		
		panel = new PanelEstadisticas(this);
		
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(300, 150));
		setResizable(false);
		setVisible(true);
		
		add(panel);
		
	}
	public void mostrarEstadisticasEquipo() {
		this.padre.mostrarEstadisticasEquipo();
		
	}
	public void mostrarEstadisticasJornada() {
		this.padre.mostrarEstadisticasJornada();
		
	}
	public void mostrarEstadisticasTemporada() {
		this.padre.mostrarEstadisticasTemporada();
		
	}
}
