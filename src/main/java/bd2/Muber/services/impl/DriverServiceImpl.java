package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.services.DriverService;

public class DriverServiceImpl extends BaseServiceImpl implements DriverService {

	@Override
	public DriverDTO findById(long id) {
		return driverRepository.getDriver(id);
	}

	@Override
	public List<DriverDTO> findAllDrivers() {
		return driverRepository.getDrivers();
	}

	@Override
	public List<DriverDTO> getDriversTop10() {
		return driverRepository.getDriversTop10();
	}

	@Override
	public void cargarDatos() {
		driverRepository.cargarDatos();
	}

	@Override
	public List<DriverDTO> getTop10DriversWithoutOpenTravels() {
	    return driverRepository.getTop10DriversWithoutOpenTravels();
	}

}
