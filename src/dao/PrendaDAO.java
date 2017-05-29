package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.ClienteEntity;
import entities.PrendaEntity;
import entities.VariedadPrendaEntity;
import model.Cliente;
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
	
	public Prenda save(Prenda cliente) {
		Session session = this.openSession();
		session.beginTransaction();
		
		PrendaEntity entity = new PrendaEntity(cliente);
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

	public VariedadPrenda saveVarieadad(VariedadPrenda variedadPrenda) {
		Session session = this.openSession();
		session.beginTransaction();
		
		VariedadPrendaEntity entity = new VariedadPrendaEntity(variedadPrenda);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return entity.toBO(true);
	}

}
