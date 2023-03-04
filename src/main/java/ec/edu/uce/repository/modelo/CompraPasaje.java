package ec.edu.uce.repository.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "compra_pasaje")
public class CompraPasaje {
	@Id
	@Column(name = "copa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_copa")
	@SequenceGenerator(name = "seq_copa", sequenceName = "seq_copa", allocationSize = 1)
	private Integer id;
	
	@Column(name = "copa_numero")
	private String numero;
	
	@Column(name = "copa_fecha_compra", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaCompra;
	
	@Column(name = "copa_numero_tarjeta")
	private String numeroTarjeta;
	
	@Column(name = "copa_cantidad_asientos_comprados")
	private Integer cantidadAsientosComprados;
	
	@Column(name = "copa_estado")
	private String estado; //Reservado (R) Checkin (I)
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compra_fk_vuelo")
	private Vuelo vuelo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compra_fk_cliente")
	private Cliente cliente;

	
	//getters y setters

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public Integer getCantidadAsientosComprados() {
		return cantidadAsientosComprados;
	}


	public void setCantidadAsientosComprados(Integer cantidadAsientosComprados) {
		this.cantidadAsientosComprados = cantidadAsientosComprados;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "CompraPasaje [id=" + id + ", numero=" + numero + ", fechaCompra=" + fechaCompra + ", numeroTarjeta="
				+ numeroTarjeta + ", cantidadAsientosComprados=" + cantidadAsientosComprados + ", estado=" + estado
				+ "]";
	}
	
	
	

}
