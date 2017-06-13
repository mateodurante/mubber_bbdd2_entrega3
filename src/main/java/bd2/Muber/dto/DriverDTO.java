package bd2.Muber.dto;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Qualification;
import bd2.Muber.model.Travel;
import java.util.Date;
import java.util.Set;

public class DriverDTO extends UserDTO {
	private Long idDriver;
	private Date licenceExpiration;
	private Set<Travel> travels;
	private Set<Qualification> qualifications;
	
	public DriverDTO(){
	}

	public DriverDTO(Driver aDriver){
		super(aDriver);
		this.setLicenceExpiration(aDriver.getLicenceExpiration());
		this.setTravels(aDriver.getTravels());
		this.setQualifications(aDriver.getQualifications());
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
