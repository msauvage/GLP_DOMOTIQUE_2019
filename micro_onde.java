package elements.cuisine;

import java.util.Scanner;

import elementsprocess.Minuteur;

public class MicroOnde {
	private Minuteur minuteur;
	// private boolean r=false;
	
	public MicroOnde() {
		
	}
	
	public MicroOnde(Minuteur minuteur /*, boolean r */) {
		this.minuteur=minuteur;
		// this.r=r;
	}
	
	/**
	 * Pour Initialiser et Lancer le Minuteur du Micro-Onde
	 *
	 * 
	 * @param r: Allumage si le Micro-Onde est Plein
	 * @return 
	 */
	public void allumage(boolean r) {
		test(r);
		if(r) {
			// Demande de la Dur�e souhait�e
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.print("Heure(s): ");
			int h=sc.nextInt();
			System.out.print("Minute(s): ");
			int m=sc.nextInt();
			System.out.print("Seconde(s): ");
			int s=sc.nextInt();
			
			Minuteur minuteur = new Minuteur(h,m,s);
			
			// Afficher la Dur�e Convertie en Secondes
			int t=minuteur.getT();
			
			// Affichage du Minuteur
			System.out.println(minuteur.toString());
			
			MicroOnde microOnde = new MicroOnde(minuteur);
			
			// System.out.println("Initialisation du Minuteur");
			
			// minuteur.initialisation(t);
			// System.out.println("t="+t);
			
			// System.out.println(minuteur.toString());
						
			System.out.println("Lancement du Minuteur");
			minuteur.lancement();
			
			// 1�re "notification"
			System.out.println("La Cuisson est Terminée");
			System.out.println("(EMETTRE UN SON)");
			
			microOnde.notification();
		}
		else {
			
		}
	}
	
	/**
	 * 
	 * @param r: Tester si le Micro-Onde est Plein ou pas
	 * @return: Renvoie une "r�ponse"
	 * 
	 */
	public boolean test(boolean r) {
		if(r) {
			System.out.println("Le Mico-onde est Plein");
			return true;
		}
		else {
			System.out.println("Le Micro-onde est Vide");
			System.out.println("Veuillez Remplir le Micro-onde");
		}
		return false;
	}
	
	/*
	 * 
	 * Si le Micro-Onde est bien Rempli, on appelle la fonction minuteur.
	 * � la fin du minuteur, le Micro-Onde envoie une "notification", tant qu'il n�a pas �t� Ouvert.
	 * 
	 */
	
	// Notification de la Fin du Minuteur
	public void notification() {
		
		// Notification à 3 reprises
		for(int i=1;i<=3;i++) {
			// Interval de 10 secondes entre 2 Notifications
			Minuteur minuteur = new Minuteur(0,0,10);
			int t=minuteur.getT();
			
			// System.out.println("Initialisation du Minuteur");
			
			// minuteur.initialisation(t);
			// System.out.println("t="+t);
			
			// System.out.println(minuteur.toString());
			
			// Lancement des 10 secondes
			minuteur.lancement();
			
			// Nouvelle notification
			System.out.println("La Cuisson est Terminée");
			System.out.println("(EMETTRE UN SON)");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MicroOnde microOnde = new MicroOnde();
		
		microOnde.allumage(true);
		// microOnde.notification();
	}
}
