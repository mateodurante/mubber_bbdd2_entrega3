package bd2.Muber.dto;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Qualification;
import bd2.Muber.model.Travel;

public class QualificationDTO {
	private Long idQualification;
	private int points;
	private String comment;
	private PassengerDTO passenger;
	private TravelDTO travel;
	
	public QualificationDTO(){
	}
	
	public QualificationDTO(Qualification aQualification) {
		this.setIdQualification(aQualification.getIdQualification());
		this.setComment(aQualification.getComment());
		this.setPassenger(aQualification.getPassenger());
		this.setTravel(aQualification.getTravel());
		this.setPoints(aQualification.getPoints());
	}

	public Long getIdQualification() {
		return idQualification;
	}
	
	private void setIdQualification(Long idQualification) {
		this.idQualification = idQualification;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public PassengerDTO getPassenger() {
		return passenger;
	}
	
	public void setPassenger(Passenger passenger) {
		this.passenger = new PassengerDTO(passenger);
	}
	
	public TravelDTO getTravel() {
		return travel;
	}
	
	public void setTravel(Travel travel) {
		this.travel = new TravelDTO(travel);
	}
}
