package ec.edu.ups.est.dao;

import java.util.List;

import ec.edu.ups.est.model.Deuda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DeudasDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Deuda deuda) {
		em.persist(deuda);
	}
	
	public void update(Deuda deuda) {
		em.merge(deuda);
	}
	
	public void remove(int codigo){
		Deuda deuda = em.find(Deuda.class, codigo);
		em.refresh(deuda);		
	}
	
	public Deuda read(int codigo) {
		Deuda deuda = em.find(Deuda.class, codigo);
		return deuda;
	}
	
	public List<Deuda> getAll(){
		String jpql = "SELECT c FROM Cabecera_Factura c";
		Query q = em.createQuery(jpql, Deuda.class);
		return q.getResultList();
	}
	
}
