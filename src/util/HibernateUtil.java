package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.AreaProduccion;
import entities.ClienteEntity;
public class HibernateUtil {
	 private static final SessionFactory sessionFactory;
	    static
	    {
	        try
	        {
	        	 AnnotationConfiguration config = new AnnotationConfiguration();
	        	 config.addAnnotatedClass(ClienteEntity.class);
	             sessionFactory = config.buildSessionFactory();
	        }
	        catch (Throwable ex)
	        {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    public static SessionFactory getSessionFactory()
	    {
	        return sessionFactory;
	    }
}
