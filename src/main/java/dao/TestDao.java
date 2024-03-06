package dao;
import java.util.List;
import metier.entities.Medecin;
public class TestDao {
public static void main(String[] args) {
MedecinDaoImpl pdao= new MedecinDaoImpl();
Medecin med= pdao.save(new Medecin("salma","pediatre","fmt"));
System.out.println(med);
List<Medecin> meds =pdao.MedecinsParMC("dentiste");
for (Medecin m : meds)
System.out.println(m);
}
}