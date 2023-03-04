package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.uce.service.ICompraPasajeService;
@RestController
@RequestMapping(path = "/empleados")
@CrossOrigin("http://localhost:8080/")
public class EmpleadosControllerRestFul {

	@Autowired
	ICompraPasajeService compraPasajeService;
	//2.a: Realizar Check-in
	@PostMapping(path = "pasajes/{numero}")
	public void realizarCheckin(@PathVariable("numero") String numero) {
		this.compraPasajeService.realizarCheckin(numero);
	}
}
