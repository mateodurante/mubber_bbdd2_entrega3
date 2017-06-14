package bd2.Muber.services;

import bd2.Muber.dto.QualificationDTO;

public interface QualificationService {
	
	QualificationDTO findById(long id);
	boolean saveQualification(long idTravel, long idPassenger, int points, String comment);
	
}
