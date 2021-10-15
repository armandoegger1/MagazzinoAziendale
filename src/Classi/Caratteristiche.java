package Classi;
public class Caratteristiche {
	
	private int IDCaratteristica;
	private String nomeCaratteristica;
	private String valore;	/*Valore di tipo string perché posso creare anche campi che devono avere un valore testuale e non numerico*/
	private String Descrizione;
	
	public Caratteristiche(String nomeCaratteristica, String valore, String descrizione) {
		super();
		this.nomeCaratteristica = nomeCaratteristica;
		this.valore = valore;
		Descrizione = descrizione;
	}

	public String getNomeCaratteristica() {
		return nomeCaratteristica;
	}

	public void setNomeCaratteristica(String nomeCaratteristica) {
		this.nomeCaratteristica = nomeCaratteristica;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}

	public int getIDCaratteristica() {
		return IDCaratteristica;
	}

	public void setIDCaratteristica(int iDCaratteristica) {
		IDCaratteristica = iDCaratteristica;
	}
	
	
	

}
