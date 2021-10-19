package DAO;

import java.sql.SQLException;
import java.util.List;

import Classi.Caratteristiche;

public interface CaratteristicaDAO {

	
	List<Caratteristiche> getTutteCaratteristiche() throws SQLException;	//Ottieni tutti i componenti
	public int deleteCaratteristica(String NomeFornitore) throws SQLException;	//Elimina un Componente
	public int saveCaratteristica(Caratteristiche caratteristicaDaSalvare) throws SQLException;		//Salva un componente
	public int getQuantitaTotaleCaratteristiche() throws SQLException;									//Ottieni la quantita' totale dei componenti del magazzino
	
}
