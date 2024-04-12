package dao;
import java.util.List;
import metier.entities.Faculte;
public interface IFaculteDao {
public Faculte save(Faculte fac);
public Faculte getFaculte(Long id);
public Faculte updateFaculte(Faculte fac);
public void deleteFaculte(Long id);
public List<Faculte> getAllFacultes();
}