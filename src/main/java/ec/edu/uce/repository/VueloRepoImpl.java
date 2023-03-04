package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;


import ec.edu.uce.repository.modelo.CompraPasaje;
import ec.edu.uce.repository.modelo.Vuelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class VueloRepoImpl implements IVueloRepo{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);
	}

	@Override
	public Vuelo read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vuelo.class, id);
	}

	@Override
	public void update(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public List<Vuelo> buscarDisponibles(String estado, String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery=this.entityManager.createQuery("Select v from Vuelo v where v.estado=:valor1 and v.origen=:valor2 and v.destino=:valor3 and v.fechaVuelo=:valor4",Vuelo.class);
		myQuery.setParameter("valor1", estado);
		myQuery.setParameter("valor2",origen );
		myQuery.setParameter("valor3",destino );
		myQuery.setParameter("valor4", fechaVuelo);
		List<Vuelo> vuelos=myQuery.getResultList();
		if(vuelos!=null) {
			for (Vuelo vuelo : vuelos) {
				System.out.println(vuelo.getPasajes());
			}
		}
		
		return myQuery.getResultList();
	}

	@Override
	public Vuelo buscarNumero(String numero) {
		TypedQuery<Vuelo> myQuery=this.entityManager.createQuery("Select v from Vuelo v where v.numero=:valor", Vuelo.class);
		myQuery.setParameter("valor", numero);
		return myQuery.getSingleResult();
	}

}
