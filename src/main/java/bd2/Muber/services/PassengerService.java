package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.PassengerDTO;

public interface PassengerService {
	
	PassengerDTO findById(Long id);
	List<PassengerDTO> findAllPassengers();
	void savePassenger(PassengerDTO aPassenger);
	void updatePassenger(PassengerDTO aPassenger);
	void updateTotalCredit(Long passengerId, float amount);

}
