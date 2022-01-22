package amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	/**
	 * Este metodo captura el tiempo exacto de inicio de visualizacion
	 * @param dateI Es un objecto {@code Date} con el tiempo de inicio Exacto
	 * @return Devuelve la fecha y hora capturada
	 */
	public Date startToSee(Date dateI);
	
	/**
	 * Este metodo captura el tiempo exacto de inicio y final de visualizacion
	 * 
	 * @param dateI
	 * @param dateF
	 */
	public void stopToSee(Date dateI, Date dateF);
	
}
