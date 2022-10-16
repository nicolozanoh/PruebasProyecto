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
    			if (aplicacion.getUsuarioActivo().getClass().getName()==  "modelo.Administrador") {
    				menuAdmin();
    				opcionSeleccionada =Integer.parseInt(input("Por favor seleccione una opción"));
    				if(opcionSeleccionada == 1){}
    				if(opcionSeleccionada == 2){}
    				if(opcionSeleccionada == 0){
    					ejecutarCerrarSesion();
    					sesionIniciada = false;
    				}
    			}
    			
    			if (aplicacion.getUsuarioActivo().getClass().getName()==  "modelo.Participante") {
    				menuParticipante();
    				opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
    				if(opcionSeleccionada == 1){}
    				if(opcionSeleccionada == 2){}
    				if(opcionSeleccionada == 0){
    					ejecutarCerrarSesion();
    					sesionIniciada = false;
    				}
    			}
    		}
    	}
    }

    private void cargarDataActual(){
        aplicacion.ejecutarCargarParticipantes();
        aplicacion.ejecutarCargarAdministrador();
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
    
    private void menuAdmin(){
    	System.out.println("1) Cargar información temporada");
    	System.out.println("2) Cargar información jornada");
    	System.out.println("0) Cerrar sesión");
    }
    
    private void menuParticipante() {
    	
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

    public static void main(String[] args)
	{
		consolaAplicacion consola = new consolaAplicacion();
        consola.ejecutarAplicacion();
	}
}
