package ec.edu.ups.est.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEUDA")
public class Deuda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDeuda;
	
	@Column(name="NUMERO", length = 50, nullable = false, unique = true)
	private String numero;
	
	@Column(name="FECHA", length=100, nullable=false, unique=false)
	private Date fecha;
	
	@Column(name="MONTO", length=100, nullable=false, unique=false)
	private float monto;
	
	
	public int getIdDeuda() {
		return idDeuda;
	}

	public void setIdDeuda(int idDeuda) {
		this.idDeuda = idDeuda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
}
