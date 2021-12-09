package medicalAppointments;

import java.util.Date;

import medicalAppointments.model.Doctor;
import medicalAppointments.model.Patient;
import medicalAppointments.model.User;
import medicalAppointments.ui.UIMenu;

//import static medicalAppointments.ui.UIMenu.*;

public class Main {
	
	public static void main(String[] args) {
		
		UIMenu.showMenu();
		
		/*
		Doctor myDoctor = new Doctor("Joel Guzman", "joel-guzman@hotmail.com");
		
		myDoctor.addAvailableAppointment(new Date(), "4pm");
		myDoctor.addAvailableAppointment(new Date(), "10am");
		myDoctor.addAvailableAppointment(new Date(), "1pm");
		
		System.out.println(myDoctor);
		
		User user = new Doctor("Joel David", "joel@joel.com");
		user.showDataUser();
		
		User patient = new Patient("Joel", "Guzman@gmail.com");
		patient.showDataUser();
		
		
		/*
		for (Doctor.AvailableAppointment aA : myDoctor.getAvailableAppointments() ) {
			
			System.out.println(aA.getDate() + " " + aA.getTime());
		}
		
		System.out.println();
		System.out.println();
		Patient patient = new Patient("Alejandra", "alejandra@mail.com");
		
		System.out.println(patient);
		*/
	}
	

}
