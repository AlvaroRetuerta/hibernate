package es.altair.dao;

import java.util.List;

import es.altair.bean.Vehiculo;

public interface VehiculoDAO {

	
	public void save(Vehiculo v);
	
	public Vehiculo get(int i);
	
	public void delete(Vehiculo v);
	
	public void deleteById(int i);
	
	public List<Vehiculo> listado();
	
	public void update(Vehiculo v); 

	public List<Vehiculo> listadoByIdCliente(int idCliente);
	
}
