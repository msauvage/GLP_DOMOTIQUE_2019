package elementsprocess;

import java.util.Scanner;

public class Minuteur {
	private CounterUpdate hour;
	private CounterUpdate minute;
	private CounterUpdate second;
	private int h;
	private int m;
	private int s;
	private static int t=0;
	
	/**
	 * 
	 * @param h: Configuration du nombre d'Heures
	 * @param m: Configuration du nombre de Minutes
	 * @param s: Configuration du nombre de Secondes
	 */
	public Minuteur(int h, int m, int s) {
		hour = new CounterUpdate(0, 99);
		minute = new CounterUpdate(0, 59);
		second = new CounterUpdate(0, 59);

		this.h=h;
		this.m=m;
		this.s=s;
		// Conversion de la dur�e donn�e en Secondes
		this.t=h*60*60+m*60+s;
		
		// Initialisation de la Dur�e du Minuteur
		initialisation();
	}
	
	public void initialisation() {
		for (int i = 1; i <= t; i++) {
			tformat();
		}
	}
	
	// Obtention de la Dur�e en Seconde
	public int getT() {
		return this.t;
	}
	
	// pour la vitesse � laquelle le temps passe
	private static final int CHRONO_SPEED = 1000;
	
	/**
	 * 
	 * @param t: Lancement du Minuteur, à partir de la durée convertie en Secondes
	 * @return: si le Minuteur atteint 0,0,0
	 */
	public boolean lancement() {
		 while (this.t>=0) {
			 	// Affichage du Minuteur
				System.out.println(toString());
			try {
				Thread.sleep(CHRONO_SPEED);
			} 
			catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			// le Temps s'écoule
			ecoulement();
			// le nombres de Secondes diminue
			t--;
		}
			System.out.println("Le Temps est écoulé");
			return true;
	}
	
	// Pour l'Initialisation du Minuteur
	public void tformat() {
		second.increment();
		if (second.getValue() == 0) {
			minute.increment();
			if (minute.getValue() == 0) {
				hour.increment();
			}
		}
	}
	
	// Pour l'�coulement des Secondes
	public void ecoulement() {
		second.decrement();
		if (second.getValue() == 59) {
			minute.decrement();
			if (minute.getValue() == 59) {
				hour.decrement();
			}
		}
	}
	
	// Pour Afficher le Minuteur
	public String toString() {
		return "Minuteur de " + hour.getValue() +" heure(s), "+ minute.getValue() + " minute(s), "
				+ second.getValue() + " seconde(s)";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Heure(s): ");
		int h=sc.nextInt();
		System.out.print("Minute(s): ");
		int m=sc.nextInt();
		System.out.print("Seconde(s): ");
		int s=sc.nextInt();

		Minuteur minuteur = new Minuteur(h,m,s);

		System.out.println(minuteur.toString());
		
		System.out.println("Initialisation du Minuteur");
		
		// minuteur.initialisation(t);
		System.out.println("t="+minuteur.getT()+"s");
		
		// 1er Affichage du Minuteur
		System.out.println(minuteur.toString());
		
		System.out.println("Lancement du Minuteur");
		minuteur.lancement();
	}
}
