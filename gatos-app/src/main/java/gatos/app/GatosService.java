package gatos.app;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class GatosService {
	
	public static void verGatos() throws IOException {
		// 1. vamos a traer los datos de la API
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search?").get().build();
		Response response = client.newCall(request).execute();
		
		String elJSON = response.body().string();
		
		// Cortar los corchetes
		elJSON = elJSON.substring(1, elJSON.length());
		elJSON = elJSON.substring(0, elJSON.length()-1);
		
		// crear un objeto de la clase Gson
		
		Gson gson = new Gson();
		Gatos gatos = gson.fromJson(elJSON, Gatos.class);
		
		// redimensionar en caso de necesitar
		Image image = null;
		try {
			URL url = new URL(gatos.getUrl());
			image = ImageIO.read(url);
			
			ImageIcon fondoGato = new ImageIcon(image);
			
			if (fondoGato.getIconWidth() > 800 || fondoGato.getIconHeight() > 800) {
				//redimensionamos
				Image fondo = fondoGato.getImage();
				Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
				fondoGato = new ImageIcon(modificada);
			}
			
			String menu = "Opciones: \n"
					+ "1. Ver otra imagen \n"
					+ "2. Favorito \n"
					+ "2. Volver al menu \n";
			
			String[] botones = new String[] {"Ver otra imagen", "Favorito", "Volver"};
			String idGato = gatos.getId();
			String opcion = (String) JOptionPane.showInputDialog(null, menu, idGato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);
			
			int seleccion = -1;
			
			for (int i = 0; i < botones.length; i++) {
				if (opcion.equals(botones[i])) {
					seleccion = i;
				}
			}
			
			switch (seleccion) {
			case 0:
				verGatos();				
				break;
			case 2:
				favoritoGatos(gatos);
				break;
			default:
				break;
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void favoritoGatos(Gatos gato) {
		try {
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\r\n  \"image_id\": \""+gato.getId()+"\"\r\n}");
			Request request = new Request.Builder().url("https://api.thecatapi.com/v1/favourites").method("POST", body).addHeader("Content-Type", "application/json").addHeader("x-api-key", gato.getApiKey()).build();
			Response response = client.newCall(request).execute();
			
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void verFavorito(String apiKey) throws IOException {
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("https://api.thecatapi.com/v1/favourites").method("GET", null).addHeader("x-api-key", apiKey).build();
		Response response = client.newCall(request).execute();
		
		// guardamos el string con la respuesta
		String elJSON = response.body().string();
		
		//creamos el objeto gson
		Gson gson = new Gson();
		
		GatosFav[] gatosArray = gson.fromJson(elJSON, GatosFav[].class);
		
		if (gatosArray.length > 0) {
			int min = 1;
			int max = gatosArray.length;
			int aleatorio = (int) Math.random()*((max - min) + 1) + min ;
			int indice = aleatorio - 1;
			
			GatosFav gatoFav = gatosArray[indice];
			
			// redimensionar en caso de necesitar
			Image image = null;
			try {
				URL url = new URL(gatoFav.getImage().getUrl());
				image = ImageIO.read(url);
				
				ImageIcon fondoGato = new ImageIcon(image);
				
				if (fondoGato.getIconWidth() > 800 || fondoGato.getIconHeight() > 800) {
					//redimensionamos
					Image fondo = fondoGato.getImage();
					Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
					fondoGato = new ImageIcon(modificada);
				}
				
				String menu = "Opciones: \n"
						+ "1. Ver otra imagen \n"
						+ "2. Eliminar Favorito \n"
						+ "2. Volver al menu \n";
				
				String[] botones = new String[] {"Ver otra imagen", "Eliminar Favorito", "Volver"};
				String idGato = gatoFav.getId();
				String opcion = (String) JOptionPane.showInputDialog(null, menu, idGato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);
				
				int seleccion = -1;
				
				for (int i = 0; i < botones.length; i++) {
					if (opcion.equals(botones[i])) {
						seleccion = i;
					}
				}
				
				switch (seleccion) {
				case 0:
					verFavorito(apiKey);				
					break;
				case 2:
					borrarFavoritoGatos(gatoFav);
					break;
				default:
					break;
				}
				
			} catch (IOException e) {
				System.out.println(e);
			}
			
		}
		
		
		
	}

	private static void borrarFavoritoGatos(GatosFav gatoFav) {
		
		try {
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody body = RequestBody.create(mediaType, "");
			Request request = new Request.Builder()
			  .url("https://api.thecatapi.com/v1/favourites/"+ gatoFav.getId()+"")
			  .method("DELETE", body)
			  .addHeader("x-api-key", gatoFav.getApiKey())
			  .build();
			Response response = client.newCall(request).execute();
					
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
}
