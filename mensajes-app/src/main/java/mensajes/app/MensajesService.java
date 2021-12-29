package mensajes.app;

import java.util.Scanner;

public class MensajesService {
	
	public static void crearMensaje() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresar nuevo mensaje:");
		String mensaje = sc.nextLine();
		
		System.out.println("Autor:");
		String nombre = sc.nextLine();
		
		Mensajes registro = new Mensajes();
		registro.setMensaje(mensaje);
		registro.setAutor_mensaje(nombre);
		
		MensajesDao.crearMensajeDB(registro);
	}
	
	public static void listarMensajes() {
		MensajesDao.leerMensajesDB();
	}
	
	public static void borrarMensaje() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresar el ID del mensaje a borrar:");
		Integer id_mensaje = sc.nextInt();
		MensajesDao.borrarMensajeDB(id_mensaje);
		
	}
	
	public static void editarMensaje() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresar nuevo mensaje:");
		String mensaje = sc.nextLine();
		
		System.out.println("Ingresar el ID del mensaje a editar:");
		int id_mensaje = sc.nextInt();
		
		Mensajes actualizacion = new Mensajes();
		actualizacion.setId_mensaje(id_mensaje);
		actualizacion.setMensaje(mensaje);
		MensajesDao.actualizarMensajeDB(actualizacion);
	}
	
}
