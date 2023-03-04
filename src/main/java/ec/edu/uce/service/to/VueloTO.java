package ec.edu.uce.service.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VueloTO {
	private String numero;
	private String estado;
	private String origen;
	private String destino;
	private String categoria;
	private String nombreAvion;
	private BigDecimal valorAsiento;
	private LocalDateTime fechaVuelo;
	
	//getters and setters
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getNombreAvion() {
		return nombreAvion;
	}
	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}
	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}
	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}
	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	
	
	
}
