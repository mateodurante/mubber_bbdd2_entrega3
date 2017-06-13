package bd2.Muber.model;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

public class Muber {
	private Long idMuber;
	private Set<Passenger> passengers;
	private Set<Driver> drivers;
	private Set<Travel> travels;

	public Muber() {
		super();
		this.passengers = new HashSet<Passenger>();
		this.drivers = new HashSet<Driver>();
		this.travels = new HashSet<Travel>();
	}
	
	public Muber(Set<Passenger> passengers, Set<Driver> drivers, Set<Travel> travels) {
		super();
		this.passengers = passengers;
		this.drivers = drivers;
		this.travels = travels;
	}
	
	public List<Driver> getTop10DriversWithoutOpenTravels(){
		List<Driver> top10 = new ArrayList<Driver>();
		for (Driver currentDriver : this.drivers){
			if (!currentDriver.hasOpenTravels()){
				top10.add(currentDriver);
			}
		}
		top10.sort(new Comparator<Driver>() {
			public int compare(Driver d1, Driver d2){
				return d2.getQualificationAverange().compareTo(d1.getQualificationAverange());
			}
		});
		
		return (List<Driver>) top10.subList(0, top10.size() > 10? 10 : top10.size() );
	}
	
	public void addDriver(Driver driver){
		this.drivers.add(driver);
	}

	public void addDrivers(Set<Driver> drivers){
		this.drivers.addAll(drivers);
	}
	
	public void addPassenger(Passenger passenger){
		this.passengers.add(passenger);
	}

	public void addPassengers(Set<Passenger> passengers){
		this.passengers.addAll(passengers);
	}
	
	public void addTravel(Travel travel){
		this.travels.add(travel);
	}

	public void addtravels(Set<Travel> travels){
		this.travels.addAll(travels);
	}

	public Long getIdMuber() {
		return idMuber;
	}
	
	private void setIdMuber(Long idMuber) {
		this.idMuber = idMuber;
	}
	
	public Set<Travel> getTravels() {
		return this.travels;
	}
	
	public void setTravels(Set<Travel> travels) {
		this.travels = travels;
	}
	
	public Set<Passenger> getPassengers() {
		return this.passengers;
	}
	
	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public Set<Driver> getDrivers() {
		return this.drivers;
	}
	
	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}
	
}
