package elements;

public class Mail {
	
	private String destinataire;
	private String objet;
	private String message;
	private boolean lu=false;
	
	
	public Mail(String destinataire, String objet, String message) {
		super();
		this.destinataire = destinataire;
		this.objet = objet;
		this.message = message;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public static void main(String[] args) {
	
	}
}
