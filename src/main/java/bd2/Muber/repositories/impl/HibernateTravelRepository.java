package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.TravelDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Travel;
import bd2.Muber.repositories.TravelRepository;

public class HibernateTravelRepository extends BaseHibernateRepository implements TravelRepository {

    @Override
    public List<TravelDTO> getTravels() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public TravelDTO getTravel(long id){
	Session session = this.getSession();
	String hql = "FROM bd2.Muber.model.Travel T WHERE T.idTravel = ?";
	Query query = session.createQuery(hql);
	query.setParameter(0, id);
	Travel result = (Travel) query.uniqueResult();

	TravelDTO travelDTO = new TravelDTO();
	if (result != null){
	    travelDTO = new TravelDTO(result);
	}
	session.disconnect();
	session.close();
	return travelDTO;
    }

    @Override
    public TravelDTO saveTravel(long idDriver, String origin, String destiny, int maxPassengers, float totalCost) {
	Session session = this.getSession();

	String hql = "FROM bd2.Muber.model.Driver P WHERE P.idUser = ?";
	Query query = session.createQuery(hql);
	query.setParameter(0, idDriver);
	Driver aDriver = (Driver) query.uniqueResult();

	Travel aTravel = new Travel(aDriver, origin, destiny, maxPassengers, totalCost);
	session.save(aTravel);

	TravelDTO aTravelDTO = new TravelDTO(aTravel);
	;
	session.disconnect();
	session.close();
	return aTravelDTO;
    }

    @Override
    public boolean addPassengerToTravel(long travelId, long passengerId) {
	Session session = this.getSession();

	String hql = "FROM bd2.Muber.model.Passenger P WHERE P.idUser = ?";
	Query query = session.createQuery(hql);
	query.setParameter(0, passengerId);
	Passenger aPassenger = (Passenger) query.uniqueResult();

	String hql1 = "FROM bd2.Muber.model.Travel T WHERE T.idTravel = ?";
	Query query1 = session.createQuery(hql1);
	query1.setParameter(0, travelId);
	Travel aTravel = (Travel) query1.uniqueResult();

	if (aTravel.addPassenger(aPassenger)){
	    session.saveOrUpdate(aTravel);
	    session.disconnect();
	    session.close();
	    return true;
	}else{
	    session.disconnect();
	    session.close();
	    return false;
	}
    }

    @Override
    public boolean finalizeTravel(long travelId) {
	Session session = this.getSession();

	String hql1 = "FROM bd2.Muber.model.Travel T WHERE T.idTravel = ?";
	Query query1 = session.createQuery(hql1);
	query1.setParameter(0, travelId);
	Travel aTravel = (Travel) query1.uniqueResult();

	aTravel.finalize();
	session.saveOrUpdate(aTravel);
	session.close();
	return true;
    }

    @Override
    public List<TravelDTO> getFinalizedTravels() {
	Session session = this.getSession();

	String hql = "FROM bd2.Muber.model.Travel p WHERE p.finalized=true ";
	Query query = session.createQuery(hql);
	List<Travel> result = query.list();

	List<TravelDTO> travelsDTO = new ArrayList<TravelDTO>();
	for (Travel t : result) {
	    TravelDTO travel = new TravelDTO(t);
	    travelsDTO.add(travel);
	}
	session.disconnect();
	session.close();
	return travelsDTO;
    }

    @Override
    public List<TravelDTO> getOpenedTravels() {
	Session session = this.getSession();	
	String hql = "FROM bd2.Muber.model.Travel p WHERE p.finalized=false ";
	Query query = session.createQuery(hql);
	List<Travel> result = query.list();

	List<TravelDTO> travelsDTO = new ArrayList<TravelDTO>();
	for (Travel t : result) {
	    TravelDTO travel = new TravelDTO(t);
	    travelsDTO.add(travel);
	}
	session.disconnect();
	session.close();
	return travelsDTO;
    }
}
