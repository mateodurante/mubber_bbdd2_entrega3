package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Qualification;
import bd2.Muber.model.Travel;
import bd2.Muber.repositories.PassengerRepository;

public class HibernatePassengerRepository extends BaseHibernateRepository implements PassengerRepository {

	@Override
	public PassengerDTO getPassenger(long passengerId) {
		Session session = this.getSession();
		String hql = "FROM bd2.Muber.model.Passenger P WHERE P.idUser = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, passengerId);
		Passenger result = (Passenger) query.uniqueResult();
		PassengerDTO passengerDTO = new PassengerDTO();
		if (result != null){
			passengerDTO = new PassengerDTO(result);
		}
		session.disconnect();
		session.close();
		return passengerDTO;
	}

	@Override
	public List<PassengerDTO> getPassengers() {
		Session session = this.getSession();
		String hql = "FROM bd2.Muber.model.Passenger";
		Query query = session.createQuery(hql);
		List<Passenger> passengers = query.list();
		List<PassengerDTO> passengerDTO = new ArrayList<PassengerDTO>();
		for (Passenger p : passengers) {
			PassengerDTO pas = new PassengerDTO(p);
			passengerDTO.add(pas);
		}
		session.disconnect();
		session.close();		
		return passengerDTO;
	}

	@Override
	public PassengerDTO updateTotalCredit(long passengerId, float amount) {
		Session session = this.getSession();
		
		String hql = "FROM bd2.Muber.model.Passenger P WHERE P.idUser = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, passengerId);
		Passenger aPassenger = (Passenger) query.uniqueResult();
		
		if (aPassenger == null){
			return null;
		}
		
		session.saveOrUpdate(aPassenger);
		aPassenger.addCredit(amount);
		session.disconnect();
		session.close();
		
		return new PassengerDTO(aPassenger);
	}
}
