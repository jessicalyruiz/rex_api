package ec.edu.uce.repository;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.uce.repository.modelo.CompraPasaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class CompraPasajeRepoImpl implements ICompraPasajeRepo{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.persist(compraPasaje);
	}

	@Override
	public CompraPasaje read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CompraPasaje.class, id);
	}

	@Override
	public void update(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.merge(compraPasaje);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public CompraPasaje buscarNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CompraPasaje> myqQuery=this.entityManager.createQuery("Select p from CompraPasaje p where p.numero=:valor", CompraPasaje.class);
		myqQuery.setParameter("valor", numero);
		return myqQuery.getSingleResult();
	}

	
	
}
