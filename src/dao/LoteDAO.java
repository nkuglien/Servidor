package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.LoteInsumoEntity;
import entities.LoteVariedadPrendaEntity;
import entities.PedidoInsumoEntity;
import model.Insumo;
import model.Lote;
import model.LoteInsumo;
import model.LoteVariedadPrenda;
import model.PedidoInsumo;

public class LoteDAO extends HibernateDAO {

	private static LoteDAO instancia = null;

	public static LoteDAO getInstance(){
		if(instancia == null) {
			instancia = new LoteDAO();
		} 
		return instancia;
	}
	
	public Lote save(Lote lote) {
		Session session = this.openSession();
		session.beginTransaction();		
		if(lote instanceof LoteInsumo)
			session.saveOrUpdate(new LoteInsumoEntity((LoteInsumo)lote));		
		if(lote instanceof LoteVariedadPrenda)
			session.saveOrUpdate(new LoteVariedadPrendaEntity((LoteVariedadPrenda)lote));	
		session.flush();
		session.getTransaction().commit();
		session.close();
		return lote;
	}

	public List<LoteInsumo> getLotesConDisponibles(Insumo insumo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//public Insumo findByCodigo(long codigo) {
	//	Session session = this.openSession();
	//	Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
	//	query.setParameter("codigo", codigo);
	//	InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
	//	return insumo != null? insumo.toBO() : null;
	//}
	
	

}
