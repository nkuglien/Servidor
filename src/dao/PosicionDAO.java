package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.PosicionEntity;
import model.Posicion;
public class PosicionDAO extends HibernateDAO {


	private static PosicionDAO instancia = null;

	public static PosicionDAO getInstance(){
		if(instancia == null) {
			instancia = new PosicionDAO();
		} 
		return instancia;
	}

	public Posicion save(Posicion posicion) {
		Session session = this.openSession();
		session.beginTransaction();
		
		PosicionEntity entity = new PosicionEntity(posicion);
		session.saveOrUpdate(entity);
		
		session.flush();
		session.getTransaction().commit();
		Posicion toReturn = entity.toBO();
		session.close();
		
		return toReturn;
	}
	
	//public List<Proveedor> getAllProveedores() {
	//	List<Proveedor> proveedores = new ArrayList<Proveedor>();
	//	Session session = this.openSession();
	//	Query query = session.createQuery("from ProveedorEntity");
	//	List<ProveedorEntity> proveedoresEntity = query.list();
	//	for (ProveedorEntity proveedorEntity : proveedoresEntity) {
	//		proveedores.add(proveedorEntity.toBO());
	//	}
	//	return proveedores;
	//}
	
		
	public Posicion getByCodigo(String codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from PosicionEntity where codigo = :codigo");
		query.setParameter("codigo", codigo);
		PosicionEntity entity = (PosicionEntity) query.uniqueResult();
		Posicion toReturn = entity != null? entity.toBO() : null;
		session.close();
		return toReturn;
	}

	public Posicion getPosicionInsumoVacia() {
		Session session = this.openSession();
		Query query = session.createQuery("from PosicionEntity where libre = true");
		Posicion toReturn = null;
		List<PosicionEntity> posicionesE = query.list();
		for (PosicionEntity p : posicionesE) {
			if(p.getCodigo().charAt(0) >= 'H'){
				toReturn = p.toBO();
				break;
			}
		}
		session.close();
		return toReturn;
	}

	public Posicion getPosicionPrendaVacia() {
		Session session = this.openSession();
		Query query = session.createQuery("from PosicionEntity where libre = true");
		Posicion toReturn = null;
		List<PosicionEntity> posicionesE = query.list();
		for (PosicionEntity p : posicionesE) {
			if(p.getCodigo().charAt(0) <= 'G') {
				toReturn = p.toBO();
				break;
			}
				
		}
		session.close();
		return toReturn;
	}

}
