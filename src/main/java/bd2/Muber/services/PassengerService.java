package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.PassengerDTO;

public interface PassengerService {
	
	PassengerDTO findById(long id);
	List<PassengerDTO> findAllPassengers();
	void savePassenger(PassengerDTO aPassenger);
	void updatePassenger(PassengerDTO aPassenger);
	PassengerDTO updateTotalCredit(long passengerId, float amount);

}
