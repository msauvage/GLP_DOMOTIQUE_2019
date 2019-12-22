package elements;

import java.util.ArrayList;
//import java.util.NoSuchElementException;
import java.util.Scanner;

public class Dressing {

	private ArrayList<Tenue> tenues;
	
	public Dressing () {
		tenues= new ArrayList<Tenue>();
	}
	
	public void add(Tenue tenue) {
		tenues.add(tenue);
	}
	
	public void remove(Tenue tenue) {
		tenues.remove(tenue);
	}
	
	public void rechercheHaut() /* throws NoSuchElementException*/ {
		Scanner sc= new Scanner (System.in);
		System.out.println("Quel est le Haut recherché?");
		String haut = sc.nextLine();
		Tenue result = null;
		for (Tenue tenue : tenues) {
			if (tenue.getHaut().equals(haut)) {
				result = tenue;
				System.out.println("Le Haut:"+ haut+" est Disponible.");
			}
		}
		if (result == null) {
			/*throw new NoSuchElementException*/
			System.out.println("Le Haut :" + haut + " n'est Pas Disponible.");
		}// else {
		//	return result;
		//}
	}
	
	public void rechercheBas() {
		Scanner sc= new Scanner (System.in);
		System.out.println("Quel est le Bas recherché?");
		String bas = sc.nextLine();
		Tenue result = null;
		for (Tenue tenue : tenues) {
			if (tenue.getBas().equals(bas)) {
				result = tenue;
				System.out.println("Le Bas:"+ bas+" est Disponible.");
			}
		}
		if (result == null) {
			System.out.println("Le Bas :" + bas + " n'est Pas Disponible.");
		}
	}
	
	public void dispoTenue() {
		System.out.println("(Audio liste de tenues disponnible)");
	}
	
	public static void main(String[]args) {
	
		Tenue t1 = new Tenue("t-shirt blanc", "jean bleu", "converse");
		Tenue t2 = new Tenue("chemise rouge", "pantalon noir", "derbie");
		Dressing d=new Dressing();
		d.add(t1);
		d.add(t2);
		d.rechercheBas();
		d.rechercheBas();
		d.rechercheHaut();
		d.rechercheHaut();
		d.dispoTenue();		
	}
}
