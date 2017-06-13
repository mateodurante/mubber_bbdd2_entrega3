package bd2.Muber.dto;

import java.util.Set;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Travel;

public class PassengerDTO extends UserDTO {
	private Long idPassenger;
	private float totalCredit;
	private Set<Travel> travels;
	
	public PassengerDTO(){
	}
	
	public PassengerDTO(Passenger aPassenger) {
		super(aPassenger);
		this.setTotalCredit(aPassenger.getTotalCredit());
		this.setTravels(aPassenger.getTravels());
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
