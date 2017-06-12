package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.TravelDTO;

public interface TravelService {
	
	TravelDTO findById(Long id);
	List<TravelDTO> findFinalizedTravels();
	List<TravelDTO> findOpenedTravels();
	boolean addPassengerToTravel(Long travelId, Long passengerId);
	boolean finalizeTravel (Long travelId);
	boolean saveTravel(Long idDriver, String origin, String destiny, int maxPassengers, float totalCost);

}
