package gatos.app;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Inicio {
	
	public static void main(String[] args) throws IOException {
		
		int opcionMenu = -1;
		String[] botones = new String[] {"1. Ver gatos", "2. Ver favorito", "3. Salir"};
		
		do {
			// menu principal
			String opcion = (String) JOptionPane.showInputDialog(null, "Gatito Java", "Menu Principal", JOptionPane.INFORMATION_MESSAGE,
					null, botones, botones[0]);
			
			// validamos que opcion selecciona el usuario
			for (int i = 0; i < botones.length; i++) {
				if (opcion.equals(botones[i])) {
					opcionMenu = i;
				}
			}
			
			switch (opcionMenu) {
			case 0:
				GatosService.verGatos();
				break;
			case 1:
				Gatos gato = new Gatos();
				GatosService.verFavorito(gato.getApiKey());
			default:
				break;
			}
			
		} while (opcionMenu != 1);
		
	}
	
}
