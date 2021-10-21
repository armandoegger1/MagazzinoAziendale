package Classi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.TipologiaDAO;
import DBConfigurazione.DBConnection;

public class TipologiaDaoImpl implements TipologiaDAO {
	
	private PreparedStatement getTutteTipologiePS, deleteTipologaPS, saveTipologiaPS, contaTipologiePS;
	private Connection connection = DBConnection.getInstance().getConnection();
	
	public TipologiaDaoImpl() throws SQLException {
		
		getTutteTipologiePS = connection.prepareStatement("SELECT * FROM tipologie");
		deleteTipologaPS = connection.prepareStatement("DELETE FROM tipologie WHERE IDTipologia=?");
		saveTipologiaPS = connection.prepareStatement("INSERT INTO tipologie(NomeTipologia, Descrizione) VALUES(?,?)");
		contaTipologiePS = connection.prepareStatement("SELECT COUNT(*) FROM tipologie");
		
	}

	@Override
	public List<Tipologie> getTutteTipologie() throws SQLException {
		
		List<Tipologie> tipologieRecuperate = new ArrayList<Tipologie>();
		
		ResultSet rs = getTutteTipologiePS.executeQuery();
		
		while(rs.next()) {
			Tipologie tipologiaRecuperata = new Tipologie(rs.getString("NomeTipologia"), rs.getString("Descrizione"));
			
			tipologieRecuperate.add(tipologiaRecuperata);
		}
		rs.close();
		return tipologieRecuperate;
	}

	@Override
	public int deleteTipologa(int ID) throws SQLException {

		int righeEliminate;
		
		deleteTipologaPS.setInt(1, ID);
		righeEliminate = deleteTipologaPS.executeUpdate();
		
		return righeEliminate;
	}

	@Override
	public int saveTipologia(Tipologie tipologiaDaSalvare) throws SQLException {
		
		int righeAggiunte;
		saveTipologiaPS.setString(1, tipologiaDaSalvare.getNomeTipologia());
		saveTipologiaPS.setString(2, tipologiaDaSalvare.getDescrizione());
		
		System.out.println(saveTipologiaPS.toString());
		
		righeAggiunte = saveTipologiaPS.executeUpdate();
		
		return righeAggiunte;
	}
	
	@Override
	public int contaTipologie() throws SQLException {
		
		int tipologiePresenti;
		
		ResultSet rs = contaTipologiePS.executeQuery();
		rs.next();
		tipologiePresenti = rs.getInt(1);
		
		rs.close();
		
		return tipologiePresenti;
	}

}
