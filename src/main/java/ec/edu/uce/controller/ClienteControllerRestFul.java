package ec.edu.uce.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.uce.service.IVueloService;
import ec.edu.uce.service.to.VueloReservarTO;
import ec.edu.uce.service.to.VueloTO;

@RestController
@RequestMapping(path = "/clientes")
@CrossOrigin("http://localhost:8080/")
public class ClienteControllerRestFul {
	
	@Autowired
	IVueloService vueloService;
	
	
	//1a
	@GetMapping(path = "/vuelosDisponibles")
	public List<VueloTO>  buscarVuelosDisponibles(@RequestParam String estado,@RequestParam String origen, @RequestParam String destino, @RequestParam LocalDateTime fechaVuelo) {
		return this.vueloService.buscarDisponibles(estado, origen, destino, fechaVuelo);
	}
	
	//1.b: Reservar pasajes aéreos
	@GetMapping(path = "/pasajes/{numero}")
	public VueloReservarTO buscarPasajeReservar(@PathVariable("numero") String numeroVuelo) {
		VueloReservarTO vueloReserva=this.vueloService.buscarVuelo(numeroVuelo);
		if(vueloReserva.getEstado().equalsIgnoreCase("D")) {
			return vueloReserva;
		}else {
			vueloReserva.setAsientosDisponibles(100000);
			return vueloReserva;
		}
		
	}
	
	@PostMapping(path = "/pasajes/")
	public VueloReservarTO realizarReserva(@RequestBody VueloReservarTO vueloReserva) {
		return this.vueloService.reservarPasajes(vueloReserva);
	}
	
}
