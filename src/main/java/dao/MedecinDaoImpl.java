package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.entities.Medecin;

public class MedecinDaoImpl implements IMedecinDao {

	@Override
	public Medecin save(Medecin m) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Medecin(NOM_MEDECIN,PRIX) VALUES(?,?)");
			ps.setString(1, m.getNomMedecin());
			ps.setString(2, m.getFaculte());
			ps.setString(2, m.getspecialite());
			
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_MEDECIN) as MAX_ID FROM Medecin");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				m.setIdMedecin(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Medecin> MedecinsParMC(String mc) {
	      List<Medecin> meds= new ArrayList<Medecin>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from Medecin where NOM_MEDECIN LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Medecin m = new Medecin();
				m.setIdMedecin(rs.getLong("ID_MEDECIN"));
				m.setNomMedecin(rs.getString("NOM_MEDECIN"));
				m.setFaculte(rs.getString("FACULTE"));
				m.setspecialite(rs.getString("SPECIALITE"));
				meds.add(m);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return meds;
	}

	@Override
	public Medecin getMedecin(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		    Medecin m = new Medecin();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from Medecin where ID_MEDECIN = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				m.setIdMedecin(rs.getLong("ID_Medecin"));
				m.setNomMedecin(rs.getString("NOM_Medecin"));
				m.setFaculte(rs.getString("FACULTE"));
				m.setspecialite(rs.getString("SPECIALITE"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return m;
	}

	@Override
	public Medecin updateMedecin(Medecin m) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE Medecin SET NOM_MEDECIN=?,FACULTE=? SPECIALITE=? WHERE ID_MEDECIN=?");
			ps.setString(1, m.getNomMedecin());
			ps.setString(2, m.getFaculte());
			ps.setString(3, m.getspecialite());
			ps.setLong(4, m.getIdMedecin());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void deleteMedecin(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM Medecin WHERE ID_MEDECIN = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();	
		}
	}

}