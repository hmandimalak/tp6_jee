package dao;
import java.util.List;
import metier.entities.Medecin;
public interface IMedecinDao {
public Medecin save(Medecin m);
public List<Medecin> MedecinsParMC(String mc);
public Medecin getMedecin(Long id);
public Medecin updateMedecin(Medecin m);
public void deleteMedecin(Long id);
}
