package ec.edu.uce.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelo")
public class Vuelo {

	@Id
	@Column(name = "vuel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vuelo")
	@SequenceGenerator(name = "seq_vuelo", sequenceName = "seq_vuelo", allocationSize = 1)
	private Integer id;
	
	@Column(name = "vuel_numero")
	private String numero;
	
	@Column(name = "vuel_fecha_vuelo", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaVuelo;
	
	@Column(name = "vuel_asientos_disponible")
	private Integer asientosDisponibles;
	
	@Column(name = "vuel_asientos_ocupados")
	private Integer asientosOcupados;
	
	@Column(name = "vuel_valor_asiento")
	private BigDecimal valorAsiento;
	
	@Column(name = "vuel_estado")
	private String estado;
	
	@Column(name = "vuel_origen")
	private String origen;
	
	@Column(name = "vuel_destino")
	private String destino;
	
	@Column(name = "vuel_categoria")
	private String categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vuel_fk_avion")
	private Avion avion;
	
	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
	List<CompraPasaje> pasajes;

	
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

	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<CompraPasaje> getPasajes() {
		return pasajes;
	}

	public void setPasajes(List<CompraPasaje> pasajes) {
		this.pasajes = pasajes;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

	public Integer getAsientosOcupados() {
		return asientosOcupados;
	}

	public void setAsientosOcupados(Integer asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", numero=" + numero + ", fechaVuelo=" + fechaVuelo + ", asientosDisponibles="
				+ asientosDisponibles + ", valorAsiento=" + valorAsiento + ", estado=" + estado + ", origen=" + origen
				+ ", destino=" + destino + ", categoria=" + categoria + "]";
	}
	
	
	
}
