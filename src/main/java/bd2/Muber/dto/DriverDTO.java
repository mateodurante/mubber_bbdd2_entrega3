package bd2.Muber.dto;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Qualification;
import bd2.Muber.model.Travel;
import javassist.bytecode.Descriptor.Iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DriverDTO extends UserDTO {
	private Long idDriver;
	private Date licenceExpiration;
	private Set<TravelDTO> travels;
	private Set<Qualification> qualifications;
	private Float qualificationAverage;
	
	public DriverDTO(){
	}

	public DriverDTO(Driver aDriver){
		super(aDriver);
		this.setLicenceExpiration(aDriver.getLicenceExpiration());
		
		Set<TravelDTO> temp = new HashSet<TravelDTO>();
		// Creación de la lista de DTOs:
		for (Travel t: aDriver.getTravels()){
			temp.add(new TravelDTO(t, this));
		}
		this.setTravelsDTO(temp);
		this.setQualifications(aDriver.getQualifications());
		this.setQualificationAverage(this.calculateQualificationAverage());
	}
	
	public DriverDTO(Driver aDriver, TravelDTO aTravel){
		super(aDriver);
		this.setLicenceExpiration(aDriver.getLicenceExpiration());
		Set<TravelDTO> temp = new HashSet<TravelDTO>();
		this.setTravelsDTO(temp);
		this.setQualifications(aDriver.getQualifications());
		this.setQualificationAverage(this.calculateQualificationAverage());
	}
	
	public Long getIdDriver() {
		return idDriver;
	}

	private void setIdDriver(Long idDriver) {
		this.idDriver = idDriver;
	}

	public Set<TravelDTO> getTravelsDTO() {
		return travels;
	}

	public void setTravelsDTO(Set<TravelDTO> travels) {
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
	
	public Float getQualificationAverage(){
		return this.qualificationAverage;
	}

	public void setQualificationAverage(Float qualificationsAverage){
		this.qualificationAverage = qualificationsAverage;
	}
	
	public Float calculateQualificationAverage() {
		Float tot = new Float(0);
		for (Qualification q : this.qualifications) {
			tot += q.getPoints();
		}
		if (this.getQualifications().isEmpty()){
			return tot;
		}
		return (tot / this.qualifications.size());
	}

}
