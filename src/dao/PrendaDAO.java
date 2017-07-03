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
		
		Prenda prendaToReturn = entity.toBO();
		session.close();
		
		return prendaToReturn;
	}

	public List<Prenda> getAllPrendas() {
		List<Prenda> prendas = new ArrayList<Prenda>();
		Session session = this.openSession();
		Query query = session.createQuery("from PrendaEntity");
		List<PrendaEntity> prendasEntity = query.list();
		for (PrendaEntity prendaEntity : prendasEntity) {
			prendas.add(prendaEntity.toBO());
		}
		session.close();//SESSIONCLOSE
		return prendas;
	}
	
	
	public List<VariedadPrenda> getAllVariedadesPrenda(Prenda prenda) {
		List<VariedadPrenda> variedades = new ArrayList<VariedadPrenda>();
		Session session = this.openSession();
		Query query = session.createQuery("select vp from VariedadPrendaEntity vp join vp.prenda p where p.codigo = :codigo");
		query.setParameter("codigo", prenda.getCodigo());
		List<VariedadPrendaEntity> entity = query.list();
		for (VariedadPrendaEntity vp : entity) {
			variedades.add(vp.toBO(true));
		}
		session.close();//SESSIONCLOSE
		return variedades;
	}

	public VariedadPrenda saveVarieadad(VariedadPrenda variedadPrenda) {
		Session session = this.openSession();
		session.beginTransaction();
		
		VariedadPrendaEntity entity = new VariedadPrendaEntity(variedadPrenda, true);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		
		VariedadPrenda variedadToReturn = entity.toBO(true);
		session.close();
		
		return variedadToReturn;
	}
	
	public Prenda getPrendaByCodigo(long codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from PrendaEntity where codigo = :codigo");
		query.setParameter("codigo", codigo);
		PrendaEntity prendaEntity = (PrendaEntity) query.uniqueResult();
		
		Prenda prendaToReturn = prendaEntity != null? prendaEntity.toBO() : null;
		session.close();//SESSIONCLOSE
		
		return prendaToReturn;
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
		
		VariedadPrenda variedadToReturn = variedadPrendaEntity != null? variedadPrendaEntity.toBO(true) : null;
		session.close();//SESSIONCLOSE
		
		return variedadToReturn;
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

	public List<Prenda> getPrendasVigentes() {
		List<Prenda> prendas = new ArrayList<Prenda>();
		Session session = this.openSession();
		Query query = session.createQuery("from PrendaEntity p where p.enProduccion = true");
		List<PrendaEntity> prendasEntity = query.list();
		for (PrendaEntity prendaEntity : prendasEntity) {
			prendas.add(prendaEntity.toBO());
		}
		session.close();//SESSIONCLOSE
		return prendas;
	}

}
