package DAO;

import java.sql.SQLException;
import java.util.List;

import Classi.Fornitori;

public interface FornitoreDAO {

	List<Fornitori> getTuttiFornitori() throws SQLException;	//Ottieni tutti i componenti
	Fornitori getFornitoreMedianteNome(String nomeFornitore) throws SQLException;	//Ottieni tutti i componenti di un determinato Codice Fornitore
	public int deleteFornitore(String NomeFornitore) throws SQLException;	//Elimina un Componente
	public int saveFornitore(Fornitori fornitoreDaSalvare) throws SQLException;		//Salva un componente
	public int getQuantitaTotaleFornitori() throws SQLException;									//Ottieni la quantita' totale dei componenti del magazzino
	
}
