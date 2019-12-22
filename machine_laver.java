package elements;

import java.util.Scanner;

public class MachineALaver {

	private float temperature;
	private int duree ; // en minute
	//	private String notification; // sonnerie de type son 
	private boolean etat=true;

	
	public void marche() {
		 while(etat){
		for(int cmpt=0; cmpt<duree; cmpt++) {
			System.out.println("(Emettre Bruit Machine à Laver)");	
		}
		setEtat(false);
		System.out.println("Machine Terminée à une Température de " + temperature + " Degré et pour une Durée de "
		+ duree + " minutes");
		}
	}
	
	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public static void main(String[]args) {
		MachineALaver m = new MachineALaver ();
		Scanner sc= new Scanner (System.in);
		System.out.println("Entrer la Température de lavage souhaitée");
		int temp = sc.nextInt();
		m.setTemperature(temp);
		Scanner sc1= new Scanner (System.in);
		System.out.println("Entrer la Durée de lavage souhaitée");
		int duree = sc1.nextInt();
		m.setDuree(duree);
		m.marche();
	}
}
