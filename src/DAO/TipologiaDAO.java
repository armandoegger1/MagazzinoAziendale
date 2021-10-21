package DAO;

import java.sql.SQLException;
import java.util.List;

import Classi.Tipologie;

public interface TipologiaDAO {
	
	List<Tipologie> getTutteTipologie() throws SQLException;
	int deleteTipologa(int ID) throws SQLException;
	int saveTipologia(Tipologie tipologiaDaSalvare) throws SQLException;
	int contaTipologie() throws SQLException;

}
