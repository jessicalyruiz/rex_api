package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.ICompraPasajeRepo;
import ec.edu.uce.repository.modelo.CompraPasaje;
import ec.edu.uce.service.to.CompraPasajeTo;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService{

	@Autowired
	ICompraPasajeRepo compraPasajeRepo;
	
	@Override
	public void create(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.compraPasajeRepo.create(compraPasaje);
	}

	@Override
	public CompraPasaje read(Integer id) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepo.read(id);
	}

	@Override
	public void update(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.compraPasajeRepo.update(compraPasaje);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.compraPasajeRepo.delete(id);
	}

	@Override
	public CompraPasaje buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepo.buscarNumero(numero);
	}


	
	@Override
	public void realizarCheckin(String numero) {
		// TODO Auto-generated method stub
		CompraPasaje pasaje=this.buscarNumero(numero);
		pasaje.setEstado("I");
		this.update(pasaje);
	}
	
	
	
	

}
