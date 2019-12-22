package elements;

import java.util.Scanner;

public class Bain {
	
	private float temperature;
	private boolean etat=false;
	
	
	public void temp () {
		Scanner sc= new Scanner (System.in);
		System.out.println("Entrer la température souhaitée");
		int temp = sc.nextInt();
		setTemperature(temp);
	}
	
	public void marche() {
		 while(etat){
			for(int cmpt=0; cmpt<15; cmpt++) {
				System.out.println("(Emettre le bruit 'Eau qui coule')");	
			}
			setEtat(false);
			System.out.println("Le bain est Pret, à une Température de " + temperature+ " Degré.");
			System.out.println("Bon repos");
		}
	}

	public void vidage() {
		while(etat) {
			for (int cmpt=0; cmpt<15; cmpt++) {
				System.out.println("(Emettre le bruit de l'eau)");
			}
			setEtat(true);
			System.out.println("le bain est Vidé");
		}
	}
	
	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	public static void main(String[]args) {
		Bain b= new Bain();
		b.temp();
		b.marche();
	}
}
