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
    SchermataCreazioneFornitore frameFornitore;
    SchermataCreazioneComponenti frameComponente;
    SchermataScatola frameScatola;
    SchermataScheda frameScheda;
    SchermataCreazioneCaratteristica frameCaratteristica;
    SchermataCreazioneTipologia frameTipologia;
    
    /*Mostra*/
    SchermataMostraComponenti frameMostraComponenti;
    SchermataMostraFornitori frameMostraFornitori;
    SchermataMostraCaratteristiche frameMostraCaratteristiche;
    SchermataMostraTipologie frameMostraTipologie;
    
    /*Eliminaione*/
    SchermataEliminaComponente frameEliminaComponente;
    SchermataEliminaFornitore frameEliminaFornitore;
    SchermataEliminaCaratteristica frameEliminaCaratteristica;
    SchermataEliminaTipologia frameEliminaTipologia;
    
    /*Recupero degli oggetti*/
    SchermataRecuperaComponenti frameRecuperoComponenti;
    
 

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
    	frameFornitore = new SchermataCreazioneFornitore(this);
    	frameFornitore.setVisible(true);
    }
    
    public void CreaComponente() {
    	frameHome.setVisible(false);
    	frameComponente = new SchermataCreazioneComponenti(this);
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
    	frameCaratteristica = new SchermataCreazioneCaratteristica(this);
    	frameCaratteristica.setVisible(true);
    }
    
    public void CreaTipologia() {
    	frameHome.setVisible(false);
    	frameTipologia = new SchermataCreazioneTipologia(this);
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
    
    public void MostraComponenti() {
    	frameHome.setVisible(false);
    	frameMostraComponenti = new SchermataMostraComponenti(this);
    	frameMostraComponenti.setVisible(true);
    }
    public void RecuperoComponentiQuantita() {
    	frameHome.setVisible(false);
    	frameRecuperoComponenti = new SchermataRecuperaComponenti(this);
    	frameRecuperoComponenti.setVisible(true);
    }
    
    public void EliminaFornitore() {
    	frameHome.setVisible(false);
    	frameEliminaFornitore = new SchermataEliminaFornitore(this);
    	frameEliminaFornitore.setVisible(true);
    }
    
    public void MostraFornitori() {
    	frameHome.setVisible(false);
    	frameMostraFornitori = new SchermataMostraFornitori(this);
    	frameMostraFornitori.setVisible(true);
    }
    
    public void EliminaCaratteristica() {
    	frameHome.setVisible(false);
    	frameEliminaCaratteristica = new SchermataEliminaCaratteristica(this);
    	frameEliminaCaratteristica.setVisible(true);
    }
    
    public void MostraCaratteristiche() {
    	frameHome.setVisible(false);
    	frameMostraCaratteristiche = new SchermataMostraCaratteristiche(this);
    	frameMostraCaratteristiche.setVisible(true);
    }
    
    public void EliminaTipologia() {
    	frameHome.setVisible(false);
    	frameEliminaTipologia = new SchermataEliminaTipologia(this);
    	frameEliminaTipologia.setVisible(true);
    }
    
    public void MostraTipologie() {
    	
    	frameHome.setVisible(false);
    	frameMostraTipologie = new SchermataMostraTipologie(this);
    	frameMostraTipologie.setVisible(true);
    }
}