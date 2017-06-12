package bd2.Muber.repositories;
import java.util.List;

import bd2.Muber.dto.TravelDTO;

public interface TravelRepository extends BaseRepository {

	List<TravelDTO> getTravels();
	TravelDTO getTravel(Long id);
	boolean saveTravel(Long idDriver, String origin, String destiny, int maxPassengers, float totalCost);
	boolean addPassengerToTravel(Long travelId, Long passengerId);
	boolean finalizeTravel(Long travelId);
	List<TravelDTO> getFinalizedTravels();
	List<TravelDTO> getOpenedTravels();

}
