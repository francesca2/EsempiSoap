package it.alfasoft.francesca.dao;

import it.alfasoft.francescal.model.BustaPaga;

import java.util.Map;
import java.util.TreeMap;

public class BustaPagaDao {
	
	private Map<Long,BustaPaga> buste;

	public BustaPagaDao() {
		buste=new TreeMap<Long,BustaPaga>();
		BustaPaga b1= new BustaPaga(1,1200,"cod001");
		BustaPaga b2= new BustaPaga(2,1250,"cod001");
		BustaPaga b3= new BustaPaga(3,1300,"cod001");
		BustaPaga b4= new BustaPaga(4,1100,"cod001");
		buste.put(b1.getId_Busta(), b1);
		buste.put(b2.getId_Busta(), b2);
		buste.put(b3.getId_Busta(), b3);
		buste.put(b4.getId_Busta(), b4);
	}

	public Map<Long, BustaPaga> getBuste() {
		return buste;
	}

	public void setBuste(Map<Long, BustaPaga> buste) {
		this.buste = buste;
	}
	
	

}
