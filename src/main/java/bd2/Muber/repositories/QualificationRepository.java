package bd2.Muber.repositories;

import bd2.Muber.dto.QualificationDTO;

public interface QualificationRepository extends BaseRepository {

	QualificationDTO getQualification(long QualificationId);
	Boolean saveQualification(long idTravel, long idPassenger, int points, String comment);
	
}