package Classi;
public class Tipologie {
	
	private int IDTipologia;
	private String nomeTipologia;
	private String descrizione;
	
	public Tipologie(String nomeTipologia, String descrizione) {
		this.nomeTipologia = nomeTipologia;
		this.descrizione = descrizione;
	}

	public String getNomeTipologia() {
		return nomeTipologia;
	}

	public void setNomeTipologia(String nomeTipologia) {
		this.nomeTipologia = nomeTipologia;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getIDTipologia() {
		return IDTipologia;
	}

	public void setIDTipologia(int iDTipologia) {
		IDTipologia = iDTipologia;
	}

}
