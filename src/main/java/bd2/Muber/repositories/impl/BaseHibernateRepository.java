package bd2.Muber.repositories.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bd2.Muber.repositories.BaseRepository;

public class BaseHibernateRepository implements BaseRepository {
	SessionFactory sessionFactory;
	
	public BaseHibernateRepository(){
	}
	
	public BaseHibernateRepository(SessionFactory session){
		sessionFactory = session;
	}
	
	public void setSessionFactory(SessionFactory session){
		this.sessionFactory = session;
	}
	
	public Session getSession() {
		SessionFactory factory = sessionFactory;
		Session session = factory.openSession();
		return session;
	}

}
