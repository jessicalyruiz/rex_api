package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.repository.modelo.Cliente;
import ec.edu.uce.repository.modelo.Vuelo;
import ec.edu.uce.service.to.VueloReservarTO;
import ec.edu.uce.service.to.VueloTO;

public interface IVueloService {

	public void create(Vuelo vuelo);
	public Vuelo read(Integer id); 
	public void update(Vuelo vuelo); 
	public void delete(Integer id); 
	
	public List<VueloTO> buscarDisponibles(String estado, String origen, String destino, LocalDateTime fechaVuelo);
	public Vuelo buscarNumero(String numero);
	public VueloReservarTO reservarPasajes(VueloReservarTO vueloReservarTO);
	VueloReservarTO buscarVuelo(String numeroVuelo);
	
}
