package Classi;
import java.util.ArrayList;

public class Apparati {
	
	//Attributi
	private String nomeApparato;
	private String descrizione;
	private ArrayList<Schede> schedaInUso;
	
	//Costruttore Parametrizzato
	public Apparati(String nomeApparato, String descrizione) {
		super();
		this.nomeApparato = nomeApparato;
		this.descrizione = descrizione;
	}
	
	//Metodi
	public String getNomeApparato() {
		return nomeApparato;
	}

	public void setNomeApparato(String nomeApparato) {
		this.nomeApparato = nomeApparato;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public ArrayList<Schede> getSchedaInUso() {
		return schedaInUso;
	}

	public void setSchedaInUso(ArrayList<Schede> schedaInUso) {
		this.schedaInUso = schedaInUso;
	}
	
	
	
	//Metodi DAO
	

}
