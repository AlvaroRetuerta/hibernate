package es.altair.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="oficina")
public class Oficina {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOficina;
	private String ciudad;
	private String direccion;
	
	@OneToMany(mappedBy="oficina", cascade=CascadeType.PERSIST)
	private Set<Vehiculo> vehiculos;
	
	
	
	
	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Oficina() {
		// TODO Auto-generated constructor stub
	}

	public Oficina(int idOficina, String ciudad, String direccion) {
		super();
		this.idOficina = idOficina;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	public Oficina(String ciudad, String direccion) {
		super();
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	public int getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Oficina [idOficina=" + idOficina + ", ciudad=" + ciudad + ", direccion=" + direccion+ "]";
	}
	
	
	
	
}
