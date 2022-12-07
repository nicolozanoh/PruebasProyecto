package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.EquipoFantasia;

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
		
		campoPresupuesto = new JTextField("");
		campoPresupuesto.setHorizontalAlignment(SwingConstants.CENTER);
		campoPresupuesto.setPreferredSize(new Dimension(70,10));
		campoPresupuesto.setEditable(false);
		
		campoCapitan= new JTextField("");
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
		this.campoCapitan.setText(this.padre.getEquipoSeleccionado().getCapitan().getNombre());
		
	}

	public void actualizarPresupuesto() {
		this.campoPresupuesto.setText(Double.toString(this.padre.getEquipoSeleccionado().getPresupuesto()));
		
	}
	
}
