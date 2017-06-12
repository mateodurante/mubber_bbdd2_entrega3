package bd2.Muber.dto;

import java.util.Date;

import bd2.Muber.model.User;

public abstract class UserDTO {
	private Long idUser;
	private String username;
	private String password;
	private Date admissionDate;
	
	public UserDTO() {
	}
	
	public UserDTO(User anUser){
		this.setIdUser(anUser.getIdUser());
		this.setUsername(anUser.getUsername());
		this.setPassword(anUser.getPassword());		
		this.setAdmissionDate(anUser.getAdmissionDate());
	}

	public Long getIdUser() {
		return idUser;
	}
	
	private void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
}
