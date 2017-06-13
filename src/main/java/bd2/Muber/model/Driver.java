package bd2.Muber.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Driver extends User {
	private Long idDriver;
	private Date licenceExpiration;
	private Set<Travel> travels;
	private Set<Qualification> qualifications;
	
	public Driver(){
	}
	
	public Driver(String username, String password, Date licenceExpiration) {
		super(username, password);
		this.travels = new HashSet<Travel>();
		this.qualifications = new HashSet<Qualification>();
		this.licenceExpiration = licenceExpiration;
	}
	
	public Float getQualificationAverange() {
		int tot = 0;
		for (Qualification q : this.qualifications) {
			tot += q.getPoints();
		}
		if (this.getQualifications().isEmpty()){
			return (float) tot;
		}
		return (float) (tot / this.qualifications.size());
	}

	public Float getBestQualificationPoints() {
		int topPoints = 0;
		for (Qualification q : this.qualifications) {
			if (topPoints < q.getPoints()){
				topPoints = q.getPoints();
			}
		}
		return (float) topPoints;
	}

	public Travel createTravel(String origin, String destiny, int passengers, float cost) {
		if (this.licenceExpiration.before(new Date()))
			return null;
		Travel t = new Travel(this, origin, destiny, passengers, cost);
		this.travels.add(t);
		return t;
	}
	
	public void addTravel(Travel travel) {
		this.getTravels().add(travel);
	}

	public void addQualification(Qualification qualification) {
		this.qualifications.add(qualification);
	}
	
	public boolean hasOpenTravels() {
		for (Travel currentTravel : this.travels){
			if (!currentTravel.isFinalized())
				return true;
		}
		return false;
	}

	public Long getIdDriver() {
		return idDriver;
	}

	private void setIdDriver(Long idDriver) {
		this.idDriver = idDriver;
	}

	public Set<Travel> getTravels() {
		return travels;
	}

	public void setTravels(Set<Travel> travels) {
		this.travels = travels;
	}
	
	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	
	public Date getLicenceExpiration() {
		return licenceExpiration;
	}

	public void setLicenceExpiration(Date licenceExpiration) {
		this.licenceExpiration = licenceExpiration;
	}
}
