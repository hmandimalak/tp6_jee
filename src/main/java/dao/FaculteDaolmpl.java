package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Faculte;
import util.JPAutil;

public class FaculteDaolmpl implements IFaculteDao {
	private EntityManager entityManager = JPAutil.getEntityManager("tp5_jee");

	@Override
	public Faculte save(Faculte fac) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(fac);
		tx.commit();
		return fac;
	}

	@Override
	public Faculte getFaculte(Long id) {
		return entityManager.find(Faculte.class, id);
	}

	@Override
	public Faculte updateFaculte(Faculte fac) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(fac);
		tx.commit();
		return fac;
	}

	@Override
	public void deleteFaculte(Long id) {
		Faculte Faculte = entityManager.find(Faculte.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(Faculte);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Faculte> getAllFacultes() {
		List<Faculte> facs =

				entityManager.createQuery("select c from Faculte c").getResultList();
		return facs;
	}
}