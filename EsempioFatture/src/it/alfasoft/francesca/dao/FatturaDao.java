package it.alfasoft.francesca.dao;

import it.alfasoft.francesca.model.Fattura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FatturaDao {
	private Map<String,Fattura> fatture;
	private Fattura[] arr;

	public FatturaDao() {
		fatture=new HashMap<String,Fattura>();
		Fattura f1=new Fattura("cod001",1200,"Azienda 1");
		Fattura f2=new Fattura("cod002",1150,"Azienda 2");
		Fattura f3=new Fattura("cod003",1340,"Azienda 3");
		Fattura f4=new Fattura("cod004",800,"Azienda 4");
		Fattura f5=new Fattura("cod005",2700,"Azienda 5");
		fatture.put("cod001", f1);
		fatture.put("cod002", f2);
		fatture.put("cod003", f3);
		fatture.put("cod004", f4);
		fatture.put("cod005", f5);

	}
	
	public Fattura[] getAllFatture(){
		List<Fattura> lista=new ArrayList<Fattura>(fatture.values());
		arr=new Fattura[lista.size()];
		for(int i=0; i<5; i++){
			arr[i]=lista.get(i);
		}
		return arr;
	}

	public Fattura getFatturaByCode(String code){
		return fatture.get(code);
	}

}
