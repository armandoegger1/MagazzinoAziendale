package Classi;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import DAO.ComponenteDAO;

import DBConfigurazione.*;
public class ComponentiDaoImpl implements ComponenteDAO {
	
	
	private PreparedStatement getTuttiComponentiPS, getComponentiMedianteCodiceFornitorePS, deleteComponentePS, saveComponentePS, getQuantitaTotalePS, getSpecificComponentePS,
		getQuantitaSpecificaPS;

	private Connection connection = DBConnection.getInstance().getConnection();
	
	public ComponentiDaoImpl() throws SQLException {
		
		
		getComponentiMedianteCodiceFornitorePS = connection.prepareStatement("SELECT * FROM componenti WHERE CodiceFornitore LIKE ?;");
		getQuantitaTotalePS = connection.prepareStatement("SELECT SUM(Quantita) AS QuantitaTotale FROM componenti;");
		getSpecificComponentePS = connection.prepareStatement("SELECT * FROM componenti WHERE IDComponente=?;");
		getQuantitaSpecificaPS = connection.prepareStatement("SELECT Quantita FROM componenti WHERE IDComponente =?;");
		saveComponentePS = connection.prepareStatement("INSERT INTO componenti(CodiceComponente, CodiceFornitore, Descrizione, Quantita, ID_Tipologia, ID_Caratteristica, ID_Fornitore, ID_Scatolo) VALUES(?, ?, ?, ?, ? ,? ,? ,?);");
		
	}

	@Override
	public List<Componenti> getTuttiComponenti() throws SQLException {
		
		List<Componenti> listaComponenti = new ArrayList<Componenti>();
		
		getTuttiComponentiPS = connection.prepareStatement("SELECT * FROM componenti;");
		
		ResultSet rs = getTuttiComponentiPS.executeQuery();
		
		while(rs.next()) {
			Componenti componenteCorrente = new Componenti(rs.getString("CodiceComponente"), rs.getString("CodiceFornitore"), rs.getString("Descrizione"), rs.getInt("Quantita"));
			componenteCorrente.setIDComponente(rs.getInt("IDComponente"));
			
			listaComponenti.add(componenteCorrente);
		}
		rs.close();
		
		return listaComponenti;
	}

	@Override
	public List<Componenti> getComponentiMedianteCodiceFornitore(String codiceFornitore) throws SQLException {
		
		List<Componenti> listaComponenti = new ArrayList<Componenti>();
		
		getComponentiMedianteCodiceFornitorePS.setString(1, codiceFornitore);	//Inserimento del codice fornitore nello statement della query
		ResultSet rs = getComponentiMedianteCodiceFornitorePS.executeQuery();	//Esecuzione della query
		
		//Fetch del risultato
		while(rs.next()) {
			Componenti componenteCorrente = new Componenti(rs.getString("CodiceComponente"), rs.getString("CodiceFornitore"), rs.getString("Descrizione"), rs.getInt("Quantita"));
			componenteCorrente.setIDComponente(rs.getInt("IDComponente"));
			/**
			 * ottenere gli oggetti ID Tipologia, ID Caratteristica, ID Fornitore, ID Scatolo
			 * componenteCorrente.setTipologiaComponente(oggetto.getID()); (FORSEEE???')**/
			listaComponenti.add(componenteCorrente);	//Salvataggio del risultato in una collection
		}
		rs.close();	//Chiusura connessione
			
		return listaComponenti;	//Ritorno la lista dei componenti recuperata dal RDBMS
	}

	@Override
	public void deleteComponente(String ID) throws SQLException {
		
		deleteComponentePS = connection.prepareStatement("DELETE FROM componenti WHERE IDComponente=?");
		
		deleteComponentePS.setString(1, ID);
		
		System.out.println(deleteComponentePS.toString());
		
		deleteComponentePS.executeUpdate();
		
		
	}

	@Override
	public int saveComponente(Componenti componenteDaSalvare) throws SQLException {
		
		int righeAggiunte = 0;
		
		saveComponentePS.setString(1, componenteDaSalvare.getNomeComponente());
		saveComponentePS.setString(2, componenteDaSalvare.getCodiceCostruttore());
		saveComponentePS.setString(3, componenteDaSalvare.getDescrizione());
		saveComponentePS.setInt(4, componenteDaSalvare.getQuantita());
		//saveComponentePS.setInt(5, componenteDaSalvare.getTipologiaComponente().getIDTipologia());
		//saveComponentePS.setInt(6, componenteDaSalvare.getCaratteristicheComponente().getIDCaratteristica());
		//saveComponentePS.setInt(7, componenteDaSalvare.getFornitoreComponente().getIDFornitore());
		//saveComponentePS.setInt(8, componenteDaSalvare.getScatoloComponente().getIDScatola());
		
		saveComponentePS.setInt(5, 1);
		saveComponentePS.setInt(6, 1);
		saveComponentePS.setInt(7, 1);
		saveComponentePS.setInt(8, 1);
		
		righeAggiunte = saveComponentePS.executeUpdate();
		
		return righeAggiunte;
		
	}

	@Override
	public int getQuantitaTotale() throws SQLException {
		ResultSet rs = getQuantitaTotalePS.executeQuery();
		
		return rs.getInt(0);
	}

	@Override
	public int getQuantitaSpecifica(int IDComponente) throws SQLException {
		getQuantitaSpecificaPS.setInt(1, IDComponente);
		
		ResultSet rs = getQuantitaSpecificaPS.executeQuery();
		return rs.getInt(0);
	}

	@Override
	public Componenti getSpecificComponente(int IDComponente) throws SQLException {
		
		Componenti c;
		getSpecificComponentePS.setInt(0, IDComponente);
		ResultSet rs = getSpecificComponentePS.executeQuery();
		
		c = new Componenti(rs.getString("CodiceComponente"), rs.getString("CodiceFornitore"), rs.getString("Descrizione"), rs.getInt("Quantita"));
		
		return c;
	}

}
