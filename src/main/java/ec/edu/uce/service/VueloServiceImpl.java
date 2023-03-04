package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IVueloRepo;
import ec.edu.uce.repository.modelo.CompraPasaje;
import ec.edu.uce.repository.modelo.Vuelo;
import ec.edu.uce.service.to.VueloReservarTO;
import ec.edu.uce.service.to.VueloTO;

@Service
public class VueloServiceImpl implements IVueloService{

	@Autowired
	IVueloRepo vueloRepo;
	
	@Autowired
	IAvionService avionService;
	
	@Autowired
	ICompraPasajeService compraPasajeService;
	
	@Override
	public void create(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.vueloRepo.create(vuelo);
	}

	@Override
	public Vuelo read(Integer id) {
		// TODO Auto-generated method stub
		return this.vueloRepo.read(id);
	}

	@Override
	public void update(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.vueloRepo.update(vuelo);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.vueloRepo.delete(id);
	}

	@Override
	public List<VueloTO> buscarDisponibles(String estado, String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		List<Vuelo> vuelosDisponibles=this.vueloRepo.buscarDisponibles(estado, origen, destino, fechaVuelo);
		return vuelosDisponibles.stream().map(v->this.convertirVueloTO(v)).collect(Collectors.toList());
	}

	@Override
	public Vuelo buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarNumero(numero);
	}
	
	
	public VueloTO convertirVueloTO(Vuelo vuelo) {
		VueloTO vueloTO=new VueloTO();
		vueloTO.setCategoria(vuelo.getCategoria());
		vueloTO.setDestino(vuelo.getDestino());
		vueloTO.setEstado(vuelo.getEstado());
		vueloTO.setNombreAvion(vuelo.getAvion().getNombre());
		vueloTO.setNumero(vuelo.getNumero());
		vueloTO.setOrigen(vuelo.getOrigen());
		vueloTO.setValorAsiento(vuelo.getValorAsiento());
		vueloTO.setFechaVuelo(vuelo.getFechaVuelo());
		return vueloTO;
	}
	
	public Vuelo convertirVuelo(VueloTO vueloTO) {
		Vuelo vuelo=new Vuelo();
		vuelo.setCategoria(vueloTO.getCategoria());
		vuelo.setDestino(vueloTO.getDestino());
		vuelo.setEstado(vueloTO.getEstado());
		if(this.avionService.buscarNombre(vueloTO.getNombreAvion())!=null){
		vuelo.setAvion(this.avionService.buscarNombre(vueloTO.getNombreAvion()));
		}
		vuelo.setNumero(vueloTO.getNumero());
		vuelo.setOrigen(vueloTO.getOrigen());
		vuelo.setValorAsiento(vueloTO.getValorAsiento());
		vuelo.setFechaVuelo(vueloTO.getFechaVuelo());
		return vuelo;
	}

	
	@Override
	public VueloReservarTO buscarVuelo(String numeroVuelo) {
		// TODO Auto-generated method stub
			
		
		return this.convertirVueloReservaTO(this.buscarNumero(numeroVuelo));
		
	}
	
	@Override
	public VueloReservarTO reservarPasajes(VueloReservarTO vueloReservarTO) {
		// TODO Auto-generated method stub
		Vuelo vuelo=this.buscarNumero(vueloReservarTO.getNumero());
		CompraPasaje compraPasaje=new CompraPasaje();
		compraPasaje.setEstado("R");//reservado
		compraPasaje.setCantidadAsientosComprados(vueloReservarTO.getCantidadAsientosComprados());
		compraPasaje.setFechaCompra(LocalDateTime.now());
		compraPasaje.setNumeroTarjeta(vueloReservarTO.getNumeroTarjeta());
		
		List<CompraPasaje> pasajesVuelo=vuelo.getPasajes();
		pasajesVuelo.add(compraPasaje);
		vuelo.setPasajes(pasajesVuelo);
		if((vuelo.getAsientosDisponibles()-vueloReservarTO.getCantidadAsientosComprados())>0) {
			vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles()-vueloReservarTO.getCantidadAsientosComprados());
			vuelo.setAsientosOcupados(vuelo.getAsientosOcupados()+vueloReservarTO.getCantidadAsientosComprados());
		}else if((vuelo.getAsientosDisponibles()-vueloReservarTO.getCantidadAsientosComprados())==0){
			vuelo.setEstado("ND");
		}
		this.update(vuelo);
		compraPasaje.setVuelo(vuelo);
		this.compraPasajeService.create(compraPasaje);
		
		compraPasaje.setNumero("000"+compraPasaje.getId());
		this.compraPasajeService.update(compraPasaje);
		return vueloReservarTO;
	
	}
	
	public VueloReservarTO convertirVueloReservaTO(Vuelo vuelo) {
		VueloReservarTO vueloReserva=new VueloReservarTO();
		vueloReserva.setAsientosDisponibles(vuelo.getAsientosDisponibles());
		vueloReserva.setAsientosOcupados(vuelo.getAsientosOcupados());
		/*List<CompraPasaje> pasajes=vuelo.getPasajes();
		if(pasajes!=null) {
			
		}*/
		
		
		
		
		return vueloReserva;
	}

}
