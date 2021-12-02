package medicalAppointments;

public class Patient extends User {
	
	private String birthday;
	private double weight;
	private double height;
	private String blood;
	
	//constructor
	public Patient(String name, String email) {
		super(name, email);
	}
	
	
	public void setWeight(double weight) {
		this.weight  = weight;
	}
	

	public String getWeight() {
		return this.weight + "kg.";
	}
	
	public String getHeight() {
		return height + "m.";
	}

	public void setHeight(double height) {
		this.height = height;
	}


	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}


	@Override
	public String toString() {
		return super.toString() + " Patient [birthday=" + birthday + ", blood=" + blood + ", getWeight()=" + getWeight() + ", getHeight()="
				+ getHeight() + "]";
	}
	
	
	
	
}
