package elements;

import java.util.ArrayList;
import java.util.Iterator;


public class Television {
	private boolean etat=false;
	private ArrayList<Chaine> chaines;
	
	public Television () {
		chaines= new ArrayList<Chaine>();
		Chaine c1 = new Chaine("tf1", "1");
		Chaine c2 = new Chaine("M6","6");
		chaines.add(c1);
		chaines.add(c2);
	}

	public void add(Chaine chaine) {
		chaines.add(chaine);
	}
	
	public String rechercheChaine(String numero) {
		Chaine result = null;
		Iterator<Chaine> iterator = chaines.iterator();
		while (iterator.hasNext()) {
			Chaine chaine = iterator.next();
			if (chaine.getNumero().equals(numero)) {
				result = chaine;
				return "vous regardez"+result+"actuellement";
			}
		}
		return "chaine introuvable";
	}
	
	public void remove(Chaine chaine) {
		chaines.remove(chaine);
	}
	
	public String allumer() {
		if (!etat) {
			this.etat=true;
			return"Tele allumer";
		}
		return "tele deja allumer";
	}
	
	public String eteindre() {
		if(etat) {
			this.etat=false;
			return "Tele eteinte";
		}
		return "tele deja eteinte";
	}
	
	public static void main(String[]args) {
		Television tv=new Television();
		System.out.println(tv.eteindre());
		System.out.println(tv.allumer());
		System.out.println(tv.allumer());
		System.out.println( tv.rechercheChaine("1"));
		System.out.println( tv.rechercheChaine("10"));
	}
}
