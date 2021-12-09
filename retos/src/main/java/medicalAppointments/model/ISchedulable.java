package medicalAppointments.model;

import java.util.Date;

public interface ISchedulable {
	
	void schedule(Date date, String time);
	
}
