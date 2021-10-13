package Classi;

public class Fornitori {
	
	private int IDFornitore;
	private String nomeFornitore;
	private String localita;
	private String telefono;
	private String email;
	
	public Fornitori(String nomeFornitore, String localita) {
		super();
		this.nomeFornitore = nomeFornitore;
		this.localita = localita;
	}

	public String getNomeFornitore() {
		return nomeFornitore;
	}

	public void setNomeFornitore(String nomeFornitore) {
		this.nomeFornitore = nomeFornitore;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIDFornitore() {
		return IDFornitore;
	}

	public void setIDFornitore(int iDFornitore) {
		IDFornitore = iDFornitore;
	}
	
	
	

}
