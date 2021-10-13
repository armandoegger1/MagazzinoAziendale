package Classi;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import DAO.ComponenteDAO;

public class ComponentiDao implements ComponenteDAO {
	
	
	private Connection connection;
	
	private PreparedStatement getTuttiComponentiPS, getComponentiMedianteCodiceFornitorePS, deleteComponentePS, saveComponentePS, getQuantitaTotalePS, getSpecificComponentePS,
		getQuantitaSpecificaPS;
	
	public ComponentiDao(Connection connection) throws SQLException {
		this.connection = connection;
		getTuttiComponentiPS = connection.prepareStatement("SELECT * FROM componenti;");
		getComponentiMedianteCodiceFornitorePS = connection.prepareStatement("SELECT * FROM componenti WHERE CodiceFornitore LIKE '?';");
		getQuantitaTotalePS = connection.prepareStatement("SELECT SUM(Quantita) FROM componenti;");
		getSpecificComponentePS = connection.prepareStatement("SELECT * FROM componenti WHERE IDComponente = ?;");
		getQuantitaSpecificaPS = connection.prepareStatement("SELECT Quantita FROM componenti WHERE IDComponente  = ?;");
		saveComponentePS = connection.prepareStatement("INSERT INTO componenti VALUES(?, ?, ?, ?, ? ,? ,? ,?);");
		deleteComponentePS = connection.prepareStatement("DELETE FROM CUSTOMERS WHERE ID = ?");
	}

	@Override
	public List<Componenti> getTuttiComponenti() throws SQLException {
		
		List<Componenti> listaComponenti = new ArrayList<Componenti>();
		
		ResultSet rs = getTuttiComponentiPS.executeQuery();
		
		while(rs.next()) {
			Componenti componenteCorrente = new Componenti(rs.getString("CodiceComponente"), rs.getString("CodiceFornitore"), rs.getString("Descrizione"), rs.getInt("Quantita"));
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
			listaComponenti.add(componenteCorrente);	//Salvataggio del risultato in una collections
		}
		rs.close();	//Chiusura connessione
			
		return listaComponenti;	//Ritorno la lista dei componenti recuperata dal RDBMS
	}

	@Override
	public int deleteComponente(Componenti componenteDaEliminare)  {
		return 0;
		
		// TODO Auto-generated method stub

	}

	@Override
	public int saveComponente(Componenti componenteDaSalvare) throws SQLException {
		
		/*
		saveComponentePS.setString(1, componenteDaSalvare.getNomeComponente());
		saveComponentePS.setString(2, componenteDaSalvare.getCodiceFornitore());
		saveComponentePS.setString(3, componenteDaSalvare.getDescrizione());
		saveComponentePS.setInt(4, componenteDaSalvare.getQuantita());
		saveComponentePS.setInt(5, componenteDaSalvare.getTipologiaComponente().getIDTipologia());
		saveComponentePS.setInt(6, componenteDaSalvare.getFornitoreComponente().getIDFornitore());
		saveComponentePS.setInt(7, componenteDaSalvare.getFornitoreComponente().getIDFornitore());
		saveComponentePS.setInt(8, componenteDaSalvare.getFornitoreComponente().getIDFornitore());
		
		saveComponentePS.executeQuery();
		*/
		return 0;
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
