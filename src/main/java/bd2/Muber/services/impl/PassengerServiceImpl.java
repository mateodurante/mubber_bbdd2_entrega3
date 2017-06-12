package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.dto.PassengerDTO;

public class PassengerServiceImpl extends BaseServiceImpl implements bd2.Muber.services.PassengerService {

	@Override
	public PassengerDTO findById(Long id) {
		return passengerRepository.getPassenger(id);
	}

	@Override
	public List<PassengerDTO> findAllPassengers() {
		return passengerRepository.getPassengers();
	}

	@Override
	public void savePassenger(PassengerDTO aPassenger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassenger(PassengerDTO aPassenger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTotalCredit(Long passengerId, float amount) {
		passengerRepository.updateTotalCredit(passengerId, amount);
	}

}
