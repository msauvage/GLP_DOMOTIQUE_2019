	package gui.management;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import data.Personnage;
import data.Position;
import data.Terrain;

public class MainGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;

//	private JDesktopPane jeu = new JDesktopPane();

	private JInternalFrame menuFrame = new JInternalFrame("Menu");
	private JInternalFrame infoFrame = new JInternalFrame("Notification");
	
	private JDesktopPane desktop = new JDesktopPane();
	
	
	/* ----------------Terrain ------------*/ 
	
	private JInternalFrame terrainFrame = new JInternalFrame("Jeu");
	private Personnage perso = new Personnage(new Position(30,15));
	private Terrain terrainConsole = new Terrain(perso);
	private TerrainGUI terrain;
	private MenuGUI menu;
	
	 public static MainGUI main;
	
	public MainGUI() {
		super();
		
		main=this;
		
		setLayout(new FlowLayout());
		
		initTerrain();
		add(terrainFrame);
		
		initMenu();
//		add(menuFrame);
		
		// ------------------zone de test---------------------//

		
		// ------------------zone de test---------------------//

	}

	public TerrainGUI getTerrainGui () {
		return terrain;
	}
	public Terrain getTerrain () {
		return terrainConsole;
	}
	
	public Personnage getPerso () {
		return this.perso;
	}
	
	public void initTerrain() {
		terrain = new TerrainGUI(terrainConsole);
		terrainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		terrainFrame.setSize(1300, 695); //1337 700
		terrainFrame.setPreferredSize(new Dimension(930,1500));
		terrainFrame.setVisible(true);
		terrainFrame.setResizable(false);
		terrainFrame.add(terrain);
//		jeu.add(terrainFrame);
		
	//	desktop.add(terrainFrame);

	}
	
	public void initMenu() {
		menu=new MenuGUI("menu",perso,terrain);
		Thread chronoThread = new Thread(menu);
		chronoThread.start();
	}
	
	public static void main(String[]args) {
		MainGUI m = new MainGUI();

		m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		m.setSize(1370, 730);
		m.setVisible(true);
		m.setResizable(false);
		m.setLocationRelativeTo(null);
		m.setTitle("DOMOTIQUE");
	}
}
