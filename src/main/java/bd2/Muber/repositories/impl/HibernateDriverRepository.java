package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Qualification;
import bd2.Muber.model.Travel;
import bd2.Muber.repositories.DriverRepository;

public class HibernateDriverRepository extends BaseHibernateRepository implements DriverRepository {

	@Override
	public DriverDTO getDriver(long driverId) {
		Session session = this.getSession();
		
		String hql = "FROM bd2.Muber.model.Driver P WHERE P.idUser = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, driverId);
		Driver result =(Driver) query.uniqueResult();
				
		if (result == null){
			return null;
		}
		DriverDTO driverDTO = new DriverDTO(result);
		// hay que hacer rollback si no hay modificacion? es recomendable?
		session.disconnect();
		session.close();
		return driverDTO;
	}

	@Override
	public List<DriverDTO> getDrivers() {
		Session session = this.getSession();
		
		String hql = "FROM bd2.Muber.model.Driver";
		Query query = session.createQuery(hql);
		List<Driver> result = query.list();
		
		List<DriverDTO> driversDTO = new ArrayList<DriverDTO>();
		for (Driver d : result) {
			DriverDTO dri = new DriverDTO(d);
			driversDTO.add(dri);
		}
		session.disconnect();
		session.close();		
		return driversDTO;
	}

	@Override
	public List<DriverDTO> getDriversTop10() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<DriverDTO> getTop10DriversWithoutOpenTravels(){
		Session session = this.getSession();
		
		String hql = "SELECT D FROM bd2.Muber.model.Driver as D "
			+ "INNER JOIN bd2.Muber.model.Qualification as Q "
			+ "ON D.idUser = Q.driver.idUser "
			+ "WHERE D.idUser NOT IN ( "
			+ "SELECT T.driver.idUser "
			+ "FROM bd2.Muber.model.Travel as T "
			+ "WHERE T.finalized = 0) "
			+ "ORDER BY Q.points DESC ";
	
		Query query = session.createQuery(hql);
		//query.setMaxResults(10);
		
		List<Driver> result = query.list();
		
		List<Driver> drivers = new ArrayList<Driver>();
		Iterator<Driver> resultIterator = result.iterator();
		while (resultIterator.hasNext() && drivers.size()<10) {
		    Driver d = resultIterator.next();
		    if (!drivers.contains(d)){
    		    	drivers.add(d);
		    }
		}

		List<DriverDTO> driversDTO = new ArrayList<DriverDTO>();
		for(Driver d: drivers){
		    driversDTO.add(new DriverDTO(d));
		}
		
		session.disconnect();
		session.close();
		return driversDTO;

	}
	
	public void cargarDatos(){
		Session session = this.getSession();
		
		System.out.println("Transacción creada.");
		System.out.println("Creando datos...");
		
		/**** Creando conductores ***/
		System.out.println("Punto 4.A.");
		// Estos tienen viajes cerrados
		Driver roberto = new Driver("roberto", "redificil", new GregorianCalendar(2020, 2, 20).getTime());
		Driver tito = new Driver("tito", "tito", new GregorianCalendar(2021, 2, 21).getTime());
		Driver agueda = new Driver("agueda", "facil", new GregorianCalendar(2020, 2, 20).getTime());
		Driver lihuen = new Driver("lihuen", "redificil", new GregorianCalendar(2018, 4, 22).getTime());
		Driver daniel = new Driver("daniel", "redificil", new GregorianCalendar(2020, 2, 20).getTime());
		Driver cristian = new Driver("cristian", "redificil", new GregorianCalendar(2020, 2, 20).getTime());
		Driver barbaro = new Driver("barbaro", "redificil", new GregorianCalendar(2020, 2, 20).getTime());
		Driver jonsnow = new Driver("jonsnow", "no sabes nada, amigo", new GregorianCalendar(2020, 2, 20).getTime());
		Driver thor = new Driver("thor", "dame el martillo", new GregorianCalendar(2020, 2, 20).getTime());
		Driver loki = new Driver("loki", "mucho", new GregorianCalendar(2020, 2, 20).getTime());
		// Este tendrá viajes abierto.
		Driver abierto = new Driver("abierto", "redificil", new GregorianCalendar(2020, 2, 20).getTime());
		
		/**** Creación de viajes abiertos ****/
		Travel viaje1 = roberto.createTravel("La Plata", "Tres Arroyos", 4, 1900);
		Travel viaje2 = tito.createTravel("El Peligro", "El Pato", 4, 900);
		Travel viaje3 = agueda.createTravel("El Peligro", "El Pato", 4, 800);
		Travel viaje4 = lihuen.createTravel("La Plata", "Tres Arroyos", 6, 2000);
		Travel viaje5 = daniel.createTravel("La Plata", "Tres Arroyos", 3, 3000);
		Travel viaje6 = cristian.createTravel("La Plata", "Bariloche", 5, 9000);
		Travel viaje7 = agueda.createTravel("Buenos Aires", "Bariloche", 5, 9000);
		Travel viaje8 = jonsnow.createTravel("The Wall", "King's Landing", 2, 100000);
		Travel viaje9 = thor.createTravel("Buenos Aires", "Montevideo", 3, 100000);
		Travel viaje10 = loki.createTravel("New York", "Ragnarok", 3, 100000);
		
		/*** Viaje cerrado ***/
		Travel viaje11 = abierto.createTravel("Ensenada", "La Plata", 3, 300);
		
		/**** Algunos pasajeros ***/
		Passenger german = new Passenger("german", "ger", 20000);
		Passenger alicia = new Passenger("alicia", "ali", 15000);
		Passenger margarita = new Passenger("margarita", "mar", 15000);
		Passenger hugo = new Passenger("hugo", "hug", 2300);
		german.addTravel(viaje11);
		alicia.addTravel(viaje11);
		margarita.addTravel(viaje11);
		
		/**** Viajes calificados ****/
		german.addTravel(viaje1);
		alicia.addTravel(viaje1);
		margarita.addTravel(viaje1);
		german.addTravel(viaje2);
		alicia.addTravel(viaje3);
		margarita.addTravel(viaje4);
		german.addTravel(viaje5);
		alicia.addTravel(viaje6);
		margarita.addTravel(viaje7);
		
		/*** Calificamos para Rusia ***/
		Qualification q1 = german.qualify(viaje1, 5, "alto viaje, me re cabio");
		Qualification q2 = alicia.qualify(viaje1, 4, "todo bien pero el chofer durmio todo el viaje");
		Qualification q3 = margarita.qualify(viaje1, 4, "los mates eran dulces");
		viaje1.finalize();
		Qualification q4 = german.qualify(viaje2, 1, "viajamos solo, creo que le cabe la soledad");
		viaje2.finalize();
		Qualification q5 = alicia.qualify(viaje3, 2, "todo bien pero el chofer durmio todo el viaje");
		viaje3.finalize();
		Qualification q6 = margarita.qualify(viaje4, 4, "los mates eran dulces");
		viaje4.finalize();
		Qualification q7 = german.qualify(viaje5, 5, "alto viaje, me re cabio");
		viaje5.finalize();
		Qualification q8 = alicia.qualify(viaje6, 3, "todo bien pero el chofer durmio todo el viaje");
		viaje6.finalize();
		Qualification q9 = margarita.qualify(viaje7, 4, "los mates eran dulces");
		viaje7.finalize();
		viaje8.finalize();
		viaje9.finalize();
		viaje10.finalize();

		System.out.println("Guardando...");
		session.saveOrUpdate(hugo);
		session.saveOrUpdate(roberto);
		session.saveOrUpdate(tito);
		session.saveOrUpdate(agueda);
		session.saveOrUpdate(lihuen);
		session.saveOrUpdate(daniel);
		session.saveOrUpdate(cristian);
		session.saveOrUpdate(barbaro);
		session.saveOrUpdate(jonsnow);
		session.saveOrUpdate(thor);
		session.saveOrUpdate(loki);
		session.saveOrUpdate(abierto);
		session.saveOrUpdate(german);
		session.saveOrUpdate(alicia);
		session.saveOrUpdate(margarita);

		System.out.println("Cerrando transacción...");
		session.disconnect();
		session.close();
		System.out.println("Terminado.");
	}

}
