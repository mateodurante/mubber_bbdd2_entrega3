package bd2.Muber.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.TravelDTO;
import bd2.Muber.model.Travel;
import bd2.Muber.repositories.TravelRepository;

public class HibernateTravelRepository extends BaseHibernateRepository implements TravelRepository {

	@Override
	public List<TravelDTO> getTravels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TravelDTO getTravel(Long id){
		Session session = this.getSession();	
		Transaction tx = null;
		tx = session.beginTransaction();
		String hql = "FROM bd2.Muber.model.Travel T WHERE T.idTravel = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		Travel result = (Travel) query.uniqueResult();
		
		TravelDTO travelDTO = new TravelDTO();
		if (result != null){
			travelDTO = new TravelDTO(result);
		}
		tx.rollback();
		session.disconnect();
		session.close();
		return travelDTO;
	}

	@Override
	public Boolean saveTravel(Long idDriver, String origin, String destiny, int maxPassengers, float totalCost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addPassengerToTravel(Long travelId, Long passengerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String closeTravel(Long travelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TravelDTO> getFinalizedTravels() {
		// TODO Auto-generated method stub
		return null;
	}
}
