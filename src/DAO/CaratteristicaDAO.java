package DAO;

import java.sql.SQLException;
import java.util.List;

import Classi.Caratteristiche;

public interface CaratteristicaDAO {

	
	List<Caratteristiche> getTutteCaratteristiche() throws SQLException;	//Ottieni tutte le caratteristiche
	public int deleteCaratteristica(int IDCaratteristica) throws SQLException;	//Elimina una Caratteristica
	public int saveCaratteristica(Caratteristiche caratteristicaDaSalvare) throws SQLException;		//Salva una Caratteristica
	public int getQuantitaTotaleCaratteristiche() throws SQLException;									//Ottieni la quantita' totale delle caratteristiche
	public Caratteristiche getCaratteristicaSpecifica(int ID) throws SQLException; //Ottieni una cerca caratteristica
}
