package ec.edu.ups.est.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	
	@Column(name="NOMBRE", length=100, nullable=false, unique=false)
	private String nombre;
	
	@Column(name="DIRECCION", length=100, nullable=false, unique=false)
	private String direccion;
	
	@Column(name="DNI", length=15, nullable=false, unique=true)
	private String dni;

	
	@JoinColumn(name = "CODIGO_DEUDA")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Deuda> deudas;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Deuda> getDeudas() {
		return deudas;
	}

	public void setDeudas(List<Deuda> deudas) {
		this.deudas = deudas;
	}
	
	

}
