package Classi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CaratteristicaDAO;
import DBConfigurazione.DBConnection;

public class CaratteristicheDaoImpl implements CaratteristicaDAO {
	
	private PreparedStatement getTutteCaratteristichePS, getCaratteristicaSpecificaPS,deleteCaratteristicaPS, saveCaratteristicaPS,getQuantitaTotaleCaratteristichePS;
	private Connection connection = DBConnection.getInstance().getConnection();
	
	public CaratteristicheDaoImpl()throws SQLException  {
		
		getTutteCaratteristichePS = connection.prepareStatement("SELECT * FROM caratteristiche");
		getCaratteristicaSpecificaPS = connection.prepareStatement("SELECT * FROM caratteristiche WHERE IDCaratteristica=?");
		deleteCaratteristicaPS = connection.prepareStatement("DELETE FROM caratteristiche WHERE IDCaratteristica=?");
		saveCaratteristicaPS = connection.prepareStatement("INSERT INTO caratteristiche(NomeCaratteristica, Valore, Descrizione) VALUES(?,?,?);");
		getQuantitaTotaleCaratteristichePS = connection.prepareStatement("SELECT COUNT(*) FROM caratteristiche");
	}

	@Override
	public List<Caratteristiche> getTutteCaratteristiche() throws SQLException {
		
		List<Caratteristiche> listaCaratteristiche = new ArrayList<Caratteristiche>();
		
		ResultSet rs = getTutteCaratteristichePS.executeQuery();
		
		while(rs.next()) {
			Caratteristiche c = new Caratteristiche(rs.getString("NomeCaratteristica"), rs.getString("Valore"), rs.getString("Descrizione"));
			c.setIDCaratteristica(rs.getInt("IDCaratteristica"));
			
			listaCaratteristiche.add(c);
		}
		
		rs.close();
		return listaCaratteristiche;
	}

	@Override
	public int deleteCaratteristica(int IDCaratteristica) throws SQLException {
		
		int righeEliminate;
		
		deleteCaratteristicaPS.setInt(1, IDCaratteristica);
		
		righeEliminate = deleteCaratteristicaPS.executeUpdate();
		
		return righeEliminate;
	}

	@Override
	public int saveCaratteristica(Caratteristiche caratteristicaDaSalvare) throws SQLException {
		
		int righeAggiunte;
		
		saveCaratteristicaPS.setString(1, caratteristicaDaSalvare.getNomeCaratteristica());
		saveCaratteristicaPS.setString(2, caratteristicaDaSalvare.getValore());
		saveCaratteristicaPS.setString(3, caratteristicaDaSalvare.getDescrizione());
		
		righeAggiunte = saveCaratteristicaPS.executeUpdate();
		return righeAggiunte;
	}

	@Override
	public int getQuantitaTotaleCaratteristiche() throws SQLException {
		
		int quantitaTotale;
		
		ResultSet rs  = getQuantitaTotaleCaratteristichePS.executeQuery();
		rs.next();
		
		quantitaTotale = rs.getInt(1);
		
		rs.close();
		
		return quantitaTotale;
	}
	
	@Override
	public Caratteristiche getCaratteristicaSpecifica(int ID) throws SQLException {
		getCaratteristicaSpecificaPS.setInt(1, ID);
		
		ResultSet rs = getCaratteristicaSpecificaPS.executeQuery();
		rs.next();
		
		
		Caratteristiche caratteristicaRecuperata = new Caratteristiche(rs.getString("NomeCaratteristica"), rs.getString("Valore"), rs.getString("Descrizione"));
		caratteristicaRecuperata.setIDCaratteristica(rs.getInt("IDCaratteristica"));
		rs.close();
		
		return caratteristicaRecuperata;
		
	}

}
