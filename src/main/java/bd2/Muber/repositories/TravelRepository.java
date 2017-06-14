package bd2.Muber.repositories;
import java.util.List;

import bd2.Muber.dto.TravelDTO;

public interface TravelRepository extends BaseRepository {

	List<TravelDTO> getTravels();
	TravelDTO getTravel(long id);
	TravelDTO saveTravel(long idDriver, String origin, String destiny, int maxPassengers, float totalCost);
	boolean addPassengerToTravel(long travelId, long passengerId);
	boolean finalizeTravel(long travelId);
	List<TravelDTO> getFinalizedTravels();
	List<TravelDTO> getOpenedTravels();

}
