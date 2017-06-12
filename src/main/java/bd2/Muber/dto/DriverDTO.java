package bd2.Muber.dto;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Qualification;
import bd2.Muber.model.Travel;
import java.util.Date;
import java.util.List;

public class DriverDTO extends UserDTO {
	private Long idDriver;
	private Date licenceExpiration;
	private List<Travel> travels;
	private List<Qualification> qualifications;
	
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

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}
	
	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	
	public Date getLicenceExpiration() {
		return licenceExpiration;
	}

	public void setLicenceExpiration(Date licenceExpiration) {
		this.licenceExpiration = licenceExpiration;
	}
}
