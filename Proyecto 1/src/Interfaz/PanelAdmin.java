package Interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelAdmin extends JPanel implements ActionListener{
	private static final String CTEMPORADA = "CTEMPORADA";
	private static final String CPARTIDO = "CPARTIDO";
	private static final String CERRAR = "CERRAR";
	private static final String BORRAR= "BORRAR";

	
	private VentanaAdmin padre;
	
	private JButton cargarTemporada;
	private JButton cargarUnPartido;
	private JButton cerrarSesion;
	private JButton borrarTemporada;
	
	public PanelAdmin(VentanaAdmin papa) {
		padre = papa;
		
		cargarTemporada = new JButton("Cargar información temporada");
		cargarTemporada.setActionCommand(CTEMPORADA);
		cargarTemporada.addActionListener(this);
		
		cargarUnPartido = new JButton("Cargar resultado partido");
		cargarUnPartido.setActionCommand(CPARTIDO);
		cargarUnPartido.addActionListener(this);
		
		cerrarSesion = new JButton("Cerrar Sesión");
		cerrarSesion.setActionCommand(CERRAR);
		cerrarSesion.addActionListener(this);
		
		borrarTemporada = new JButton("Borrar Temporada");
		borrarTemporada.setActionCommand(BORRAR);
		borrarTemporada.addActionListener(this);
		
		
		setBorder(new TitledBorder("Bienvenido admin!"));
		
		setLayout(new FlowLayout());
		
		add(cargarTemporada);
		add(cargarUnPartido);
		add(borrarTemporada);
		add(cerrarSesion);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals(CTEMPORADA)) {
			this.padre.configurarTemporada();
		}
		if (evento.equals(CPARTIDO)) {
			padre.configurarResultadosPartido();
		}
		if (evento.equals(CERRAR)) {
			padre.cerrarSesion();
		}
		if (evento.equals(BORRAR)) {
			padre.borrarTemporada();
		}
	}
}
