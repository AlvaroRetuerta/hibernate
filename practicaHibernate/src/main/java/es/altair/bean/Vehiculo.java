package es.altair.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

@Entity
@Table(name="vehiculo")
//@ScriptAssert.List({
//	@ScriptAssert(lang="javascript", script="(_this.matricula /\\d{4}^[A-Za-z]{3}$/)? true : false", message="La matricula no es correcta")
//})// /^[A-Za-z]{4}\d{4}$/   /\d{4}^[A-Za-z]{3}$/
public class Vehiculo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVehiculo;
	private String marca;
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "idOficina")
	private Oficina oficina;
	
	@Size(min=7, max=7)
	private String matricula;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="alquiler", joinColumns=@JoinColumn(name="idVehiculo"), inverseJoinColumns=@JoinColumn(name="idCliente"))
	private Set<Cliente> clientes = new HashSet<Cliente>();
	
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public Vehiculo(String marca, String modelo, Oficina oficina, String matricula, Set<Cliente> clientes) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.oficina = oficina;
		this.matricula = matricula;
		this.clientes = clientes;
	}

	public Vehiculo(int idVehiculo, String marca, String modelo, Oficina oficina, String matricula,
			Set<Cliente> clientes) {
		super();
		this.idVehiculo = idVehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.oficina = oficina;
		this.matricula = matricula;
		this.clientes = clientes;
	}

	public Vehiculo(String marca, String modelo, Oficina oficina, String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.oficina = oficina;
		this.matricula = matricula;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", oficina=" + oficina
				+ ", matricula=" + matricula + "]";
	}
	
	
	
}
