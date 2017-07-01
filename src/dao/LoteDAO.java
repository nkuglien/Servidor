package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.LoteEntity;
import entities.LoteInsumoEntity;
import entities.LoteVariedadPrendaEntity;
import entities.PedidoInsumoEntity;
import model.Insumo;
import model.Lote;
import model.LoteInsumo;
import model.LoteVariedadPrenda;
import model.PedidoInsumo;
import model.VariedadPrenda;

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
		LoteEntity le = null;
		if(lote instanceof LoteInsumo){
			le = new LoteInsumoEntity((LoteInsumo)lote);
			session.saveOrUpdate(le);		
		}
		if(lote instanceof LoteVariedadPrenda)  {
			le = new LoteVariedadPrendaEntity((LoteVariedadPrenda)lote);
			session.saveOrUpdate(le);	
		}
			
		session.flush();
		session.getTransaction().commit();
		session.close();
		return le.toBO();
	}

	public List<LoteInsumo> getLotesConDisponibles(Insumo insumo) {
		Session session = this.openSession();
			Query query = session.createQuery("select li from LoteInsumoEntity li join li.insumo i where i.id = :idInsumo ");
			query.setParameter("idInsumo", insumo.getId());
			List<LoteInsumoEntity> lotes = (List<LoteInsumoEntity>) query.list();			
			List<LoteInsumo> retorno = new ArrayList<LoteInsumo>();
			for(LoteInsumoEntity lo : lotes){
				retorno.add(lo.toBO());
			}
			return retorno;
	}
	
	public List<LoteVariedadPrenda> getLotesConDisponibles(VariedadPrenda vp) {
//		Session session = this.openSession();
//		Query query = session.createQuery("select li from VariedadPrendaEntity li join li.insumo i where i.id = :idInsumo ");
//		query.setParameter("idInsumo", insumo.getId());
//		List<LoteInsumoEntity> lotes = (List<LoteInsumoEntity>) query.list();			
//		List<LoteInsumo> retorno = new ArrayList<LoteInsumo>();
//		for(LoteInsumoEntity lo : lotes){
//			retorno.add(lo.toBO());
//		}
//		return retorno;
		return null;
	}
	
	
	public int getStock(VariedadPrenda variedad) {
		Session session = this.openSession();
			Query query = session.createQuery("select lvp from LoteVariedadPrendaEntity lvp join lvp.variedadPrenda vpe where lvp.cantDisponible > 0 and vpe.id= :idVariedad");
			query.setParameter("idVariedad", variedad.getId());
			List<LoteVariedadPrendaEntity> lotes = (List<LoteVariedadPrendaEntity>) query.list();			
			int cantidad =0;
			for(LoteVariedadPrendaEntity lo : lotes){
				cantidad=cantidad + lo.getCantDisponible();
			}
			return cantidad;
	}
	
	//public Insumo findByCodigo(long codigo) {
	//	Session session = this.openSession();
	//	Query query = session.createQuery("from InsumoEntity where codigo = :codigo ");
	//	query.setParameter("codigo", codigo);
	//	InsumoEntity insumo = (InsumoEntity) query.uniqueResult();
	//	return insumo != null? insumo.toBO() : null;
	//}
	
	

}
