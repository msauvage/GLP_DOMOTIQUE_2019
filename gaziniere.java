package elements.cuisine;

import java.util.Scanner;

import elementsprocess.Minuteur;

public class Gaziniere {
	/*
	 * La gazinière pourra être lancée poir voix Vocale afin de gérer le préchauffage,
	 * la Température et le Minuteur.
	 * (Préchauffe du four avec la température, Cuisson (minuteur))
	 */
	
	public String temperature;
	public Minuteur minuteur;
	
	public Gaziniere() {
		
	}
	
	// Afficher les "informations" de la Gaziniere
	public String toString() {
		return "Gaziniere [Prechauffage à "+temperature+" °C, avec "+this.minuteur.toString()+"]";
	}
	
	public void setMinuteur(int h, int m, int s) {
		this.minuteur=new Minuteur(h,m,s);
	}
	// Pour Initialiser et Lancer le Minuteur de la Gaziniere
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaziniere g= new Gaziniere();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Heure(s): ");
		int h=sc.nextInt();
		System.out.print("Minute(s): ");
		int m=sc.nextInt();
		System.out.print("Seconde(s): ");
		int s=sc.nextInt();
		
		g.minuteur = new Minuteur(h,m,s);
		
		// String temperature = "30";
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Temperature (en °C) :");
		g.temperature = sc1.nextLine();
		// System.out.println("Vous avez saisi : " + dose);
		
		//Gaziniere gaziniere = new Gaziniere();
		System.out.println(g.toString());
		System.out.println("Lancement du Minuteur");

		// Affichage de la Dur�e Convertie en Secondes
		while(!g.minuteur.lancement()) {
			System.out.println("non");
		}
		
		// g.minuteur.lancement(g.minuteur.getT());
		System.out.println("La Cuisson est Terminée");
		System.out.println("EMETTRE UN SON");
	}
}
