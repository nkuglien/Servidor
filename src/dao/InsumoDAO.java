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
		
		session.saveOrUpdate(new InsumoEntity(insumo));
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		return insumo;
	}
	
	public Insumo findByCodigo(long codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
		query.setParameter("codigo", codigo);
		InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
		return insumo != null? insumo.toBO() : null;
	}
	
	public List<Insumo> getAllInsumos() {
		List<Insumo> insumos = new ArrayList<Insumo>();
		Session session = this.openSession();
		Query query = session.createQuery("from InsumoEntity");
		List<InsumoEntity> insumosEntity = query.list();
		for (InsumoEntity insumoEntity : insumosEntity) {
			insumos.add(insumoEntity.toBO());
		}
		return insumos;
	}

	public Insumo update(Insumo insumo) {
		return save(insumo);
	}

}
