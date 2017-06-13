package bd2.Muber.dto;

import java.util.Date;
import java.util.Set;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Travel;

public class TravelDTO {
	private Long idTravel;
	private String destiny;
	private String origin;
	private float totalCost;
	private Date date;
	private int maxPassengers;
	private boolean finalized;
	private Set<Passenger> passengers;
	private DriverDTO driver;
	
	public TravelDTO(){
	}
	
	public TravelDTO(Travel aTravel) {
		this.setIdTravel(aTravel.getIdTravel());
		this.setDestiny(aTravel.getDestiny());
		this.setOrigin(aTravel.getOrigin());
		this.setTotalCost(aTravel.getTotalCost());
		this.setDate(aTravel.getDate());
		this.setMaxPassengers(aTravel.getMaxPassengers());
		this.setFinalized(aTravel.isFinalized());
		this.setPassengers(aTravel.getPassengers());
		this.setDriver(aTravel.getDriver());
	}
	
	public Long getIdTravel() {
		return idTravel;
	}
	
	private void setIdTravel(Long idTravel) {
		this.idTravel = idTravel;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public boolean isFinalized() {
		return finalized;
	}
	
	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}
	
	public Set<Passenger> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public DriverDTO getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		this.driver = new DriverDTO(driver);
	}
}
