package Driver;
import GUI.*;
import DBConfigurazione.*;

import java.sql.*;

import javax.swing.JFrame;
//import org.mariadb.*;

public class Main {
    
    //Dichiarazioni dei Frame
	/*Creazione*/
    SchermataHome frameHome;
    SchermataApparato frameApparato;
    SchermataFornitore frameFornitore;
    SchermataComponenti frameComponente;
    SchermataScatola frameScatola;
    SchermataScheda frameScheda;
    SchermataCaratteristica frameCaratteristica;
    SchermataTipologia frameTipologia;
    
    /*Eliminaione*/
    SchermataEliminaComponente frameEliminaComponente;
    
 

    public static void main(String[] args) {
    	
    	/*Inizio connessione al DB*/
    	DBConnection dbConnection = null;
    	Connection connection = null;
    	
    	try {
			dbConnection = DBConnection.getInstance();
			connection = dbConnection.getConnection();
			
			System.out.println("La connessione ottenuta e': "+connection.toString());
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	/*Fine connessione al DB*/
    	
    	/*Creazione della prima GUI*/
        Main controller = new Main();
    	

        
        
    }
    
    /*Riferimenti e salti per le gui*/
    public Main() {
    	frameHome = new SchermataHome(this);
    	frameHome.setVisible(true);
    }
    
    public void CreaApparato() {
    	frameHome.setVisible(false);
    	frameApparato = new SchermataApparato(this);
    	frameApparato.setVisible(true);
    }
    
    public void CreaFornitore() {
    	frameHome.setVisible(false);
    	frameFornitore = new SchermataFornitore(this);
    	frameFornitore.setVisible(true);
    }
    
    public void CreaComponente() {
    	frameHome.setVisible(false);
    	frameComponente = new SchermataComponenti(this);
    	frameComponente.setVisible(true);
    }
    
    public void CreaScatola() {
    	frameHome.setVisible(false);
    	frameScatola = new SchermataScatola(this);
    	frameScatola.setVisible(true);
    }
    
    public void CreaScheda() {
    	frameHome.setVisible(false);
    	frameScheda = new SchermataScheda(this);
    	frameScheda.setVisible(true);
    }
    
    public void CreaCaratteristica() {
    	frameHome.setVisible(false);
    	frameCaratteristica = new SchermataCaratteristica(this);
    	frameCaratteristica.setVisible(true);
    }
    
    public void CreaTipologia() {
    	frameHome.setVisible(false);
    	frameTipologia = new SchermataTipologia(this);
    	frameTipologia.setVisible(true);
    }
    
    public void Ritorno(JFrame frameCorrente) {
    	frameCorrente.setVisible(false);
    	frameHome.setVisible(true);
    }
    
    public void EliminaComponente() {
    	frameHome.setVisible(false);
    	frameEliminaComponente = new SchermataEliminaComponente(this);
    	frameEliminaComponente.setVisible(true);
    }
}