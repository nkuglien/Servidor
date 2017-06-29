package dao;

import org.hibernate.Session;

import entities.ReservaInsumoEntity;
import model.ReservaInsumo;

public class ReservaInsumoDAO  extends HibernateDAO {
	
	private static ReservaInsumoDAO instancia = null;

	public static ReservaInsumoDAO getInstance(){
		if(instancia == null) {
			instancia = new ReservaInsumoDAO();
		} 
		return instancia;
	}
	
	public ReservaInsumo save(ReservaInsumo reserva) {
		Session session = this.openSession();
		session.beginTransaction();		
		session.saveOrUpdate(new ReservaInsumoEntity(reserva));		
		session.flush();
		session.getTransaction().commit();
		session.close();
		return reserva;
	}
	

}
