package bd2.Muber.services.impl;

import bd2.Muber.dto.QualificationDTO;

public class QualificationServiceImpl extends BaseServiceImpl implements bd2.Muber.services.QualificationService {

	@Override
	public QualificationDTO findById(long QualificationId) {
		return qualificationRepository.getQualification(QualificationId);
	}

	@Override
	public boolean saveQualification(long idTravel, long idPassenger, int points, String comment) {
		return qualificationRepository.saveQualification(idTravel, idPassenger, points, comment);
	}

}
