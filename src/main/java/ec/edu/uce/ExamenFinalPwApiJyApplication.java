package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.repository.modelo.Avion;
import ec.edu.uce.repository.modelo.Vuelo;
import ec.edu.uce.service.IAvionService;

@SpringBootApplication
public class ExamenFinalPwApiJyApplication implements CommandLineRunner{

	@Autowired
	IAvionService avionService;
	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalPwApiJyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		Avion a1=new Avion();
		a1.setCapacidadAsientos(250);
		a1.setNombre("force1");
		
		//negocios
		Vuelo v1=new Vuelo();
		v1.setAsientosDisponibles(50);
		v1.setAvion(a1);
		v1.setCategoria("N");
		v1.setDestino("new york");
		v1.setEstado("D");
		v1.setFechaVuelo(LocalDateTime.of(2023, 04, 01, 12, 0));
		v1.setNumero("N1");
		v1.setOrigen("quito");
		v1.setValorAsiento(new BigDecimal(2000));
		
		//Turista
		Vuelo v2=new Vuelo();
		v2.setAsientosDisponibles(100);
		v2.setAvion(a1);
		v2.setCategoria("T");
		v2.setDestino("new york");
		v2.setEstado("D");
		v2.setFechaVuelo(LocalDateTime.of(2023, 04, 01, 12, 0));
		v2.setNumero("N1");
		v2.setOrigen("quito");
		v2.setValorAsiento(new BigDecimal(1000));
		
		//Economica
		Vuelo v3=new Vuelo();
		v3.setAsientosDisponibles(100);
		v3.setAvion(a1);
		v3.setCategoria("E");
		v3.setDestino("new york");
		v3.setEstado("D");
		v3.setFechaVuelo(LocalDateTime.of(2023, 04, 01, 12, 0));
		v3.setNumero("N1");
		v3.setOrigen("quito");
		v3.setValorAsiento(new BigDecimal(500));
				
		List<Vuelo> vuelos=new ArrayList<>();
		vuelos.add(v1);
		vuelos.add(v2);
		vuelos.add(v3);
		
		a1.setVuelos(vuelos);
		
		this.avionService.create(a1);
		
		*/
		//this.avionService.delete(1);
		//this.avionService.delete(2);
	}

}
