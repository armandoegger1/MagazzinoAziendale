package Classi;


public class Componenti {
	
	private int IDComponente;
	private String nomeComponente;
	private String codiceCostruttore;
	private String descrizione;
	private int quantita;
	private Tipologie tipologiaComponente;
	private Fornitori fornitoreComponente;
	private Caratteristiche caratteristicheComponente;
	private Scatole scatoloComponente;
	
	public Componenti(String nomeComponente, String codiceCostruttore, String descrizione, int quantita) {
		super();
		this.nomeComponente = nomeComponente;
		this.codiceCostruttore = codiceCostruttore;
		this.descrizione = descrizione;
		this.quantita = quantita;
	}

	public int getIDComponente() {
		return IDComponente;
	}

	public void setIDComponente(int iDComponente) {
		IDComponente = iDComponente;
	}

	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	public String getCodiceCostruttore() {
		return codiceCostruttore;
	}

	public void setCodiceCostruttore(String codiceCostruttore) {
		this.codiceCostruttore = codiceCostruttore;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Tipologie getTipologiaComponente() {
		return tipologiaComponente;
	}

	public void setTipologiaComponente(Tipologie tipologiaComponente) {
		this.tipologiaComponente = tipologiaComponente;
	}

	public Fornitori getFornitoreComponente() {
		return fornitoreComponente;
	}

	public void setFornitoreComponente(Fornitori fornitoreComponente) {
		this.fornitoreComponente = fornitoreComponente;
	}

	public Caratteristiche getCaratteristicheComponente() {
		return caratteristicheComponente;
	}

	public void setCaratteristicheComponente(Caratteristiche caratteristicheComponente) {
		this.caratteristicheComponente = caratteristicheComponente;
	}

	public Scatole getScatoloComponente() {
		return scatoloComponente;
	}

	public void setScatoloComponente(Scatole scatoloComponente) {
		this.scatoloComponente = scatoloComponente;
	}
	
	
	
	
	
	

}
