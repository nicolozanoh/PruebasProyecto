package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Participante;

@SuppressWarnings("serial")
public class VentanaUsuario extends JFrame{
	
	private PanelUsuario panelUsuario;
	private PanelUsuarioDerecha panelUsuarioDerecha;
	private PanelUsuarioSuperior panelUsuarioSuperior;
	private PanelUsuarioIzquierda panelUsuarioIzquierda;
	private InterfazPrincipal padre;
	private Participante usuario;
	public VentanaUsuario(InterfazPrincipal papa) {
		padre = papa;
		usuario = (Participante)padre.getAplicacion().getUsuarioActivo();
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
	public Participante getUsuario () {
		return this.usuario;
	}

	public void CambiarAlineacion() {
		ArrayList<String> seleccion = this.panelUsuario.getElementosSeleccionados();
		int resp = this.padre.CambiarAlineacion(seleccion);
		if (resp == 0) {
			this.panelUsuario.actualizarAlineacion();
			this.panelUsuario.borrarSelecciones();
		}
	}

	public void CambiarCapitan() {
		ArrayList<String> seleccion = this.panelUsuario.getElementosSeleccionados();
		int resp = this.padre.cambiarCapitan(seleccion);
		if (resp == 0) {
			this.panelUsuarioDerecha.actualizarCapitan();
			this.panelUsuario.borrarSelecciones();
		}
	}

	public void venderJugador() {
		ArrayList<String> seleccion = this.panelUsuario.getElementosSeleccionados();
		int resp = this.padre.venderJugador(seleccion);
		if(resp == 0) {
			this.panelUsuario.actualizarAlineacion();
			this.panelUsuario.borrarSelecciones();
			this.panelUsuarioDerecha.actualizarPresupuesto();
		}
	}
	public void actualizarVentana() {
		this.panelUsuario.actualizarAlineacion();
		this.panelUsuarioDerecha.actualizarPresupuesto();
	}
	public void comprarJugador() {
		this.padre.abrirComprarJugador();
		//vComprar = new VentanaComprar(this);
	}

	public void verEstadisticas() {
		// TODO Auto-generated method stub
		this.padre.verEtadisticas();
		
	}

	public void cerrarSesion() {
		this.padre.cerrarSesionUsuario();
	}
	public void borrarEquipo() {
		this.padre.borrarEquipo();
	}
}
