package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.dto.TravelDTO;
import bd2.Muber.services.TravelService;

public class TravelServiceImpl extends BaseServiceImpl implements TravelService {

	@Override
	public TravelDTO findById(Long id) {
		return travelRepository.getTravel(id);
	}

	@Override
	public List<TravelDTO> findFinalizedTravels() {
		return travelRepository.getFinalizedTravels();
	}

	@Override
	public boolean addPassengerToTravel(Long travelId, Long passengerId) {
		return travelRepository.addPassengerToTravel(travelId, passengerId);
	}

	@Override
	public boolean finalizeTravel(Long travelId) {
		return travelRepository.finalizeTravel(travelId);
	}

	@Override
	public boolean saveTravel(Long idDriver, String origin, String destiny, int maxPassengers, float totalCost) {
		return travelRepository.saveTravel(idDriver, origin, destiny, maxPassengers, totalCost);
	}

	@Override
	public List<TravelDTO> findOpenedTravels() {
		return travelRepository.getOpenedTravels();
	}

}
