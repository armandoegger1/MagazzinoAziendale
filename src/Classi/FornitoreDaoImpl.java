package Classi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.FornitoreDAO;
import DBConfigurazione.DBConnection;

public class FornitoreDaoImpl implements FornitoreDAO {
	
	private PreparedStatement getTuttiFornitoriPS, getFornitoriMedianteNomePS, deleteFornitorePS, saveFornitorePS, getQuantitaTotaleFornitoriPS;

	private Connection connection = DBConnection.getInstance().getConnection();
	
	public FornitoreDaoImpl() throws SQLException {
		getTuttiFornitoriPS = connection.prepareStatement("SELECT * FROM fornitori;");
		getFornitoriMedianteNomePS = connection.prepareStatement("SELECT * from fornitori where NomeFornitore=?");
		deleteFornitorePS = connection.prepareStatement("DELETE FROM fornitori where NomeFornitore=?");
		saveFornitorePS = connection.prepareStatement("INSERT INTO fornitori(NomeFornitore, Localita, Telefono, Email) VALUES(?,?,?,?)");
		getQuantitaTotaleFornitoriPS = connection.prepareStatement("SELECT COUNT(*) from fornitori");
	}

	@Override
	public List<Fornitori> getTuttiFornitori() throws SQLException {
		
		List<Fornitori> listaFornitori = new ArrayList<Fornitori>();
		
		ResultSet rs = getTuttiFornitoriPS.executeQuery();
		
		while(rs.next()) {
			Fornitori fornitoreCorrente = new Fornitori(rs.getString("NomeFornitore"), rs.getString("Localita"), rs.getString("Telefono"), rs.getString("Email"));
			fornitoreCorrente.setIDFornitore(rs.getInt("IDFornitore"));
			
			listaFornitori.add(fornitoreCorrente);
		}
		rs.close();
		
		return listaFornitori;
	}

	@Override
	public Fornitori getFornitoreMedianteNome(String nomeFornitore) throws SQLException {
		
		Fornitori fornitoreCorrente;
		
		ResultSet rs = getTuttiFornitoriPS.executeQuery();
		rs.next();
		
		fornitoreCorrente = new Fornitori(rs.getString("NomeFornitore"), rs.getString("Localita"), rs.getString("Telefono"), rs.getString("Email"));
		fornitoreCorrente.setIDFornitore(rs.getInt("IDFornitore"));
		rs.close();
		
		return fornitoreCorrente;
	}

	@Override
	public int deleteFornitore(String NomeFornitore) throws SQLException {
		
		deleteFornitorePS.setString(1, NomeFornitore);
		
		System.out.println(deleteFornitorePS.toString());
		
		int righeEliminate = deleteFornitorePS.executeUpdate();
		
		return righeEliminate;
		
	}

	@Override
	public int saveFornitore(Fornitori fornitoreDaSalvare) throws SQLException {
		int righeAggiunte = 0;
		
		saveFornitorePS.setString(1, fornitoreDaSalvare.getNomeFornitore());
		saveFornitorePS.setString(2, fornitoreDaSalvare.getLocalita());
		saveFornitorePS.setString(3, fornitoreDaSalvare.getTelefono());
		saveFornitorePS.setString(4, fornitoreDaSalvare.getEmail());
		
		System.out.println(saveFornitorePS.toString() + fornitoreDaSalvare.toString());
				
		righeAggiunte = saveFornitorePS.executeUpdate();
		
		return righeAggiunte;
	}

	@Override
	public int getQuantitaTotaleFornitori() throws SQLException {
		
		int contaRighe;
		
		ResultSet rs = getQuantitaTotaleFornitoriPS.executeQuery();
		rs.next();
		
		contaRighe = rs.getInt(1);
		rs.close();
		
		return contaRighe;
	}

}
