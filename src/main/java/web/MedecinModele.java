package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Medecin;
public class MedecinModele {
private String motCle;
List<Medecin> Medecins = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Medecin> getMedecins() {
return Medecins;
}
public void setMedecins(List<Medecin> Medecins) {
this.Medecins = Medecins;
}
}
