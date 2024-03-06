package metier.entities;

import java.io.Serializable;
public class Medecin implements Serializable{
	private Long idMedecin;
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
	public String getFaculte() {
		return faculte;
	}
	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}
	@Override
	public String toString() {
		return "Medecin [idMedecin=" + idMedecin + ", nomMedecin=" + nomMedecin + ", specialite=" + specialite
				+ ", faculte=" + faculte + "]";
	}

}

