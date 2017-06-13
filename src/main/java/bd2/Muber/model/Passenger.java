package bd2.Muber.model;

import java.util.HashSet;
import java.util.Set;

public class Passenger extends User {
	private Long idPassenger;
	private float totalCredit;
	private Set<Travel> travels;
	
	public Passenger(){
		super();
	}
	
	public Passenger(String username, String password, float totalCredit) {
		super(username, password);
		this.totalCredit = totalCredit;
		this.travels = new HashSet<Travel>();
	}

	public boolean addTravel(Travel travel) {
		if (travel.addPassenger(this)) {
			this.travels.add(travel);
			return true;
		}
		return false;
	}

	public Qualification qualify(Travel travel, int points, String comment) {
		return new Qualification(points, comment, this, travel);
	}

	public void qualify(Travel travel, Qualification qualification) {
		qualification.setTravel(travel);
		qualification.setPassenger(this);
		travel.getDriver().addQualification(qualification);
	}

	public void charge(float cost) {
		this.totalCredit -= cost;
	}

	public void addCredit(float amount) {
		this.totalCredit += amount;
	}

	public Long getIdPassenger() {
		return idPassenger;
	}

	private void setIdPassenger(Long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public Set<Travel> getTravels() {
		return travels;
	}

	public void setTravels(Set<Travel> travels) {
		this.travels = travels;
	}

	public float getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(float totalCredit) {
		this.totalCredit = totalCredit;
	}
}
