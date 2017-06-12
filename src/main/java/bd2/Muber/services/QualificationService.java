package bd2.Muber.services;

import bd2.Muber.dto.QualificationDTO;

public interface QualificationService {
	
	QualificationDTO findById(Long id);
	boolean saveQualification(Long idTravel, Long idPassenger, int points, String comment);
	
}
