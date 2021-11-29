package medicalAppointments;

public class Doctor {
	
	//atributos
	
	static int id;
	String name;
	String email;
	String speciality;
	
	Doctor(){
		System.out.println("Construyecndo el Objecto Doctor");
	}
	
	Doctor(String name, String speciality){
		System.out.println("El nombre del doctor asignado es: " + name);
		id++;
		this.name = name;
		this.speciality = speciality;
	}
	
	//comportamientos
	
	public void showName() {
		System.out.println(name);
	}
	
	public void showId() {
		System.out.println("ID Doctor: " + id);
	}
	
}
