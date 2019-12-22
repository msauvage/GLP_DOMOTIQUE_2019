package elements;

public class Lumiere {
	private boolean etat;
	
	
	public Lumiere(){
		this.etat=true;
	}
	
	public void allumer() {
		if (this.etat) {
			System.out.println("La lumiére est Déjà Allumée");
		}else {
			etat=true;
			System.out.println("La lumiére s'Allume");
		}
	}
	
	public void eteindre() {
		if (this.etat) {			
			etat=false;
			System.out.println("La lumiére s'éteint");
			
		}else {
			System.out.println("La lumiére est Déjà éteinte");
		}
	}

	public String getEtat() {
		if (this.etat) {
			return "on";
		}else {	
			return "off";
		}
	}
	
	public static void main(String[] args) {
		Lumiere lumiere = new Lumiere();
		lumiere.allumer();
		lumiere.eteindre();
		System.out.println(lumiere.getEtat());
		lumiere.allumer();
		System.out.println(lumiere.getEtat());	
	}
}
