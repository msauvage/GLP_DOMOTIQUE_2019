package elements.cuisine;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import elementsprocess.Programmer;

public class Cafetiere {
	
	/*
	 * Au début, on donne l'Heure à laquelle la Cafetière doit se Lancer + son Dosage.
	 * Tant qu'on ne redonne pas d'autres "indications" (nouvelle Heure, nouveau Dosage),
	 * la Cafetière  se lance à l'Heure programmée.
	 * A la fin, elle émet un Signal comme quoi "le Café est Prêt".
	 * 
	 */

	
	private String heureProg;
	private String htoday;
	private String dose;
	
	
	private DateFormat formatdate = new SimpleDateFormat("hh-mm-ss");
	private Programmer programme = new Programmer();
	
	public Cafetiere() {
		
	}
	
	public String toString() {
		return "Cafetiere [Dose: "+dose+", Programm�e pour "+heureProg+"]";
	}
	
	public void setHeureProg (String heureProg) {
			this.heureProg=heureProg;
		
	}
	
	public void setHToday (String hToday) {
		this.htoday=hToday;
	}
	
	public void setDose (String dose) {
		this.dose=dose;
	}
	
	
	public void Lancer(String htoday, String programme) {
		if(this.programme.Test(htoday, programme)) {
			System.out.println("Prêt");
			System.out.println(toString());
		}
		else {
			System.out.println("pas pres");
		}
	}
	
	public static void main(String[] args) throws ParseException {
		Cafetiere cafetiere = new Cafetiere();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Heure à Programmer:");
		/*HEURE A DONNNER */cafetiere.setHeureProg(sc.nextLine());
	
		System.out.println("Heure Programmée: "+cafetiere.heureProg);
		
		cafetiere.htoday="14-14-15";
		
		System.out.println("Heure Actuelle: "+cafetiere.htoday);
		
		/*
		System.out.println("Jour: "+jour.getDate());
		
		System.out.println(jour.getHours()+"h "+jour.getMinutes()+"min "+jour.getSeconds()+"s");
		// System.out.println(jour.ge
		*/
		
		// String dose="1 sachet de caf�";
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Dosage choisi :");
		/*DOSE A DONNER */cafetiere.setDose(sc1.nextLine());
		// System.out.println("Vous avez saisi : " + dose);
		
		
		/*
		System.out.println("Date Programm�e: "+programme);
		System.out.println("Heure actuelle: "+htoday);
		*/
		System.out.println(cafetiere.toString());
		cafetiere.Lancer(cafetiere.htoday, cafetiere.heureProg);
	}
}
