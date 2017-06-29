package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.PrendaEntity;
import entities.VariedadPrendaEntity;
import model.Prenda;
import model.VariedadPrenda;

public class PrendaDAO extends HibernateDAO {
	
	private static PrendaDAO instancia = null;

	public static PrendaDAO getInstance(){
		if(instancia == null) {
			instancia = new PrendaDAO();
		} 
		return instancia;
	}
	
	public Prenda save(Prenda prenda) {
		Session session = this.openSession();
		session.beginTransaction();
		
		PrendaEntity entity = new PrendaEntity(prenda, true);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return entity.toBO();
	}

	public List<Prenda> getAllPrendas() {
		List<Prenda> prendas = new ArrayList<Prenda>();
		Session session = this.openSession();
		Query query = session.createQuery("from PrendaEntity");
		List<PrendaEntity> prendasEntity = query.list();
		for (PrendaEntity prendaEntity : prendasEntity) {
			prendas.add(prendaEntity.toBO());
		}
		return prendas;
	}
	
	
	public List<VariedadPrenda> getAllVariedadesPrenda(Prenda prenda) {
		List<VariedadPrenda> variedades = new ArrayList<VariedadPrenda>();
		Session session = this.openSession();
		Query query = session.createQuery("from VariedadPrendaEntity vp join PrendaEntity p where p.codigo= :codigo");
		query.setParameter("codigo", prenda.getCodigo());
		List<VariedadPrendaEntity> entity = query.list();
		for (VariedadPrendaEntity vp : entity) {
			variedades.add(vp.toBO(true));
		}
		return variedades;
	}

	public VariedadPrenda saveVarieadad(VariedadPrenda variedadPrenda) {
		Session session = this.openSession();
		session.beginTransaction();
		
		VariedadPrendaEntity entity = new VariedadPrendaEntity(variedadPrenda, true);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return entity.toBO(true);
	}
	
	public Prenda getPrendaByCodigo(long codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from PrendaEntity where codigo = :codigo");
		query.setParameter("codigo", codigo);
		PrendaEntity prendaEntity = (PrendaEntity) query.uniqueResult();
		return prendaEntity != null? prendaEntity.toBO() : null;
	}

	public void baja(Prenda prenda) {
		Session session = this.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update PrendaEntity set enProduccion = false where codigo = :codigo");
		query.setParameter("codigo", prenda.getCodigo());
		query.executeUpdate();
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public VariedadPrenda getVariedadPrendaById(Long id) {
		Session session = this.openSession();
		Query query = session.createQuery("from VariedadPrendaEntity where id = :id");
		query.setParameter("id", id);
		VariedadPrendaEntity variedadPrendaEntity = (VariedadPrendaEntity) query.uniqueResult();
		return variedadPrendaEntity != null? variedadPrendaEntity.toBO(true) : null;
	}

	public void baja(VariedadPrenda variedadPrenda) {
		Session session = this.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update VariedadPrendaEntity set enProduccion = false where id = :id");
		query.setParameter("id", variedadPrenda.getId());
		query.executeUpdate();
		session.flush();
		session.getTransaction().commit();
		session.close();	
	}

}
