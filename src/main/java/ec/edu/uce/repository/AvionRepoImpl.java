package ec.edu.uce.repository;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.uce.repository.modelo.Avion;
import ec.edu.uce.repository.modelo.Vuelo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class AvionRepoImpl implements IAvionRepo{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(avion);
	}

	@Override
	public Avion read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Avion.class, id);
	}

	@Override
	public void update(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(avion);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public Avion buscarNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Avion> myqQuery=this.entityManager.createQuery("Select a from Avion a where a.nombre=:valor", Avion.class);
		myqQuery.setParameter("valor", nombre);
		List<Vuelo> vuelos=myqQuery.getSingleResult().getVuelos();
		for ( Vuelo vuelo : vuelos) {
			System.out.println(vuelo);
		}

		return myqQuery.getSingleResult();
	}

	
	
}
