package gui.management;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import data.Personnage;
import elements.Alarme;
import elements.Horloge;
import elements.Lumiere;
import elements.cuisine.Cafetiere;
import elements.cuisine.Gaziniere;
import elements.cuisine.MicroOnde;


public class MenuGUI extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private static final int CHRONO_SPEED = 1000;
	public static MenuGUI MenuGUI;
	//-----------TOUT LES ELEMENTS DU JEU--------------//
	private Horloge Horloge = new Horloge(12, 00, 00, 01, 01, 2019);
	
	private Lumiere lampe = new Lumiere();
	private Alarme Alarme = new Alarme("1234");
	private Cafetiere Cafetiere = new Cafetiere();
	private MicroOnde MicroOnde = new MicroOnde();
	private Gaziniere Gaziniere= new Gaziniere(); ;
	
	
	//-------------- LES PANELS POUR FAIRE LES LIGNES DU MENU-------------//
	protected JPanel ligne1 = new JPanel();
	protected JPanel ligne2 = new JPanel();
	protected JPanel ligne3 = new JPanel();
	protected JPanel ligne4 = new JPanel();
	protected JPanel ligne5 = new JPanel();
	protected JPanel ligne6 = new JPanel();
	protected JPanel ligne7 = new JPanel();
	protected JPanel ligne8 = new JPanel();
	protected JPanel ligne9 = new JPanel();
	protected JPanel ligne10 = new JPanel();
	protected JPanel ligne11 = new JPanel();

	//-------------- TERRAIN ET PERSONNAGE------------//
	private TerrainGUI terrain;
	private Personnage perso;
	private String lieuActuel;
	//-------------- LES BOUTONS DEPLACEMENT-------------//
	private int VitesseDeplacement = 20 ;
	private JButton deplacement = new JButton("Deplacement");
	private JLabel TitreDeplacement = new JLabel("Voici les differentes pi�ces");
			private JButton salon = new JButton("Salon");
					private JButton tv = new JButton("TV");
					private JButton bureau = new JButton("Bureau");
			private JButton chambre1 = new JButton("Chambre1");
			private JButton chambre2 = new JButton("Chambre2");
					private JButton dressing = new JButton("Dressing");
					private JButton lit = new JButton("Lit");
			private JButton cuisine = new JButton("Cuisine");
					private JButton cafetiere = new JButton("Cafetiere");
					private JButton microonde = new JButton("Micro-Onde");
			private JButton salleDeBain = new JButton("Salle de Bain");
					private JButton bain = new JButton("Bain");
			private JButton entrer = new JButton("Entrer");
	
	//-------------- LES BOUTONS COMMANDE VOCAL-------------//
	private JButton commandeVocal = new JButton("Commande vocal");
	private JLabel TitreCommandeVocal = new JLabel("Voici les differentes commandes vocals");
	private JButton salonVocal = new JButton("Salon");
			private JButton telephone = new JButton("telephone");
					private JButton appeler = new JButton("Appeler");
					private JButton raccrocher = new JButton("raccrocher");
				private JButton ordinateur = new JButton("ordinateur");
				private JButton television = new JButton("television");
	private JButton chambre1Vocal = new JButton("Chambre1");
	private JButton chambre2Vocal = new JButton("Chambre2");
				private JButton reveil = new JButton("Reveil");
				private JButton dressingv = new JButton("Dressing");
	private JButton cuisineVocal = new JButton("Cuisine");
				private JButton cafetiereVocal = new JButton("cafetiere");
				private JButton gazinierev = new JButton("gaziniere");
				private JButton microOnde = new JButton("Micro-Onde");	
	private JButton salleDeBainVocal = new JButton("Salle de Bain");
				private JButton bainVocal = new JButton("Bain");
	private JButton entrerVocal = new JButton("Entrer");		
			private JButton alarme = new JButton("Alarme");
				private JButton activerAlarme = new JButton("Activer l'alarme");
				private JButton desactiverAlarme = new JButton("Desactiver l'alarme");
	private JButton autres = new JButton("Autres");
			private JButton lumiere = new JButton("Lumi�re");
			private JButton son = new JButton("Son");
			
//-------------BOUTON QUI EFFECTUE LES ACTIONS DES COMMANDE VOCALES ------------//
			private JButton actionner = new JButton("");
	
				
	//-------------- BOUTON ROUTINE-------------//
	private JButton routine = new JButton("D�marrer la routine");
	private JLabel RoutineEtat = new JLabel("Systeme de Routine en construction");
				
	//-----------JLABEL POUR INFO ET PARAMETRE DES FONCTIONS--------------//
	
		private JLabel info1= new JLabel("");
		private JTextField parametre1 = new JTextField (10);
		
		private JLabel info2= new JLabel("");
		private JTextField parametre2 = new JTextField (10);
		
		private JLabel info3= new JLabel("");
		private JTextField parametre3 = new JTextField (10);
		
		private JLabel info4= new JLabel("");
		private JTextField parametre4 = new JTextField (10);
		
		public JLabel horloge = new JLabel(Horloge.toString());
		
	
// -----------------------CONSTRUCTEUR------------------------------//	
	public MenuGUI(String title, Personnage perso, TerrainGUI terrain) {
		super(title);
		MenuGUI=this;
		this.terrain = terrain;
		this.perso = perso;

		this.setPreferredSize(new Dimension(200,200));
		initLayout();
		initAction();
		Horloge.increment();
		
	}
	
	// -----------------------INITIALISER LA POSITION DE CHAQUE BOUTONS------------------------------//	
	public void initLayout() {
		
		GridLayout grid = new GridLayout(11, 11);
		Container contentPane = getContentPane();
		contentPane.setLayout(grid);
		
		// ligne 1
		contentPane.add(ligne1);
		// ligne 2
		contentPane.add(ligne2);
		// ligne 3
		contentPane.add(ligne3);
		// ligne 4
		contentPane.add(ligne4);			
		// ligne 5
		contentPane.add(ligne5);
		// ligne 6
		contentPane.add(ligne6);
		// ligne 7
		contentPane.add(ligne7);
		// ligne 8
		contentPane.add(ligne8);
		// ligne 9
		contentPane.add(ligne9);
		// ligne 10
		contentPane.add(ligne10);
		// ligne 11
		contentPane.add(ligne11);
		
		ligne1.add(deplacement);
		ligne1.add(commandeVocal);
		ligne1.add(routine);
		ligne11.add(horloge);
//------------------JABEL ET JTEXTFIELD POUR LES PARAMETRES------------------//
		info1.setVisible(false);
		parametre1.setVisible(false);
		info2.setVisible(false);
		parametre2.setVisible(false);
		info3.setVisible(false);
		parametre3.setVisible(false);
		info4.setVisible(false);
		parametre4.setVisible(false);
		actionner.setVisible(false);
		
		ligne3.add(info1);
		ligne3.add(parametre1);
		ligne4.add(info2);
		ligne4.add(parametre2);
		ligne5.add(info3);
		ligne5.add(parametre3);
		ligne6.add(info4);
		ligne6.add(parametre4);
		
		ligne8.add(actionner);
		
		
//------------------------D�placement------------------------------//
		TitreDeplacement.setVisible(false);
				salon.setVisible(false);
						tv.setVisible(false);
						bureau.setVisible(false);
				chambre1.setVisible(false);
				chambre2.setVisible(false);
						lit.setVisible(false);
						dressing.setVisible(false);
				cuisine.setVisible(false);
						cafetiere.setVisible(false);
						microonde.setVisible(false);
				salleDeBain.setVisible(false);
						bain.setVisible(false);
				entrer.setVisible(false);

		ligne2.add(TitreDeplacement);
		//deplacement
		ligne3.add(salon);
		
			//deplacement salon
			ligne3.add(tv);
			ligne4.add(bureau);
		
		
		//deplacement
		ligne4.add(chambre1);
		ligne4.add(chambre2);	
		
			//deplacement chambre
			ligne3.add(dressing);
			ligne3.add(lit);

			
		//deplacement
		ligne5.add(cuisine);
			
			//deplacement cuisine
			ligne3.add(cafetiere);
			ligne4.add(microonde);
			
		//deplacement
		ligne6.add(salleDeBain);
			
			//deplacement salle de bain
		ligne3.add(bain);
		
		//deplacement
		ligne7.add(entrer);
		
				
//------------------------COMMANDE VOCAL------------------------------//
			TitreCommandeVocal.setVisible(false);
			salonVocal.setVisible(false);
				telephone.setVisible(false);
					appeler.setVisible(false);
					raccrocher.setVisible(false);
				ordinateur.setVisible(false);
				television.setVisible(false);
			chambre1Vocal.setVisible(false);
			chambre2Vocal.setVisible(false);
				reveil.setVisible(false);
				dressingv.setVisible(false);
			cuisineVocal.setVisible(false);
				microOnde.setVisible(false);
				cafetiereVocal.setVisible(false);
				gazinierev.setVisible(false);
			salleDeBainVocal.setVisible(false);
				bainVocal.setVisible(false);
			entrerVocal.setVisible(false);
				alarme.setVisible(false);
					desactiverAlarme.setVisible(false);
					activerAlarme.setVisible(false);
			autres.setVisible(false);
				lumiere.setVisible(false);
				son.setVisible(false);
			
			ligne2.add(TitreCommandeVocal);
			
			//liste commandes salon 
			ligne3.add(salonVocal);
				ligne3.add(telephone);
					ligne3.add(appeler);
					ligne4.add(raccrocher);
				ligne4.add(television);
				ligne5.add(ordinateur);
				
					
			//liste commmades chambres		
			ligne4.add(chambre1Vocal);
			ligne4.add(chambre2Vocal);
				ligne3.add(reveil);
				ligne4.add(dressingv);
			
			ligne5.add(cuisineVocal);
				ligne3.add(microOnde);
				ligne4.add(cafetiereVocal);
				ligne5.add(gazinierev);
			
			ligne6.add(salleDeBainVocal);
				ligne3.add(bainVocal);
			
			ligne7.add(entrerVocal);
				ligne3.add(alarme);
					ligne3.add(desactiverAlarme);
					ligne4.add(activerAlarme);
				
			ligne8.add(autres);
				ligne3.add(lumiere);
				ligne4.add(son);
		
		
//------------------------ROUTINE------------------------------//	
			RoutineEtat.setVisible(false);
			
			ligne2.add(RoutineEtat);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 500);
		setResizable(true);
		setVisible(true);
		
	}
	// -----------------------INITIALISER LES ACTIONS DE CHAQUE BOUTONS------------------------------//	
	public  void initAction() {
		//-----------------Actions des boutons principaux-----------------//		
				deplacement.addActionListener(new Lieu());
				commandeVocal.addActionListener(new CommandeVocal());
				routine.addActionListener(new routine());
		//------------Action de deplacement --------------//		
				salon.addActionListener(new Deplacement());
						tv.addActionListener(new Deplacement());
						bureau.addActionListener(new Deplacement());
				cuisine.addActionListener(new Deplacement());
				chambre1.addActionListener(new Deplacement());
				salleDeBain.addActionListener(new Deplacement());
				entrer.addActionListener(new Deplacement());
				
				
		//-------------Action LIEU des COMMANDES VOCALES --------------//
				salonVocal.addActionListener(new CommandeVocalLieu());
						telephone.addActionListener(new CommandeV());
							appeler.addActionListener(new CommandeV());
							raccrocher.addActionListener(new CommandeV());
						television.addActionListener(new CommandeV());
						ordinateur.addActionListener(new CommandeV());
				chambre1Vocal.addActionListener(new CommandeVocalLieu());
				chambre2Vocal.addActionListener(new CommandeVocalLieu());
							reveil.addActionListener(new CommandeV());
							dressingv.addActionListener(new CommandeV());
				cuisineVocal.addActionListener(new CommandeVocalLieu());
							microOnde.addActionListener(new CommandeV());
							cafetiereVocal.addActionListener(new CommandeV());
							gazinierev.addActionListener(new CommandeV());
				salleDeBainVocal.addActionListener(new CommandeVocalLieu());
							bainVocal.addActionListener(new CommandeV());
				entrerVocal.addActionListener(new CommandeVocalLieu());
							alarme.addActionListener(new CommandeV());
				autres.addActionListener(new CommandeVocalLieu());
							lumiere.addActionListener(new CommandeV());
							son.addActionListener(new CommandeV());
							
				actionner.addActionListener(new actionner());
				
			}

	/*
	 * "Lieu" permet d'afficher seulement les boutons(lieu) li� aux d�placement
	 */
	private class Lieu implements ActionListener/*-------------(1)ACTION BOUTON DEPLACEMENT----------------------*/{
		public void actionPerformed(ActionEvent arg0) {
			actionner.setVisible(false);
//----------Suppression des boutons du menu ROUTINE ----------//
			RoutineEtat.setVisible(false);
			
//----------Suppression des boutons du menu COMMANDE VOCAL ----------//
			TitreCommandeVocal.setVisible(false);
			salonVocal.setVisible(false);
			chambre1Vocal.setVisible(false);
			chambre2Vocal.setVisible(false);
			cuisineVocal.setVisible(false);
			salleDeBainVocal.setVisible(false);
			autres.setVisible(false);

				//salon//
				telephone.setVisible(false);
				ordinateur.setVisible(false);
				television.setVisible(false);
				//cuisine//
				gazinierev.setVisible(false);
				microOnde.setVisible(false);
				cafetiereVocal.setVisible(false);
				//chambre//
				reveil.setVisible(false);
				//salle de bain//
				bainVocal.setVisible(false);
				//entrer//
				entrerVocal.setVisible(false);
				//autres//
				lumiere.setVisible(false);
				son.setVisible(false);
				
//-----------------Ajout des boutons DEPLACEMENT -----------------//
			TitreDeplacement.setVisible(true);
			salon.setVisible(true);
			chambre1.setVisible(true);
			chambre2.setVisible(true);
			cuisine.setVisible(true);
			salleDeBain.setVisible(true);
			entrer.setVisible(true);
			

		}
	
	}
	
	/*
	 * Chaque deplacement est cod� , chaque m�thode de "Deplacement" permet l'aller et le retour vers un lieu.
	 * exemple : salonSalleDeBain gere Salon <--> Salle de Bain 
	 */
	private class Deplacement implements ActionListener/*-----CONTENU DU BOUTON (1)DEPLACEMENT*/{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String lieu = arg0.getActionCommand();
			lieuActuel=perso.lieuPerso(perso.getPos().x,perso.getPos().y);
			
			System.out.println("lieu(bouton) :"+lieu);
			System.out.println("lieuActuel: "+lieuActuel);

			switch(lieuActuel) {
			case "salon":		System.out.println("1er switch : lieuActuel :"+lieuActuel);
		
										switch(lieu) {
										case "Chambre1": //System.out.println("je suis dans salon je vais des chambre 1");
														System.out.println("2er switch : lieu :"+lieu);
														salonChambre1(lieuActuel);
											
													break;
										case "Entrer": salonEntrer(lieuActuel);
													break;
										case "Salle de Bain": salonSalleDeBain(lieuActuel);
													break;
										case "Cuisine": salonCuisine(lieuActuel);
													break;
										}
							
				 					
						break;
			case "chambre1":
										switch(lieu) {
										case "Salon":salonChambre1(lieuActuel);					 		 						
													break;
										case "Entrer":chambre1Entrer(lieuActuel);
													break;
										case "Salle de Bain":chambre1SalleDeBain(lieuActuel);
													break;
										case "Cuisine":chambre1Cuisine(lieuActuel);
													break;
										}
						break;
			case "Entrer":
										switch(lieu) {
										case "Salon":salonEntrer(lieuActuel);	 						
													break;
										case "Chambre1":chambre1Entrer(lieuActuel);
													break;
										case "Salle de Bain":salleDeBainEntrer(lieuActuel);
													break;
										case "Cuisine":cuisineEntrer(lieuActuel);
													break;
										}
						break;
			case "Salle de Bain":
										switch(lieu) {
										case "Salon": salonSalleDeBain(lieuActuel);	 						
													break;
										case "Chambre1":chambre1SalleDeBain(lieuActuel);
													break;
										case "Entrer":salleDeBainEntrer(lieuActuel);
													break;
										case "Cuisine":salleDeBainCuisine(lieuActuel);
													break;
										}
						break;
			case "cuisine":
										switch(lieu) {
										case "Salon": salonCuisine(lieuActuel);	 						
													break;
										case "Chambre1":chambre1Cuisine(lieuActuel);
													break;
										case "Entrer":cuisineEntrer(lieuActuel);
													break;
										case "Salle de Bain":salleDeBainCuisine(lieuActuel);
													break;
										}
						break;
						
			default:System.out.println("Je suis quelque pars");
			}
			System.out.println(lieuActuel+"/"+lieu+" "+": x perso:"+perso.getPos().x+" ; y perso "+perso.getPos().y);
		}

	public void salonCuisine(String lieuActuel) {
		if(lieuActuel.equals("salon")) {
			
			perso.gauche();
			terrain.repaint();
			for(int i=0;i<=7;i++) {
				perso.descendre();
				terrain.repaint();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=3;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
		}
		
		else if (lieuActuel.equals("cuisine")) {
			for(int i=0;i<=3;i++) {
				perso.droite();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			for(int i=0;i<=7;i++) {
				perso.monter();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			perso.droite();
			
		}
			
	}
	public void salonEntrer(String lieuActuel) {
		if(lieuActuel.equals("salon")) {
			perso.gauche();
			
			for(int i=0;i<=5;i++) {
				perso.descendre();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=22;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=7;i++) {
				perso.descendre();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
		}
		else if (lieuActuel.equals("Entrer")) {
			
			for(int i=0;i<=7;i++) {
				perso.monter();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=22;i++) {
				perso.droite();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=5;i++) {
				perso.monter();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			perso.droite();
			
		}
		
	}
	public void salonChambre1(String lieuActuel) {
//		if(lieuActuel.equals("salon")) {
//			perso.gauche();
//			try {
//			Thread.sleep(VitesseDeplacement);
//			terrain.repaint();
	//
//			} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			salonChambre1(lieuActuel);
//			
//			}
//			
//			
//		}
	//	
//		else if(lieuActuel.equals("chambre1")) {
//			perso.droite();
//			try {
//			Thread.sleep(VitesseDeplacement);
//			terrain.repaint();
	//
//			} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
//			salonChambre1(lieuActuel);
//		}
		
			
			if(lieuActuel.equals("salon")) {
				perso.gauche();
							
				for(int i=0;i<=6;i++) {
					perso.descendre();
					repaint();
					try {
						Thread.sleep(VitesseDeplacement);
						terrain.repaint();
				
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				for(int i=0;i<=28;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
						terrain.repaint();

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				for(int i=0;i<=4;i++) {
					perso.monter();
				}
				for(int i=0;i<=2;i++) {
					perso.gauche();
				}
						
			}
			else if(lieuActuel.equals("chambre1")) {
				System.out.println("methode salonChambre : lieuActuel=chambre1/"+lieuActuel);
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();

				}
				for(int i=0;i<=4;i++) {
					perso.descendre();
				}
				for(int i=0;i<=28;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();

				}
				for(int i=0;i<=6;i++) {
					perso.monter();
				}
				perso.droite();
				
				
			}	
		
	}	
	}
	public void salonSalleDeBain(String lieuActuel) {
			if(lieuActuel.equals("salon")) {
				
				perso.gauche();
				
				for(int i=0;i<=6;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=23;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=9;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=5;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
			}
			else if (lieuActuel.equals("Salle de Bain")) {
				
				for(int i=0;i<=3;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=6;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=2;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=9;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=24;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=7;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				perso.droite();
			}
			
		}
	public void chambre1Entrer(String lieuActuel) {
			if(lieuActuel.equals("chambre1")) {
				
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=3;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=5;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=7;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			}
			else if (lieuActuel.equals("Entrer")) {
				
				for(int i=0;i<=7;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			
			
			for(int i=0;i<=5;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=3;i++) {
				perso.monter();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=2;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			}
		}
	public void chambre1Cuisine(String lieuActuel) {
			if(lieuActuel.equals("chambre1")) {
				
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
		
				for(int i=0;i<=3;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=24;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=1;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
			}
			else if (lieuActuel.equals("cuisine")) {
				
				for(int i=0;i<=1;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			
			
			for(int i=0;i<=24;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=3;i++) {
				perso.monter();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=2;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			}
		}
	public void chambre1SalleDeBain(String lieuActuel) {
			if(lieuActuel.equals("chambre1")) {
				
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=3;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=5;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=8;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=1;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=5;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			}
			else if (lieuActuel.equals("Salle de Bain")) {
				
				for(int i=0;i<=2;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			
			
			for(int i=0;i<=5;i++) {
				perso.descendre();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=1;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=8;i++) {
				perso.descendre();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=5;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=3;i++) {
				perso.monter();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=2;i++) {
				perso.gauche();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			}
		}
	public void salleDeBainEntrer(String lieuActuel) {
			if(lieuActuel.equals("Salle de Bain")) {
				
				for(int i=0;i<=2;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=5;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=1;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=16;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
		
			}
			else if (lieuActuel.equals("Entrer")) {
				
				for(int i=0;i<=16;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			
			
			for(int i=0;i<=1;i++) {
				perso.droite();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=5;i++) {
				perso.monter();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			
			for(int i=0;i<=2;i++) {
				perso.droite();
				try {
					Thread.sleep(VitesseDeplacement);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				terrain.repaint();
			}
			}
		}
	public void salleDeBainCuisine(String lieuActuel) {
			if(lieuActuel.equals("Salle de Bain")) {
				
				for(int i=0;i<=2;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=5;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=1;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=8;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=18;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=1;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			}
			else if (lieuActuel.equals("cuisine")) {
				
				for(int i=0;i<=1;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=18;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=8;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=1;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=5;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=2;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			}
		}
	public void cuisineEntrer(String lieuActuel) {
			if(lieuActuel.equals("cuisine")) {
				
				for(int i=0;i<=1;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=18;i++) {
					perso.gauche();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=7;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			}
			else if (lieuActuel.equals("Entrer")) {
				
				for(int i=0;i<=7;i++) {
					perso.monter();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=18;i++) {
					perso.droite();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
				
				for(int i=0;i<=1;i++) {
					perso.descendre();
					try {
						Thread.sleep(VitesseDeplacement);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					terrain.repaint();
				}
			}
		}

	/*
	 * "CommandeVocal" permet d'afficher seulement les boutons li� aux Commande Vocal
	 */
	private class CommandeVocal implements ActionListener/*------------(2)ACTIONS DU BOUTON CONTROLE VOCAL----------------------*/{
		public void actionPerformed(ActionEvent arg0) {
			actionner.setVisible(false);
//-----------------Suppression des boutons du menu DEPLACEMENT -----------------//
			TitreDeplacement.setVisible(false);
			salon.setVisible(false);
					tv.setVisible(false);
					bureau.setVisible(false);
			chambre1.setVisible(false);
			chambre2.setVisible(false);
					lit.setVisible(false);
					dressing.setVisible(false);
			cuisine.setVisible(false);
					cafetiere.setVisible(false);
					microonde.setVisible(false);
			salleDeBain.setVisible(false);
					bain.setVisible(false);
			entrer.setVisible(false);
			
//----------Suppression des boutons du menu ROUTINE ----------//
			RoutineEtat.setVisible(false);
			
//---------Supression des boutons du Menu COMMANDE VOCAL LIEU ---------------//
			//salon//
			telephone.setVisible(false);
			ordinateur.setVisible(false);
			television.setVisible(false);
			//cuisine//
			gazinierev.setVisible(false);
			microOnde.setVisible(false);
			cafetiereVocal.setVisible(false);
			//chambre//
			reveil.setVisible(false);
			//salle de bain//
			bainVocal.setVisible(false);
			//entrer//
			alarme.setVisible(false);
			//autres//
			lumiere.setVisible(false);
			son.setVisible(false);
			
//--------------SUPPRESSION DES INFO ET PARAMETRE---------------//
			info1.setVisible(false);
			parametre1.setVisible(false);
			info2.setVisible(false);
			parametre2.setVisible(false);
			info3.setVisible(false);
			parametre3.setVisible(false);
			info4.setVisible(false);
			parametre4.setVisible(false);
			
			
//-----------------Ajout des boutons COMMANDE VOCAL -----------------//
			TitreCommandeVocal.setVisible(true);
			salonVocal.setVisible(true);
			chambre1Vocal.setVisible(true);
			chambre2Vocal.setVisible(true);
			cuisineVocal.setVisible(true);
			salleDeBainVocal.setVisible(true);
			entrerVocal.setVisible(true);		
			autres.setVisible(true);


			
		}
		
	}
	
	/*
	 * "CommandVocalLieu" permet d'afficher seulement les boutons li� aux Commande Vocal par lieu 
	 * exemple : dans le lieu "Salle de Bain" nous devons pas pouvoir avoir acces au "Reveil" de chambre 
	 */
	private class CommandeVocalLieu implements ActionListener/*-------------CONTENU DU BOUTON (2)COMMANDE VOCAL----------------------*/{
		public void actionPerformed(ActionEvent arg0) {
			String lieu = arg0.getActionCommand();
			switch(lieu) {
			
			case "Salon": telephone.setVisible(true);
							ordinateur.setVisible(true);
							television.setVisible(true);
							
								break;
			
			case "Chambre1": reveil.setVisible(true);
							
							break;
							
			case "Chambre2":reveil.setVisible(true);
							
							break;
			case "Cuisine": gazinierev.setVisible(true);
							microOnde.setVisible(true);
							cafetiereVocal.setVisible(true);
							
							break;
							
			case "Salle de Bain":bainVocal.setVisible(true);
								
								break;
			
			case "Autres":lumiere.setVisible(true);
							son.setVisible(true);
							break;
							
			case"Entrer": alarme.setVisible(true);
							break;
			
			
			
			}
			//-------------Suppression des boutons de commandes vocales-----------//
			salonVocal.setVisible(false);
			chambre1Vocal.setVisible(false);
			chambre2Vocal.setVisible(false);
			cuisineVocal.setVisible(false);
			salleDeBainVocal.setVisible(false);
			entrerVocal.setVisible(false);
			autres.setVisible(false);
			
		}
		
	}
	
	/*
	 * "CommandeV" permet d'afficher les informations li�e aux elements de la maison
	 */
	private class CommandeV implements ActionListener/*-----Action de chaque commande VOCAL-----*/{
		public void actionPerformed(ActionEvent arg0) {
			
			String action = arg0.getActionCommand();
			System.out.println(action);
			actionner.setText("Actionner");
			parametre1.setText("");
			parametre2.setText("");
			parametre3.setText("");
			parametre4.setText("");
			switch(action) {
			
			case "telephone":	telephone.setVisible(false);
								television.setVisible(false);
								ordinateur.setVisible(false);
								
								info1.setVisible(true);
								info1.setText("Entrez le num�ro :");
								parametre1.setVisible(true);
								
								info2.setVisible(true);
								info2.setText("AFFICHER SI NOUS SOMME EN COMMUNICATION OU NON :");
								
								actionner.setVisible(true);	
								actionner.setText("Appeler/Raccrocher/d�crocher");
								
								
							
								break;
			
			case "television": television.setVisible(false);
								telephone.setVisible(false);
								ordinateur.setVisible(false);
							
							break;
							
			case "ordinateur":ordinateur.setVisible(false);
								telephone.setVisible(false);
								television.setVisible(false);
								
								info1.setVisible(true);
								info1.setText("Entrez l'heure voulut au format hh-mm-ss: ");
								parametre1.setVisible(true);
								
								actionner.setVisible(true);	
								actionner.setText("Programmer le r�veil");
								
							
							break;
			case "Reveil": reveil.setVisible(false);
			
								info1.setVisible(true);
								info1.setText("Entrez l'heure voulut au format hh-mm-ss: ");
								parametre1.setVisible(true);
								
								actionner.setVisible(true);	
								actionner.setText("Programmer le r�veil");
							
							break;
							
			case "Micro-Onde":microOnde.setVisible(false);
								gazinierev.setVisible(false);
								cafetiereVocal.setVisible(false);
								
								break;
			case"cafetiere" :cafetiereVocal.setVisible(false);
							microOnde.setVisible(false);
							gazinierev.setVisible(false);
							
							
							info1.setVisible(true);
							info1.setText("Entrez l'heure voulut au format hh-mm-ss: ");
							parametre1.setVisible(true);
							
							info2.setVisible(true);
							info2.setText("Entrez la dose voulut");
							parametre2.setVisible(true);
							
							actionner.setVisible(true);	
							actionner.setText("Programmer la cafeti�re");
							
							break;
			
			case "gaziniere":microOnde.setVisible(false);
							gazinierev.setVisible(false);
							cafetiereVocal.setVisible(false);
							
							info1.setVisible(true);
							info1.setText("Entrez l'heure voulut au format hh-mm-ss: ");
							parametre1.setVisible(true);
							
							info2.setVisible(true);
							info2.setText("Entrez la temperature du pr�chauffage");
							parametre2.setVisible(true);
							
							actionner.setVisible(true);	
							actionner.setText("Programmer la gaziniere");
							break;
							
			case"Bain": bainVocal.setVisible(false);
			
							info1.setVisible(true);
							info1.setText("Entrez l'heure voulut au format hh-mm-ss: ");
							parametre1.setVisible(true);
							
							info2.setVisible(true);
							info2.setText("Entrez la temperature voulut: ");
							parametre2.setVisible(true);
							
							info3.setVisible(true);
							info3.setText("le Bain est :");
							
							actionner.setVisible(true);	
							actionner.setText("Programmer le bain");
			
			
			
							break;
			case"Alarme": 	alarme.setVisible(false);
							
							actionner.setVisible(true);			
							info1.setVisible(true);
							parametre1.setVisible(true);
							info1.setText(Alarme.getEtat());
							if(Alarme.getEtat()=="l'alarme est activ�e"){
								actionner.setText("Desactiver");
							}else {
								actionner.setText("Activer");
							}
							
			
							break;
			case"Lumi�re":	lumiere.setVisible(false);
							son.setVisible(false);
							actionner.setVisible(true);
							info1.setVisible(true);
							info1.setText("Etat de la lumiere :"+ lampe.getEtat());
							if (lampe.getEtat()=="on") {
								actionner.setText("�teindre");
							}else {
								actionner.setText("allumer");
							}
							
							
							break;
			case"Son":lumiere.setVisible(false);
							son.setVisible(false);
							
							
							break;
			
			
			
		}
		
	}
}
	
	/*
	 * "actionner" effectue toutes les actions
	 */
	private class actionner implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
			
			switch(actionner.getText()) {
			
			case "allumer":lampe.allumer();
							info1.setText("Etat de la lumiere :"+ lampe.getEtat());
							if (lampe.getEtat()=="on") {
								actionner.setText("�teindre");
							}else {
								actionner.setText("allumer");
							}
							
							break;
			case "�teindre":lampe.eteindre();
			info1.setText("Etat de la lumiere :"+ lampe.getEtat());
							if (lampe.getEtat()=="on") {
								actionner.setText("�teindre");
							}else {
								actionner.setText("allumer");
							}
							break;
							
			case"Activer": 	info2.setVisible(true);
							info2.setText(Alarme.Activer());
							Alarme.Activer();
							info1.setText(Alarme.getEtat());
							if(Alarme.getEtat()=="l'alarme est activ�e"){
								actionner.setText("Desactiver");
							}else {
								actionner.setText("Activer");
							}
							
					break;
					
			case"Desactiver": 	info2.setVisible(true);
								info2.setText(Alarme.Desactiver(parametre1.getText()));
								Alarme.Desactiver(parametre1.getText());
								info1.setText(Alarme.getEtat());
								if(Alarme.getEtat()=="l'alarme est activ�e"){
									actionner.setText("Desactiver");
								}else {
									actionner.setText("Activer");
								}
									break;
				
			case"Programmer la cafeti�re": 
									break;
				
			case"Programmer la gaziniere":try {
										Gaziniere.setMinuteur(Integer.parseInt(parametre1.getText(0, 2)) ,Integer.parseInt(parametre1.getText(3, 2)),Integer.parseInt(parametre1.getText(6, 2)));
										} catch (NumberFormatException | BadLocationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										}
										Gaziniere.minuteur.lancement();
											
				break;
				
			case"Programmer le r�veil": 
				
										break;
				
			case"Programmer le bain": 
										break;
				
			case"Appeler/Raccrocher/d�crocher": 
										break;

				
			
			}
		}
		
	}
	
	
	/*
	 * "routine" permet d'afficher seulement les boutons li� � la routine
	 */
	private class routine implements ActionListener/*-------------(3) ACTION DU BOUTON ROUTINE----------------------*/{
		public void actionPerformed(ActionEvent arg0) {
			
			actionner.setVisible(false);
//-----------------Suppression des boutons du menu DEPLACEMENT -----------------//
			TitreDeplacement.setVisible(false);
			salon.setVisible(false);
					tv.setVisible(false);
					bureau.setVisible(false);
			chambre1.setVisible(false);
			chambre2.setVisible(false);
					lit.setVisible(false);
					dressing.setVisible(false);
			cuisine.setVisible(false);
					cafetiere.setVisible(false);
					microonde.setVisible(false);
			salleDeBain.setVisible(false);
					bain.setVisible(false);
			entrer.setVisible(false);
			
//----------Suppression des boutons du menu COMMANDE VOCAL ----------//
			TitreCommandeVocal.setVisible(false);
			salonVocal.setVisible(false);
				telephone.setVisible(false);
				appeler.setVisible(false);
				raccrocher.setVisible(false);
				ordinateur.setVisible(false);
				television.setVisible(false);
			chambre1Vocal.setVisible(false);
			chambre2Vocal.setVisible(false);
				reveil.setVisible(false);
				dressingv.setVisible(false);
			cuisineVocal.setVisible(false);
				microOnde.setVisible(false);
				cafetiereVocal.setVisible(false);
				gazinierev.setVisible(false);
			salleDeBainVocal.setVisible(false);
				bainVocal.setVisible(false);
			entrer.setVisible(false);
				alarme.setVisible(false);
			autres.setVisible(false);
				lumiere.setVisible(false);
				son.setVisible(false);
				
//--------SUPPRESSION DES INFO ET PARAMETRE---------------//
				info1.setVisible(false);
				parametre1.setVisible(false);
				info2.setVisible(false);
				parametre2.setVisible(false);
				info3.setVisible(false);
				parametre3.setVisible(false);
				info4.setVisible(false);
				parametre4.setVisible(false);
				
			
//----------Ajout des boutons du menu ROUTINE ----------//
			RoutineEtat.setVisible(true);
			
			
		}
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(CHRONO_SPEED);
				Horloge.increment();
				horloge.setText(Horloge.toString());

			}catch(Exception e) {
				
			}
		
		}
		
		
	}
  
//public static void main(String[]args) {
//
//}
}
