package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.DriverDTO;

public interface DriverService {
	
	DriverDTO findById(long id);
	List<DriverDTO> findAllDrivers();
	List<DriverDTO> getDriversTop10();
	public void cargarDatos();
	public List<DriverDTO> getTop10DriversWithoutOpenTravels();
}
