package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.InsumoEntity;
import model.Insumo;

public class InsumoDAO extends HibernateDAO {
	
	private static InsumoDAO instancia = null;

	public static InsumoDAO getInstance(){
		if(instancia == null) {
			instancia = new InsumoDAO();
		} 
		return instancia;
	}
	
	public Insumo save(Insumo insumo) {
		Session session = this.openSession();
		session.beginTransaction();	
		InsumoEntity i = new InsumoEntity(insumo);
		session.saveOrUpdate(i);		
		session.flush();
		session.getTransaction().commit();
		Insumo toReturn = i.toBO();
		session.close();
		return toReturn;
	}
	
	public Insumo findByCodigo(long codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
		query.setParameter("codigo", codigo);
		InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
		Insumo toReturn = insumo != null? insumo.toBO() : null;
		session.close();//SESSIONCLOSE
		return toReturn;
	}
	
	public List<Insumo> getAllInsumos() {
		List<Insumo> insumos = new ArrayList<Insumo>();
		Session session = this.openSession();
		Query query = session.createQuery("from InsumoEntity");
		List<InsumoEntity> insumosEntity = query.list();
		for (InsumoEntity insumoEntity : insumosEntity) {
			insumos.add(insumoEntity.toBO());
		}
		session.close();//SESSIONCLOSE
		return insumos;
	}

	public Insumo update(Insumo insumo) {
		return save(insumo);
	}

}
