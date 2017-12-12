package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import es.altair.bean.Vehiculo;

public class VehiculoDAOImplHibernate implements VehiculoDAO {

	public void save(Vehiculo v) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
		
			sesion.beginTransaction();
			sesion.save(v);
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}

	
	public Vehiculo get(int i) {
		Vehiculo v = null;
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			v = sesion.get(Vehiculo.class, i);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		return v;
	}
	
	public void delete(Vehiculo v) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(v);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}


	public void deleteById(int i) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		Vehiculo v = get(i);
		try {
			sesion.beginTransaction();
			
			sesion.delete(v);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		
	}
	
	
	public List<Vehiculo> listado() {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			vehiculos = sesion.createQuery("FROM Vehiculo v").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();

		}
		return vehiculos;
	}
	
	public void update(Vehiculo v) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.update(v);

			sesion.getTransaction().commit();
		} catch (Exception ex) {

		} finally {
			sesion.close();
			sf.close();
		}

	}
	
	//metodo para listar los vehiculos que han sido alquilados por un cliente con el id
	public List<Vehiculo> listadoByIdCliente(int idCliente) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
	
		try {
			
			sesion.beginTransaction();
			
			
			
			vehiculos = sesion.createSQLQuery(
					"select vehiculo.* from vehiculo inner join alquiler on (alquiler.idVehiculo=vehiculo.idVehiculo) where alquiler.idCliente=:idCliente ")
					.addEntity(Vehiculo.class).setParameter("idCliente", idCliente).list();
			
			
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();

		}
		return vehiculos;
	}
	
	
	public List<Vehiculo> listadoPaginado(int tamanyoPagina) {
		
		List<Vehiculo> vehiculos = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
	
		try {
			
			sesion.beginTransaction();
			
			long numVehiculos = (Long) sesion.createQuery("SELECT count(*) FROM Vehiculo j")
					.uniqueResult();
				int numPaginas = (int) Math.ceil(numVehiculos/tamanyoPagina);

				Query query = (Query) sesion.createQuery("FROM Vehiculo v ORDER BY v.marca")
					.setMaxResults(tamanyoPagina);

				for (int i = 0; i < numPaginas; i++) {
				System.out.println("-- Página " + (i + 1) + " --");
				query.setFirstResult(i*tamanyoPagina);
				vehiculos = (query).list();
				for (Vehiculo vehiculo : vehiculos) {
					System.out.println(vehiculo);
				}
				}
			
			
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();

		}
		
		return vehiculos;
	}
	
	
	
	
	
}
