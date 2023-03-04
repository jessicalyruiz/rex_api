package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.CompraPasaje;

public interface ICompraPasajeService {

	public void create(CompraPasaje compraPasaje);
	public CompraPasaje read(Integer id); 
	public void update(CompraPasaje compraPasaje); 
	public void delete(Integer id); 
	
	public CompraPasaje buscarNumero(String numero);
	
	public void realizarCheckin(String numero);
}
