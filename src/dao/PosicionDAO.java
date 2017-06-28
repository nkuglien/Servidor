package dao;

import model.Posicion;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.InsumoEntity;
import entities.PedidoInsumoEntity;
import entities.PosicionEntity;
import entities.ProveedorEntity;
import model.Insumo;
import model.PedidoInsumo;
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
		session.close();
		
		return entity.toBO();
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
	
	public Posicion getPosicionVacia(){
		Session session = this.openSession();
		Query query = session.createQuery("from PosicionEntity where libre = true");
		PosicionEntity entity = (PosicionEntity) query.uniqueResult();
		return entity != null? entity.toBO() : null;
		
	}
	
	
	public Posicion getByCodigo(String codigo) {
		Session session = this.openSession();
		Query query = session.createQuery("from PosicionEntity where codigo = :codigo");
		query.setParameter("codigo", codigo);
		PosicionEntity entity = (PosicionEntity) query.uniqueResult();
		return entity != null? entity.toBO() : null;
	}

}
