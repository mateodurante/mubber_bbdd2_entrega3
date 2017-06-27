package bd2.Muber.repositories.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.dto.QualificationDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Qualification;
import bd2.Muber.model.Travel;
import bd2.Muber.repositories.QualificationRepository;

public class HibernateQualificationRepository extends BaseHibernateRepository implements QualificationRepository {

    @Override
    public Boolean saveQualification(long idTravel, long idPassenger, int points, String comment) {
	Session session = this.getSession();

	String hql = "FROM bd2.Muber.model.Passenger P WHERE P.idUser = ?";
	Query query = session.createQuery(hql);
	query.setParameter(0, idPassenger);
	Passenger aPassenger = (Passenger) query.uniqueResult();

	String hql1 = "FROM bd2.Muber.model.Travel T WHERE T.idTravel = ?";
	Query query1 = session.createQuery(hql1);
	query1.setParameter(0, idTravel);
	Travel aTravel = (Travel) query1.uniqueResult();

	Qualification aQualification = new Qualification(points, comment, aPassenger, aTravel);

	session.save(aQualification);
	session.disconnect();
	session.close();
	return true;

    }

    @Override
    public QualificationDTO getQualification(long QualificationId) {
	Session session = this.getSession();	
	String hql = "FROM bd2.Muber.model.Qualification P WHERE P.idQualification = ?";
	Query query = session.createQuery(hql);
	query.setParameter(0, QualificationId);
	Qualification result = (Qualification) query.uniqueResult();
	QualificationDTO qualificationDTO = new QualificationDTO();
	if (result != null){
	    qualificationDTO = new QualificationDTO(result);
	}
	session.disconnect();
	session.close();
	return qualificationDTO;
    }

}
