package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import es.altair.bean.Oficina;

public class OficinaDAOImplHibernate implements OficinaDAO {

	
	public void save (Oficina f) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
		
			sesion.beginTransaction();
			sesion.save(f);
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}
	
	
	
	public Oficina get(int i) {
		Oficina o = null;
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			o = sesion.get(Oficina.class, i);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		return o;
	}

	
	
	public void delete(Oficina o) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(o);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}
	
	
	
	public List<Oficina> listado() {
		List<Oficina> oficinas = new ArrayList<Oficina>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			oficinas = sesion.createQuery("FROM Oficina o").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();

		}
		return oficinas;
	}
	
	
	public void update(Oficina o) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			sesion.update(o);

			sesion.getTransaction().commit();
		} catch (Exception ex) {

		} finally {
			sesion.close();
			sf.close();
		}

	}
	
	
	
	
	
}
