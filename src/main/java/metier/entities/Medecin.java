package metier.entities;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
@Entity



public class Medecin implements Serializable{
	
	@Id
	@Column (name="ID_MEDECIN")
	private Long idMedecin;
	@Column (name="NOM_MEDECIN")
	private String nomMedecin;
	private String specialite;
	private String faculte;
	public Medecin() {
		super();
	}
	public Medecin(String nomMedecin, String specialite,String faculte) {
		super();
		this.nomMedecin = nomMedecin;
		this.specialite = specialite;
		this.faculte=faculte;
	}
	
	public Long getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}
	public String getNomMedecin() {
		return nomMedecin;
	}
	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}
	public String getspecialite() {
		return specialite;
	}
	public void setspecialite(String specialite) {
		this.specialite = specialite;
	}
	@Override
	public String toString() {
		return "Medecin [idMedecin=" + idMedecin + ", nomMedecin=" + nomMedecin + ", specialite=" + specialite + "]";
	}

}

