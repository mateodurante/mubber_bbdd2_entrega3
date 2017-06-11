package bd2.Muber.services.impl;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.impl.HibernateDriverRepository;
import bd2.Muber.repositories.impl.HibernatePassengerRepository;
import bd2.Muber.repositories.impl.HibernateQualificationRepository;
import bd2.Muber.repositories.impl.HibernateTravelRepository;

public class BaseServiceImpl {
	
	public HibernatePassengerRepository passengerRepository;
	public HibernateDriverRepository driverRepository;
	public HibernateTravelRepository travelRepository;
	public HibernateQualificationRepository qualificationRepository;
	
	public DTOFactory dtoFactory;
	
	public DTOFactory getDtoFactory() {
		return dtoFactory;
	}
		
	/**
	 * @return the passengerRepository
	 */
	public HibernatePassengerRepository getPassengerRepository() {
		return passengerRepository;
	}

	/**
	 * @param passengerRepository the passengerRepository to set
	 */
	public void setPassengerRepository(HibernatePassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	/**
	 * @return the driverRepository
	 */
	public HibernateDriverRepository getDriverRepository() {
		return driverRepository;
	}

	/**
	 * @param driverRepository the driverRepository to set
	 */
	public void setDriverRepository(HibernateDriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	/**
	 * @return the travelRepository
	 */
	public HibernateTravelRepository getTravelRepository() {
		return travelRepository;
	}

	/**
	 * @param travelRepository the travelRepository to set
	 */
	public void setTravelRepository(HibernateTravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}

	/**
	 * @return the QualificationRepository
	 */
	public HibernateQualificationRepository getQualificationRepository() {
		return qualificationRepository;
	}

	/**
	 * @param qualificationRepository the qualificationRepository to set
	 */
	public void setQualificationRepository(HibernateQualificationRepository qualificationRepository) {
		this.qualificationRepository = qualificationRepository;
	}

	/**
	 * @param dtoFactory the dtoFactory to set
	 */
	public void setDtoFactory(DTOFactory dtoFactory) {
		this.dtoFactory = dtoFactory;
	}	
	
}
