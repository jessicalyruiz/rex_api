package ec.edu.uce.service.to;

public class VueloReservarTO {

	private String numero;
	private String estado;//Disponible, ND
	private Integer asientosDisponibles;
	private Integer asientosOcupados;
	private Integer cantidadAsientosComprados;
	private String numeroTarjeta;
	
	
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
	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}
	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}
	public Integer getAsientosOcupados() {
		return asientosOcupados;
	}
	public void setAsientosOcupados(Integer asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}
	public Integer getCantidadAsientosComprados() {
		return cantidadAsientosComprados;
	}
	public void setCantidadAsientosComprados(Integer cantidadAsientosComprados) {
		this.cantidadAsientosComprados = cantidadAsientosComprados;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	
	
}
