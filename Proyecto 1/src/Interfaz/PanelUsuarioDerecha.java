package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelUsuarioDerecha extends JPanel{

	private VentanaUsuario padre;
	
	private JLabel presupuesto;
	private JLabel capitan;
	
	private JTextField campoPresupuesto;
	private JTextField campoCapitan;
	
	public PanelUsuarioDerecha(VentanaUsuario papa) {
		
		padre = papa;
		
		
		presupuesto = new JLabel("PRESUPUESTO:",SwingConstants.CENTER);
		presupuesto.setPreferredSize(new Dimension(200,50));
		
		capitan = new JLabel("CAPITAN:",SwingConstants.CENTER);
		capitan.setPreferredSize(new Dimension(70,50));
		
		campoPresupuesto = new JTextField(Double.toString(this.padre.getUsuario().getPresupuesto()),SwingConstants.CENTER);
		campoPresupuesto.setHorizontalAlignment(SwingConstants.CENTER);
		campoPresupuesto.setPreferredSize(new Dimension(70,10));
		campoPresupuesto.setEditable(false);
		
		campoCapitan= new JTextField(this.padre.getUsuario().getEquipo().getCapitan().getNombre());
		campoCapitan.setHorizontalAlignment(SwingConstants.CENTER);
		campoCapitan.setPreferredSize(new Dimension(70,10));
		campoCapitan.setEditable(false);
		
		setLayout(new GridLayout(4,1));
		add(presupuesto);
		add(campoPresupuesto);
		add(capitan);
		add(campoCapitan);
		
	}

	public void actualizarCapitan() {
		this.campoCapitan.setText(this.padre.getUsuario().getEquipo().getCapitan().getNombre());
		
	}

	public void actualizarPresupuesto() {
		this.campoPresupuesto.setText(Double.toString(this.padre.getUsuario().getPresupuesto()));
		
	}
	
}
