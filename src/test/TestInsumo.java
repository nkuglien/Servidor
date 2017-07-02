package test;

import java.util.List;

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
		LoteInsumo lote1 = new LoteInsumo();
		Posicion p1 = new Posicion("H010323", false, lote1);
		lote1 = new LoteInsumo(null, 20, 20, p1, insumo1, null, Float.parseFloat("100"), null);
		lote1.save();
		
		Insumo insumo2 = new Insumo(1001, "Boton", "Boton", 200, 200,(float)200);
		insumo2 = insumo2.save();
		LoteInsumo lote2 = new LoteInsumo();
		Posicion p2 = new Posicion("H010322", false, lote2);
		lote2 = new LoteInsumo(null, 15, 15, p2, insumo2, null, Float.parseFloat("150"), null);
		lote2.save();
		
		Insumo insumo3 = new Insumo(1002, "Colorante", "Colorante", 300, 300,(float)300);
		insumo3 = insumo3.save();
		LoteInsumo lote3 = new LoteInsumo();
		Posicion p3 = new Posicion("H010321", false, lote3);
		lote3 = new LoteInsumo(null, 10, 10, p3, insumo3, null, Float.parseFloat("200"), null);
		lote3.save();

		Insumo insumo4 = new Insumo(1003, "Cierre", "Cierre", 400, 400,(float)400);
		insumo4 = insumo4.save();
		LoteInsumo lote4 = new LoteInsumo();
		Posicion p4 = new Posicion("H010320", false, lote4);
		lote4 = new LoteInsumo(null, 16, 16, p4, insumo4, null, Float.parseFloat("175"), null);
		lote4.save();
		
	}

}
