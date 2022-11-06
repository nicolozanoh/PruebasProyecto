package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaAdmin extends JFrame{
	private PanelAdmin panelAdmin;
	private InterfazPrincipal padre;
	private PanelAdminCentro panelAdminCentro;
	
	
	public VentanaAdmin(InterfazPrincipal papa) {
		padre = papa;
		this.panelAdmin = new PanelAdmin(this);
		this.panelAdminCentro = new PanelAdminCentro(this);
		
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(700, 300));
		setResizable(false);
		setVisible(true);
		
		setLayout(new BorderLayout());
		add(panelAdmin, BorderLayout.NORTH);
		add(panelAdminCentro, BorderLayout.CENTER);
	}
	public InterfazPrincipal getInterfaz() {
		return this.padre;
	}
	
	public void configurarTemporada() {
		String pathJugadores = panelAdminCentro.getTfArchivoInfoJugadores().getText();
		String pathPartidos = panelAdminCentro.getTfArchivoPartidos().getText();
		
		int resp = padre.cargarConfiguracionTemp(pathJugadores, pathPartidos);
	}
	public void configurarResultadosPartido() {
		String pathPartido = panelAdminCentro.getTfArchivoDatosPartido().getText();
		
		int resp = padre.cargarResulPartido(pathPartido);
	}
	public void cerrarSesion() {
		this.padre.cerrarSesionAdmin();
	}
	public void borrarTemporada() {
		this.padre.borrarTemporada();
	}
}
