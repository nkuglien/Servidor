package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;


public abstract class HibernateDAO {
	
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();

	protected Session openSession() {
		return sf.openSession();
	}
	
}
