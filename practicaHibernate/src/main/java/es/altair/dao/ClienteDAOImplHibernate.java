package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Cliente;
import es.altair.bean.Oficina;

public class ClienteDAOImplHibernate implements ClienteDAO {

	public void save(Cliente c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
		
			sesion.beginTransaction();
			sesion.save(c);
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}

	public Cliente get(int i) {
		Cliente c = null;
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			c = sesion.get(Cliente.class, i);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		return c;
	}

	
	

	public void delete(Cliente c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(c);
			
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
		Cliente c = get(i);
		try {
			sesion.beginTransaction();
			
			sesion.delete(c);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}


	public List<Cliente> listado() {
		List<Cliente> clientes = new ArrayList<Cliente>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			clientes = sesion.createQuery("FROM Cliente c").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();

		}
		return clientes;
	}


	public void update(Cliente c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.update(c);

			sesion.getTransaction().commit();
		} catch (Exception ex) {

		} finally {
			sesion.close();
			sf.close();
		}

	}

}
