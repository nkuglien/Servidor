package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;


public class HibernateDAO {
	
	private static HibernateDAO instancia = null;
	private static SessionFactory sf = null;

	public static HibernateDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateDAO();
		} 
		return instancia;
	}
	
	public Session getSession()
	{
		return sf.getCurrentSession();
	}
}
