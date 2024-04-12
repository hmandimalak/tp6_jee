package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Medecin;
import util.JPAutil;
public class MedecinDaoImpl implements IMedecinDao {
private EntityManager entityManager=JPAutil.getEntityManager("tp5_jee");
@Override
public Medecin save(Medecin m) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(m);
	tx.commit();
	return m;
	}
	@Override
	public List<Medecin> MedecinsParMC(String mc) {
	List<Medecin> meds =
	entityManager.createQuery("select m from Medecin m where m.nomMedecin like :mc").setParameter("mc", "%"+mc+"%").getResultList();

	return meds;
	}
	@Override
	public Medecin getMedecin(Long id) {
	return entityManager.find(Medecin.class, id);
	}
	@Override
	public Medecin updateMedecin(Medecin m) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(m);
	tx.commit();
	return m;
	}
	@Override
	public void deleteMedecin(Long id) {
	Medecin Medecin = entityManager.find(Medecin.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(Medecin);
	entityManager.getTransaction().commit();
	}
	}
}
