package elements;

public class Ordinateur {
	
	private boolean etat=false;
	private String reseau=null;
	
	
	public boolean getEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public String getReseau() {
		return reseau;
	}

	public void setReseau(String reseau) {
		this.reseau = reseau;
	}

	public String toString() {
		return "Ordinateur [etat=" + etat + ", reseau=" + reseau + "]";
	}

	public static void main(String[] args) {
	
	}
}
