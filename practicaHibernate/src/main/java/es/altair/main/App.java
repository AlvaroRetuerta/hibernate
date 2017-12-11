package es.altair.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.altair.bean.Cliente;
import es.altair.bean.Oficina;
import es.altair.bean.Vehiculo;
import es.altair.dao.ClienteDAO;
import es.altair.dao.ClienteDAOImplHibernate;
import es.altair.dao.OficinaDAO;
import es.altair.dao.OficinaDAOImplHibernate;
import es.altair.dao.VehiculoDAO;
import es.altair.dao.VehiculoDAOImplHibernate;

public class App 
{
    public static void main( String[] args )
    {
       
    	OficinaDAO ofiDAO = new OficinaDAOImplHibernate();
    	
    	ClienteDAO cDAO = new ClienteDAOImplHibernate();
    	
    	VehiculoDAO vDAO = new VehiculoDAOImplHibernate();
    	
//    	Oficina ofi = new Oficina("Sevilla", "Calle falsa 123");
//    	
//    	ofiDAO.save(ofi); //OK
//    	
//    	Vehiculo v1 = new Vehiculo("audi", "tt", ofi, "1234AA");    // funciona solo si la ofi esta guardada en la misma ejecucion de la app
//    	
//    	Vehiculo v2 = new Vehiculo("bmw", "m3", ofi, "1234BB");
//    	
//    	Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
//    	vehiculos.add(v1);
//    	vehiculos.add(v2);
//    	
//    	ofi.setVehiculos(vehiculos);
//    	
//    	Cliente c = new Cliente("nombre", "apellidos", "45778855K"); //NO DEJA REPETIR EL DNI OK
//    	
//    	cDAO.save(c); //OK
//    	
//    	v1.getClientes().add(c);
//    	vDAO.save(v1);
//--------Los saves funcionan, pero para guardar un vehiculo hay que darle la oficina guardada antes-------------
    	
    	
//--------Los Select por id funcionan correctamente-------------
    	
//--------Los delete por objeto funcionan sin problemas con oficinas
//    	ofiDAO.delete(ofiDAO.get(2));
    	
//    	cDAO.deleteById(2);//perfe
    	
    	//al borrar un vehiculo borra tambien los clientes de los alquileres // Solucionado
    	//vDAO.deleteById(2);
    	
    	
    	//listado de todos los objetos de las tablas, funcionando
//    	List<Oficina> oficinas = ofiDAO.listado();
//        for (Oficina oficina : oficinas) {
//         System.out.println(oficina.getIdOficina() + "  " +  oficina.getCiudad()+ "  "+oficina.getDireccion());
//    	}

    	
//-------Updates pasando el objeto completo funcionando-----------
    	
    	List<Vehiculo> vehiculos = vDAO.listadoByIdCliente(2);
      for (Vehiculo vehiculo : vehiculos) {
       System.out.println(vehiculo.toString());
  	}  	
    	
    	
    	
    	
     }
    	
    
}

