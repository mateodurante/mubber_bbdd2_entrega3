package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.dto.TravelDTO;
import bd2.Muber.services.TravelService;

public class TravelServiceImpl extends BaseServiceImpl implements TravelService {

	@Override
	public TravelDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TravelDTO> findAllClosedTravels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTravel(Long travelId, Long passengerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String closeTravel(Long travelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveTravel(Long idDriver, String origin, String destiny, int maxPassengers, float totalCost) {
		// TODO Auto-generated method stub
		return false;
	}

}
