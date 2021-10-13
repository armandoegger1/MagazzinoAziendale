package Classi;
public class Schede {
	private String nomeScheda;
	private Apparati apparatoCollegato;	//Riferimento alla scheda su quale apparato deve essere montato
	
	public Schede(String nomeScheda) {
		this.nomeScheda = nomeScheda;
	}

	public String getNomeScheda() {
		return nomeScheda;
	}

	public void setNomeScheda(String nomeScheda) {
		this.nomeScheda = nomeScheda;
	}
	
	public Apparati getApparatoCollegato() {
		return apparatoCollegato;
	}
	
	public void setApparatoCollegato(Apparati apparatoCollegato) {
		this.apparatoCollegato = apparatoCollegato;
	}
	
	
}


