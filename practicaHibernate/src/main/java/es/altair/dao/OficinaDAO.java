package es.altair.dao;

import java.util.List;

import es.altair.bean.Oficina;

public interface OficinaDAO {

	public void save (Oficina f);
	
	public Oficina get(int i);
	
	public void delete(Oficina o);
	
	public List<Oficina> listado();
	
	public void update(Oficina o); 
}
