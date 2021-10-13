package Classi;


public class Componenti {
	
	private String nomeComponente;
	private String CodiceFornitore;
	private String descrizione;
	private int quantita;
	private Tipologie tipologiaComponente;
	private Fornitori fornitoreComponente;
	private Caratteristiche caratteristicheComponente;
	private Scatole scatoloComponente;
	
	public Componenti(String nomeComponente, String CodiceFornitore, String descrizione, int quantita) {
		super();
		this.nomeComponente = nomeComponente;
		this.CodiceFornitore = CodiceFornitore;
		this.descrizione = descrizione;
		this.quantita = quantita;
	}
	
	public String getNomeComponente() {
		return nomeComponente;
	}
	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}
	public String getCodiceFornitore() {
		return nomeComponente;
	}
	public void setCodiceFornitore(String CodiceFornitore) {
		this.CodiceFornitore = CodiceFornitore;
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

	public Tipologie getTipologiaComponente() {
		return tipologiaComponente;
	}

	public void setTipologiaComponente(Tipologie tipologiaComponente) {
		this.tipologiaComponente = tipologiaComponente;
	}
	
	
	

}
