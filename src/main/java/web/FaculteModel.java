package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Faculte;

public class FaculteModel {
	List<Faculte> Facultes = new ArrayList<>();

	public List<Faculte> getFacultes() {
		return Facultes;
	}

	public void setFacultes(List<Faculte> Facultes) {
		this.Facultes = Facultes;
	}
}