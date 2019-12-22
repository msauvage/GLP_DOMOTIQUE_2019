package elements;

import java.util.Scanner;

public class Volet extends Horloge{
	private int secd;
	private int mind;
	private int heured ;
	private int secf;
	private int minf;
	private int heuref;

	public Volet (int h, int min, int s, int j, int m, int a/*, int secd, int mind, int heured, int secf, int minf, int heuref*/) {
		super(h,min,s,j,m,a);

		/*this.secd= secd;
		this.mind= mind;
		this.heured= heured;
		this.secf= secf;
		this.minf= minf;
		this.heuref= heuref; */
	}
	
	/* public Volet (int secd, int mind, int heured) {
		this.secd= secd;
		this.mind= mind;
		this.heured= heured;
	} */

	public void reglerD() {
		Scanner sc= new Scanner (System.in);
		System.out.println("Entrer l'Heure souhaitée de l'Ouverture des volets");
		int hd = sc.nextInt();

		setHeured(hd);
		
		System.out.println("Entrer la Minute souhaitée de l'Ouverture des volets");
		int md = sc.nextInt();
		
		setMind(md);
		
		System.out.println("Entrer la Seconde souhaitée de l'Ouverture des volets");
		int sd = sc.nextInt();
	
		setHeured(sd);
	}

	public void reglerF() {
		Scanner sc= new Scanner (System.in);
		System.out.println("Entrer l'Heure souhaitée pour la Fermeture des volets");
		int hf = sc.nextInt();
		
		setHeuref(hf);
	
		System.out.println("Entrer la Minute souhaitée pour la Fermeture des volets");
		int mf = sc.nextInt();
		
		setMinf(mf);
		
		System.out.println("Entrer la Seconde souhaitée pour la Fermeture des volets");
		int sf = sc.nextInt();
	
		setHeuref(sf);
	}

	public void allumer (){
		System.out.println("I'm here"+ getHeure()+""+getHeured());
		if (getSecd()==getSeconde() && getMind()==getMinute() && getHeured()==getHeure()) {
			System.out.println("(emmetre le son Bonjour)");
			System.out.println("Les volets sont Ouverts");
			System.out.println("Attention à la Lumière");
		}
	}

	public void fermer() {
		if(getSecf()==getSeconde() && getMinf()==getMinute() && getHeuref()==getHeure()) {
			System.out.println("son: les volets sont Fermés.");
			System.out.println("Bonne soirée à vous");
		}
	}

	public int getSecd() {
		return secd;
	}

	public void setSecd(int secd) {
		this.secd = secd;
	}

	public int getMind() {
		return mind;
	}

	public void setMind(int mind) {
		this.mind = mind;
	}

	public int getHeured() {
		return heured;
	}

	public void setHeured(int heured) {
		this.heured = heured;
	}

	public int getSecf() {
		return secf;
	}

	public void setSecf(int secf) {
		this.secf = secf;
	}

	public int getMinf() {
		return minf;
	}

	public void setMinf(int minf) {
		this.minf = minf;
	}

	public int getHeuref() {
		return heuref;
	}

	public void setHeuref(int heuref) {
		this.heuref = heuref;
	}

	public static void main(String[]args) {
		Volet v = new Volet (19,0,0,23,10,1999);
		Volet v1= new Volet (7,30,0,15,10,1968);
	
		v1.reglerD();
		v.reglerF();
		v1.allumer();
		v.fermer();	
	}
}
