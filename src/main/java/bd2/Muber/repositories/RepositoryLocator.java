package bd2.Muber.repositories;

public class RepositoryLocator {

	static PassengerRepository passengerRepository;
	static DriverRepository driverRepository;
	static TravelRepository travelRepository;
	static QualificationRepository qualificationRepository;
	
	public static RepositoryLocator getInstance() {
		return new RepositoryLocator();
	}
	
	public static void setPassengerRepository(PassengerRepository repository){
		passengerRepository = repository;
	}
 
	public static PassengerRepository getPassengerRepository(){
    	return passengerRepository;
    }
	
	public static void setDriverRepository(DriverRepository repository){
    	driverRepository = repository;
	}
	 
	public static DriverRepository getDriverRepository(){
    	return driverRepository;
	}
	
	public static void setTravelRepository(TravelRepository repository){
    	travelRepository = repository;
	}
 
	public static TravelRepository getTravelRepository(){
    	return travelRepository;
	}
	
	public static void setQualificationRepository(QualificationRepository repository){
    	qualificationRepository = repository;
	}
 
	public static QualificationRepository getQualificationRepository(){
    	return qualificationRepository;
	}

}
