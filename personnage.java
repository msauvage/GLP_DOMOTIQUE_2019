package data;

import java.awt.Image;
import java.awt.Paint;

import elementsprocess.Utile;
import gui.management.MainGUI;
import gui.management.MenuGUI;

/*
 * Classe contenant une position
 * Gestion des Déplacements
*/

public class Personnage {

	private Position pos;
	public Image imgPerso1;
	public Image imgPerso2;
	public Image imgPerso3;
	public Image imgPerso4;
	public static Personnage getPersonnage;

	public Personnage(Position pos) {
		super();
		this.pos = pos;
		imgPerso1 = Utile.readImage("src/image/persoBas/perso1.png");
		imgPerso2 = Utile.readImage("src/image/persoBas/perso2.png");
		imgPerso3 = Utile.readImage("src/image/persoBas/perso3.png");
		imgPerso4 = Utile.readImage("src/image/persoBas/perso4.png");
		getPersonnage = this;
	}

	public Position getPos() {
		return pos;
		
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public void monter() {
		imgPerso1 = Utile.readImage("src/image/persoHaut/perso1.png");
		imgPerso2 = Utile.readImage("src/image/persoHaut/perso2.png");
		imgPerso3 = Utile.readImage("src/image/persoHaut/perso3.png");
		imgPerso4 = Utile.readImage("src/image/persoHaut/perso4.png");
		
		pos.monter();
		System.out.println("je suis en x: "+pos.x+" y: "+pos.y+" et je monte");
	}
	
	public void descendre() {
		imgPerso1 = Utile.readImage("src/image/persoBas/perso1.png");
		imgPerso2 = Utile.readImage("src/image/persoBas/perso2.png");
		imgPerso3 = Utile.readImage("src/image/persoBas/perso3.png");
		imgPerso4 = Utile.readImage("src/image/persoBas/perso4.png");
		
		pos.descendre();
		System.out.println("je suis en x: "+pos.x+" y: "+pos.y+" et je descend");
	}
	
	public void droite() {
		imgPerso1 = Utile.readImage("src/image/persoDroite/perso1.png");
		imgPerso2 = Utile.readImage("src/image/persoDroite/perso2.png");
		imgPerso3 = Utile.readImage("src/image/persoDroite/perso3.png");
		imgPerso4 = Utile.readImage("src/image/persoDroite/perso4.png");
		
		pos.droite();
		System.out.println("je suis en x: "+pos.x+" y: "+pos.y+" et je droite");
	}
	
	public void gauche() {
		imgPerso1 = Utile.readImage("src/image/persoGauche/perso1.png");
		imgPerso2 = Utile.readImage("src/image/persoGauche/perso2.png");
		imgPerso3 = Utile.readImage("src/image/persoGauche/perso3.png");
		imgPerso4 = Utile.readImage("src/image/persoGauche/perso4.png");
		
		pos.gauche();
		System.out.println("je suis en x: "+pos.x+" y: "+pos.y+" et je gauche");
	}
	
public String lieuPerso(int x , int y) {
		String lieuActuel = null;
		
		if (x==6 && y==18) {
			lieuActuel="chambre1";
		}
		else if (x==20 && y==7) {
			lieuActuel="Salle de Bain";
		}
		else if (x==34 && y==24) {
			lieuActuel="cuisine";
		}
		else if (x==39 && y==16) {
			lieuActuel="salon";			
		}
		else if (x==15 && y==30) {
			lieuActuel="Entrer";	
		}
		else {
			System.out.println("Je sais pas ou je suis");
		}
		
		System.out.println("methode lieuPerso : Je suis dans --> "+lieuActuel);
		return lieuActuel;
	}
}
