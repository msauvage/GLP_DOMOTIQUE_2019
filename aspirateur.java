package elements;

import java.util.Scanner;

public class Aspirateur {

	private boolean etat;
	private Horloge heurep;
	private Horloge heureActuelle;
	
	Aspirateur (boolean etat){
		this.etat=etat;
	}
	
	public void programmerLavage () {
		Scanner sc= new Scanner (System.in);
		System.out.println("Entrer l'Heure souhaitée ");
		int hc = sc.nextInt();
		heurep.setHeure(hc);
		System.out.println("Entrer la Minute souhaitée ");
		int minc= sc.nextInt();
		heurep.setMinute(minc);
		System.out.println("Entrer la Seconde souhaitée ");
		int secc= sc.nextInt();
		heurep.setSeconde(secc);
	}

	public void allumerP () {
		if (heureActuelle.getHeure()==heurep.getHeure()&& heureActuelle.getMinute()==heurep.getMinute()
				&& heureActuelle.getSeconde()==heurep.getSeconde()) {
		}
	}
}
