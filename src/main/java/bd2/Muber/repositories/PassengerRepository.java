package bd2.Muber.repositories;

import java.util.List;

import bd2.Muber.dto.PassengerDTO;

public interface PassengerRepository extends BaseRepository {
	
	PassengerDTO getPassenger(long passengerId);
	List<PassengerDTO> getPassengers();
	PassengerDTO updateTotalCredit(long passengerId, float amount);
	
}
