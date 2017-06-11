package bd2.Muber.services;

import bd2.Muber.dto.DTOFactory;

public class ServiceLocator {

	static PassengerService passengerService;
	static DriverService driverService;
	static TravelService travelService;
	static QualificationService qualificationService;
	
	public DTOFactory dtoFactory;

	public static ServiceLocator getInstance() {
		return new ServiceLocator();
	}

	public DTOFactory getDtoFactory() {
		return dtoFactory;
	}
	
	/**
	 * @param dtoFactory the dtoFactory to set
	 */
	public void setDtoFactory(DTOFactory dtoFactory) {
		this.dtoFactory = dtoFactory;
	}	
	/**
	 * @return the passengerService
	 */
	public static PassengerService getPassengerService() {
		return passengerService;
	}

	/**
	 * @param passengerService the passengerService to set
	 */
	public static void setPassengerService(PassengerService passengerService) {
		ServiceLocator.passengerService = passengerService;
	}

	/**
	 * @return the driverService
	 */
	public static DriverService getDriverService() {
		return driverService;
	}

	/**
	 * @param driverService the driverService to set
	 */
	public static void setDriverService(DriverService driverService) {
		ServiceLocator.driverService = driverService;
	}

	/**
	 * @return the travelService
	 */
	public static TravelService getTravelService() {
		return travelService;
	}

	/**
	 * @param travelService the travelService to set
	 */
	public static void setTravelService(TravelService travelService) {
		ServiceLocator.travelService = travelService;
	}

	/**
	 * @return the qualificationService
	 */
	public static QualificationService getQualificationService() {
		return qualificationService;
	}

	/**
	 * @param qualificationService the qualificationService to set
	 */
	public static void setQualificationService(QualificationService qualificationService) {
		ServiceLocator.qualificationService = qualificationService;
	}

}
