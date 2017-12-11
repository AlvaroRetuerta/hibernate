package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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
	
	//metodo para listar los vehiculos que han sido alquilados por un cliente c
	public List<Vehiculo> listadoByIdCliente(int idCliente) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
	
		try {
			
			sesion.beginTransaction();
			vehiculos = sesion.createQuery("select marca, modelo, matricula from vehiculo join alquiler on (alquiler.idVehiculo=vehiculo.idVehiculo) where (alquiler.idCliente ="+idCliente+");").list();
			sesion.getTransaction().commit();
			System.out.println("OK");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();

		}
		return vehiculos;
	}
	
	
	
}
