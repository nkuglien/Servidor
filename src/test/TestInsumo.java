package test;

import java.util.Date;
import java.util.List;

import dao.PosicionDAO;
import model.Insumo;
import model.LoteInsumo;
import model.LoteVariedadPrenda;
import model.PedidoInsumo;
import model.Posicion;
import model.ReservaInsumo;

public class TestInsumo {

	public static void main(String[] args) {
		Insumo insumo1 = new Insumo(1000, "Tela", "Tela", 100, 100,(float)100);
		insumo1 = insumo1.save();
		Posicion p1 = PosicionDAO.getInstance().getPosicionInsumoVacia();
		LoteInsumo lote1 = new LoteInsumo(null, 200, 200, p1, insumo1, null, Float.parseFloat("100"), null);
		lote1 = lote1.save();
		p1.setLote(lote1);
		p1.save();
		
		Insumo insumo2 = new Insumo(1001, "Boton", "Boton", 200, 200,(float)200);
		insumo2 = insumo2.save();
		Posicion p2 = PosicionDAO.getInstance().getPosicionInsumoVacia();
		LoteInsumo lote2 = new LoteInsumo(null, 400, 400, p2, insumo2, null, Float.parseFloat("150"), null);
		lote2 = lote2.save();
		p2.setLote(lote2);
		p2.save();
		
		Insumo insumo3 = new Insumo(1002, "Colorante", "Colorante", 300, 300,(float)300);
		insumo3 = insumo3.save();
		Posicion p3 = PosicionDAO.getInstance().getPosicionInsumoVacia();
		LoteInsumo lote3 = new LoteInsumo(null, 600, 600, p3, insumo3, null, Float.parseFloat("200"), null);
		lote3 = lote3.save();
		p3.setLote(lote3);
		p3.save();
		
		Insumo insumo4 = new Insumo(1003, "Cierre", "Cierre", 400, 400,(float)400);
		insumo4 = insumo4.save();
		Posicion p4 = PosicionDAO.getInstance().getPosicionInsumoVacia();
		LoteInsumo lote4 = new LoteInsumo(null, 800, 800, p4, insumo4, null, Float.parseFloat("175"), null);
		lote4 = lote4.save();
		p4.setLote(lote4);
		p4.save();
	}

}
