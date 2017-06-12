package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.repositories.DriverRepository;

public class HibernateDriverRepository extends BaseHibernateRepository implements DriverRepository {

	@Override
	public DriverDTO getDriver(Long driverId) {
		Session session = this.getSession();	
		Transaction tx = null;
		tx = session.beginTransaction();
		
		String hql = "FROM bd2.Muber.model.Driver P WHERE P.idUser = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, driverId);
		Driver result =(Driver) query.uniqueResult();
		
		DriverDTO driverDTO = new DriverDTO();
		if (result != null){
			driverDTO = new DriverDTO(result);
		}
		// hay que hacer rollback si no hay modificacion? es recomendable?
		tx.rollback();
		session.disconnect();
		session.close();
		return driverDTO;
	}

	@Override
	public List<DriverDTO> getDrivers() {
		Session session = this.getSession();	
		Transaction tx = null;
		tx = session.beginTransaction();
		
		String hql = "FROM bd2.Muber.model.Driver";
		Query query = session.createQuery(hql);
		List<Driver> result = query.list();
		
		List<DriverDTO> driversDTO = new ArrayList<DriverDTO>();
		for (Driver d : result) {
			DriverDTO dri = new DriverDTO(d);
			driversDTO.add(dri);
		}
		tx.rollback();
		session.disconnect();
		session.close();		
		return driversDTO;
	}

	@Override
	public List<DriverDTO> getDriversTop10() {
		// TODO Auto-generated method stub
		return null;
	}

}
