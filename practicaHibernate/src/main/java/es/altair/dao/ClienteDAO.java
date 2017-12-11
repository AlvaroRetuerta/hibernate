package es.altair.dao;

import java.util.List;

import es.altair.bean.Cliente;

public interface ClienteDAO {

	public void save (Cliente c);

	public Cliente get(int i);

	public void delete(Cliente c);
	
	public void deleteById(int i);
	
	public List<Cliente> listado();
	
	public void update(Cliente c); 
	
}
