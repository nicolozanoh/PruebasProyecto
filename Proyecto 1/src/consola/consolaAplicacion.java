package consola;
import procesamiento.Aplicacion;
import com.fasterxml.jackson.core.JsonParseException;        
import com.fasterxml.jackson.databind.JsonMappingException; 
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;          
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import modelo.Administrador;
import modelo.Participante;


public class consolaAplicacion {
    private Aplicacion aplicacion;

    public void ejecutarAplicacion(){
    	int respInicioSesion;
    	int respCrearCuenta;
    	int opcionSeleccionada;
    	aplicacion = new Aplicacion();
    	cargarDataActual();
    	boolean iniciarAplicacion = true;
    	boolean sesionIniciada = false;
    	while(iniciarAplicacion) {
    		menuInicio();
    		opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
    		if (opcionSeleccionada == 1) {
    			respInicioSesion = ejecutarIniciarSesion();
    			if(respInicioSesion == 0) {
    				sesionIniciada = true;
    			}
    		}
    		if (opcionSeleccionada == 2) {
    			respCrearCuenta = ejecutarCrearCuenta();
    			if (respCrearCuenta == 0) {
    				sesionIniciada =true;
    			}
    		}
    		if (opcionSeleccionada == 0) {
    			
    		}
    		while(sesionIniciada) {
    			if (aplicacion.getUsuarioActivo().getClass().getName() == "modelo.Administrador") {
    				menuAdmin();
    				opcionSeleccionada =Integer.parseInt(input("Por favor seleccione una opción"));
    				if(opcionSeleccionada == 1){}
    				if(opcionSeleccionada == 2){}
    				if(opcionSeleccionada == 0){
    					ejecutarCerrarSesion();
    					sesionIniciada = false;
    				}
    			}
    			
    			if (aplicacion.getUsuarioActivo().getClass().getName() ==  "modelo.Participante") {
    				menuParticipante();
    				opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
    				if(opcionSeleccionada == 1){
    					ejecutarCrearEquipo();
    				}
    				if(opcionSeleccionada == 2){
    					ejecutarBorrarEquipo();
    				}
    				if(opcionSeleccionada == 0){
    					ejecutarCerrarSesion();
    					sesionIniciada = false;
    				}
    			}
    		}
    	}
    }
//    private void cargarEquipoParticipanteActivo() {
//    	this.aplicacion.cargarEquipoParticipanteActivo();
//    }
    private void cargarDataActual(){
        aplicacion.ejecutarCargarParticipantes();
        aplicacion.ejecutarCargarAdministrador();
        aplicacion.ejecutarCargarTemporadaActual();
    }
    private int ejecutarIniciarSesion() {
    	String nombreUsuario = input("Ingrese su nombre de usuario");
    	String contraseña = input("Ingrese su contraseña");
    	int resp = aplicacion.iniciarSesion(nombreUsuario, contraseña);
    	
    	if (resp == 0) {
    		System.out.println("Inicio de sesión exitoso!\n" + "Bienvenido " + aplicacion.getUsuarioActivo().getNombreUsuario() + "!");	
    	}
    	if (resp == 2) {
    		System.out.println("Error al iniciar sesión: El nombre de usuario no existe.");
    	}
    	if (resp == 1) {
    		System.out.println("Error al iniciar sesión: La contraseña no es correcta.");
    	}
    	return resp;
    }
    private int ejecutarCrearCuenta() {
    	String nombreUsuario = input("Ingrese un nombre de usuario");
    	String contraseña = input("Ingrese una contraseña");
    	int resp = aplicacion.crearCuenta(nombreUsuario, contraseña);
    	if(resp == 0) {
    		System.out.println("Su usuario se ha creado exitosamente!");
    		aplicacion.iniciarSesion(nombreUsuario, contraseña);
    	}
    	if(resp == 1) {
    		System.out.println("El nombre de usuario seleccionado ya esta en uso, seleccione otro y vuelva a intentarlo");
    	}
    	return resp;
    }
    private void ejecutarCerrarSesion() {
    	
    }
    private void menuInicio(){
    	System.out.println("1) Iniciar Sesión");
    	System.out.println("2) Crear Usuario");
    	System.out.println("0) Cerrar Aplicación");
    }
    private void ejecutarCrearEquipo() {
    	double presupuestoInicial = ((Participante)(this.aplicacion.getUsuarioActivo())).getPresupuesto();
    	mostrarJugadores();
    	System.out.println("Seleccione los jugadores que quiere que hagan parte de su equipo./n Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	System.out.println("Recuerde, usted tiene un presupuesto de: " + presupuestoInicial);
    	String[] jugadoresSeleccionados = input("\nSeleccione el número de todos los jugadores que quiere agregar, separados por comas (',').").trim().split(",");
    	
    	int resp = aplicacion.crearEquipo(jugadoresSeleccionados);
    	if(resp==0) {
    		System.out.println("Su equipo ha sido creado con los siguientes jugadores: ");
    		int cont = 1;
        	for (int i = 0; i < ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getJugadores().size(); i++) {
        		System.out.println(Integer.toString(cont) + ". Nombre: " + ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getJugadores().get(i).getNombre() + ", Posición: " + ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getJugadores().get(i).getPosicion());
        		cont++;
        	}
        	System.out.println("Su nuevo saldo es de $"+((Participante)(this.aplicacion.getUsuarioActivo())).getPresupuesto());
        	System.out.println("¿Desea guardar su equipo?");
        	System.out.println("1) Si");
        	System.out.println("2) No");
        	int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
        	if (opcionSeleccionada == 1) {
        		aplicacion.guardarEquipo();
        	}
        	if(opcionSeleccionada == 2) {
        		System.out.println("Está acción no se puede deshacer, ¿Está seguro de que desea continuar?");
        		menuConfirmarBorrar();
        		opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
        		if(opcionSeleccionada == 1) {
	        		int respBorrar = aplicacion.borrarEquipo();
	        		if (respBorrar== 0) {
	        			System.out.println("Su equipo ha sido eliminado");
	        		}else {
	        			System.out.println("Hubo un error al eliminar su equipo, por favor vuelva a intentarlo.");
	        		}
        		}
        	}
    	}
    	else if(resp==1) {
    		System.out.println("Error: Ya existe un equipo, para crear un nuevo equipo, elimine el equipo anterior. También puede modificar el equipo existente.");
    	}
    	else if(resp==2) {
    		System.out.println("Error: Numero de arqueros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==3) {
    		System.out.println("Error: Numero de defensas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==4) {
    		System.out.println("Error: Numero de mediocampistas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==5) {
    		System.out.println("Error: Numero de delanteros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==6) {
    		System.out.println("Error: Ya existe un equipo, para crear un nuevo equipo, elimine el equipo anterior. También puede modificar el equipo existente.");
    	}
    	else if(resp==7) {
    		System.out.println("Error: Debe seleccionar 15 jugadores para crear el equipo.");
    	}
    }
    
    private void ejecutarBorrarEquipo() {
    	this.aplicacion.borrarEquipo();
    }
    
    private void menuAdmin(){
    	System.out.println("1) Cargar información temporada");
    	System.out.println("2) Cargar información jornada");
    	System.out.println("0) Cerrar sesión");
    }
    
    private void menuParticipante() {
    	System.out.println("1) Crear equipo");
    	System.out.println("2) Borrar equipo");
    }
    private void menuConfirmarBorrar() {
    	System.out.println("1) Si");
    	System.out.println("1) No");
    }
    
    public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
    
    public void mostrarJugadores() {
    	int cont = 1;
    	for (int i = 0; i < this.aplicacion.getTemporada().getJugadores().size(); i++) {
    		System.out.println(Integer.toString(cont) + ". Nombre: " + this.aplicacion.getTemporada().getJugadores().get(i).getNombre() + ", Posición: " + this.aplicacion.getTemporada().getJugadores().get(i).getPosicion() + ", Precio: " + Double.toString(this.aplicacion.getTemporada().getJugadores().get(i).getPrecio()));
    		cont++;
    	}
    }

    public static void main(String[] args)
	{
		consolaAplicacion consola = new consolaAplicacion();
        consola.ejecutarAplicacion();
	}
}
