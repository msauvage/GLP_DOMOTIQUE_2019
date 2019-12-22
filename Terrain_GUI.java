package gui.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import data.Personnage;
import data.Terrain;
import elementsprocess.Utile;

public class TerrainGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static TerrainGUI getTerrainGui;
	
	public Image imgSol;		//0
	public Image imgMur;		//1
	public Image imgHerbe; 	//2
	public Image imgLit;		//3
	public Image imgPerso;		//4
	public Image imgVolet;		//5
	public Image imgHorloge;	//6
	public Image imgDate;		//7
	public Image imgDressing;	//8
	public Image imgCanape;	//9
	public Image imgTv;		//10
	public Image imgPorte;		//11
	public Image imgMachineALaver;	//12
	public Image imgMeuble;	//13
	public Image imgBain;		//14
	public Image imgTapis;		//15
	public Image imgLavabo;	//16
	public Image imgOreiller;	//17
	public Image imgAspirateur;	//18
	public Image imgInterphone;	//19
	public Image imgFenetre;		//20
	public Image imgOrdinateur;	//21
	public Image imgTelephone;		//22
	public Image imgRefrigerateur;	//23
	public Image imgGaziniere;		//24
	public Image imgMicronde;		//25
	public Image imgCafetiere;		//26
	public Image imgGrillePain;	//27
	public Image imgReveil;		//28
	public Image imgEvier;			//29  il manque les eviers

	
	private Terrain terrain;
	
	public TerrainGUI(Terrain terrain) {
		getTerrainGui=this;
		
		this.terrain = terrain;
		 try {
		imgMur = Utile.readImage("src/image/mur.png");
		imgHerbe = Utile.readImage("src/image/herbe.png");
		imgSol = Utile.readImage("src/image/violet.png");
		imgLit = Utile.readImage("src/image/blanc.png");
		imgVolet= Utile.readImage("src/image/cyan.png");
		imgHorloge=Utile.readImage("src/image/grisf.png");
		imgDate= Utile.readImage("src/image/grisf.png");
		imgDressing=Utile.readImage("src/image/grisf.png");
		imgCanape=Utile.readImage("src/image/bordeau.png");
		imgTv=Utile.readImage("src/image/tv.png");
		imgPorte=Utile.readImage("src/image/violet.png");
		imgMachineALaver=Utile.readImage("src/image/gris.png");
		imgMeuble= Utile.readImage("src/image/marron.png");
		imgBain=Utile.readImage("src/image/blanc.png");
		imgTapis= Utile.readImage("src/image/vertEmeraude.png");
		imgLavabo=Utile.readImage("src/image/blanc.png");
		imgOreiller= Utile.readImage("src/image/rose.png");
		imgAspirateur=Utile.readImage("src/image/grisf.png");
		imgInterphone=Utile.readImage("src/image/blanc.png");
		imgFenetre= Utile.readImage("src/image/cyan.png");
		imgOrdinateur=Utile.readImage("src/image/mur.png");
		imgTelephone= Utile.readImage("src/image/mur.png");
		imgRefrigerateur= Utile.readImage("src/image/blanc.png");
		imgGaziniere= Utile.readImage("src/image/jaune.png");
		imgMicronde= Utile.readImage("src/image/jaune.png");
		imgCafetiere= Utile.readImage("src/image/vertEmeraude.png");
		imgGrillePain= Utile.readImage("src/image/vertEmeraude.png");
		imgReveil= Utile.readImage("src/image/mur.png");
		 }catch (Exception e)
		 {
			 System.out.println("erreur dans les images du decor TerrainGUI");
		 }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		
		
		for(int i=0; i<46; i++) {
			for(int j=0; j<33; j++) {
				
				g2.drawRect(i*20, j*20, 20, 20); // ,  ,  epaisseur gauche droite , epaisseur haut en bas
				//g2.drawImage(img, 20, 20, null);
			}
		}	
		
		//placer images
		Image img = null;
		
		for(int i=0; i<=32; i++) { //longueuuuuuuur  n-1 rectangle du haut en j
			for(int j=0; j<=45; j++) {// largeuuuuuur n-1 rectangle du haut en i
				switch(terrain.getCarreau()[i][j]) {
				case 0 : img = imgSol; // <---- remetttre imgSol ou null pour test
						break;
				case 1 :img = imgMur;
						break;
				case 2: img = imgHerbe;
						break;
				case 3:img = imgLit;
						break;
				//case 4:img = imgPerso;
						//break;
				case 5:img = imgVolet;
						break;
				case 6:img = imgHorloge;
						break;
				case 7: img = imgDate;
						break;
				case 8:img = imgDressing;
						break;
				case 9:img = imgCanape;
						break;
				case 10:img = imgTv;
						break;
				case 11:img = imgPorte;
						break;
				case 12:img = imgMachineALaver;
						break;
				case 13:img = imgMeuble;
						break;
				case 14 : img = imgBain;
						break;
				case 15 :img = imgTapis;
						break;
				case 16:img = imgLavabo;
						break;
				case 17:img = imgOreiller;
						break;
				case 18:img = imgAspirateur;
						break;
				case 19:img = imgInterphone;
						break;
				case 20:img = imgFenetre;
						break;
				case 21: img = imgOrdinateur;
						break;
				case 22:img = imgTelephone;
						break;
				case 23:img = imgRefrigerateur;
						break;
				case 24:img = imgGaziniere;
						break;
				case 25:img = imgMicronde;
						break;
				case 26:img = imgCafetiere;
						break;
				case 27:img = imgGrillePain;
						break;
				case 28:img = imgReveil ;
						break;
//				case 29:img = imgEvier ;
//						break;
				
				default:img =imgHerbe;
				}
				g2.drawImage(img,j*20,i*20,null);
				
			}
			/*g2.drawImage(imgMeuble,6*20,18*20,null); // chambre
			g2.drawImage(imgMeuble,20*20,7*20,null); // sdb
			g2.drawImage(imgMeuble,34*20,24*20,null); //cuisine
			g2.drawImage(imgMeuble,39*20,16*20,null); //salon
			g2.drawImage(imgMeuble,15*20,30*20,null);//entrer*/
			//////////////////////////////
			
			
			g2.drawImage(Personnage.getPersonnage.imgPerso1,Personnage.getPersonnage.getPos().x*20,Personnage.getPersonnage.getPos().y*20,null);
			g2.drawImage(Personnage.getPersonnage.imgPerso2,(Personnage.getPersonnage.getPos().x+1)*20,(Personnage.getPersonnage.getPos().y)*20,null);
			g2.drawImage(Personnage.getPersonnage.imgPerso3,(Personnage.getPersonnage.getPos().x)*20,(Personnage.getPersonnage.getPos().y+1)*20,null);
			g2.drawImage(Personnage.getPersonnage.imgPerso4,(Personnage.getPersonnage.getPos().x+1)*20,(Personnage.getPersonnage.getPos().y+1)*20,null);
			///////////////////////
		}
		
		g2.dispose();
	}
}
