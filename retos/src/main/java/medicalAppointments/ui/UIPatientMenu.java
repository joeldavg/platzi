package medicalAppointments.ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import medicalAppointments.model.Doctor;

public class UIPatientMenu {

	public static void showPatientMenu() {
		int response = 0;
		do {
			System.out.println("\n\n");
			System.out.println("Patient");
			System.out.println("Welcome: " + UIMenu.patinetLogged);
			
			System.out.println("1. Book an Appointment");
			System.out.println("2. My Appointments");
			System.out.println("0. Log Out");
			
			Scanner sc = new Scanner(System.in);
			response = Integer.valueOf(sc.nextLine());
			
			switch (response) {
			case 1:
				break;
			case 2:
				break;
			case 0:
				UIMenu.showMenu();
				break;
			
			}
			
		} while (response != 0);
	}
	
	private static void showBookAppointmentMenu() {
		int response = 0;
		do {
			System.out.println(":: Book an appointment");
			System.out.println(":: Select date: ");
			
			//numeracion de la lista de fechas
			//indice de la fecha seleccionada
			//[doctors]
			Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<Integer, Map<Integer, Doctor>>();
			for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
				ArrayList<Doctor.AvailableAppointment> availableAppointments
					= UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
				
			}
			
			
		} while (response != 0);
	}
	
}
