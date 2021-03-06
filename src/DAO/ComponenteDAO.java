package DAO;
import java.sql.SQLException;
import java.util.List;

import Classi.*;
public interface ComponenteDAO {
	
	List<Componenti> getTuttiComponenti() throws SQLException;	//Ottieni tutti i componenti
	List<Componenti> getComponentiMedianteCodiceFornitore(String codiceFornitore) throws SQLException;	//Ottieni tutti i componenti di un determinato Codice Fornitore
	public int deleteComponente(String ID) throws SQLException;	//Elimina un Componente
	public int saveComponente(Componenti componenteDaSalvare) throws SQLException;		//Salva un componente
	public int getQuantitaTotale() throws SQLException;									//Ottieni la quantita' totale dei componenti del magazzino
	public int getQuantitaSpecifica(String IDComponente) throws SQLException;				//Ottieni la quantita' specifica per un componente identificato da un ID
	public Componenti getSpecificComponente(String IDComponente) throws SQLException;		//Ottieni uno specifico componente
	
}
