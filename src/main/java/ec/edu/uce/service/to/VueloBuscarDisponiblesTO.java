package ec.edu.uce.service.to;

import java.time.LocalDateTime;

public class VueloBuscarDisponiblesTO {

	private String estado;
	private String origen;
	private String destino;
	private LocalDateTime fechaVuelo;
	
	
	//getter y setters
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
	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	
	
	
}
