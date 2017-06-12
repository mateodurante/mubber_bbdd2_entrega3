package bd2.Muber.repositories;

import bd2.Muber.dto.QualificationDTO;

public interface QualificationRepository extends BaseRepository {

	QualificationDTO getQualification(Long QualificationId);
	Boolean saveQualification(Long idTravel, Long idPassenger, int points, String comment);
	
}