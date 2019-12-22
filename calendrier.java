package elements;

public class Calendrier {
	private int jour;
	private int mois;
	private int annee;
	
	public Calendrier (int jour, int mois, int annee){
		this.jour= jour;
		this.mois= mois;
		this.annee= annee;
	}
	public int pair (int x) {
		if(mois%2==0) {
			return 0;
		} else 
			return 1;
	}
	public void incrementJour() {
		if (jour==28 && mois==2) {
			incrementMois();
			setJour(1);
		} else {
			if (jour<28 && mois==2) {
				jour++;
			} else {
				if(jour<31 && pair(mois)==0) {
					jour ++;
				} else { 
					if (pair(mois)==0) {
						incrementMois();
						setJour(1);
					} else {
						if (jour<30) {
							jour++;
						} else {
							incrementMois();
							setJour(1);
							}		
						}
					}
				}
			}
	}
		
	public void incrementMois() {
		if (mois==12) {
			incrementAnnee();
			setMois(1);
		} else {
			mois++;
		}
	}
	
	public void incrementAnnee() {
		annee++;
	}
	
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	@Override
	public String toString() {
		return "Nous sommes le " + jour + ", " + mois + ", " + annee + ".";
	}
	
	public static void main(String[]args) {
		Calendrier cl= new Calendrier (20,2,2000);
		Calendrier c2= new Calendrier (23,10,1999);
		Calendrier c3= new Calendrier (31,12,25);
		Calendrier c4= new Calendrier (28,2,1645);
		cl.incrementJour();
		c2.incrementJour();
		c3.incrementJour();
		c4.incrementJour();
		System.out.println(cl.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());	
	}	
}
