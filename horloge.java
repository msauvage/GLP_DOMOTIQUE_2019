package elements;

import gui.management.*;

public class Horloge extends Calendrier {
	private int seconde;
	private int minute;
	private int heure;

	
	public Horloge (int heure, int minute, int seconde ,int j, int m, int a ) {
		super(j, m, a);
		this.seconde= seconde;
		this.minute= minute;
		this.heure= heure;
	}
	
	public String incremente() {		
		while(true) {
			try {
				Thread.sleep(1000);
				incremente();
				System.out.println(toString());
			}catch(Exception e) {
				
			}
		}
	}
	
	public void increment () {
		if (seconde <59) {
			seconde ++;
		} 
		else {
			if (minute<59) {
				minute ++;
				seconde=0;
			} 
			else {
				if (heure<23) {
					heure ++;
					seconde=0;
					minute=0;
				} 
				else {
					this.incrementJour();
					init();
				}
			}
		}
	}
	
	public void init() {
		seconde=0;
		minute=0;
		heure=0;
	}
	
	public int getSeconde() {
		return seconde;
	}
	
	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public int getHeure() {
		return heure;
	}
	
	public void setHeure(int heure) {
		this.heure = heure;
	}
	
	public String formatHMS() {
		return heure+"-"+minute+"-"+seconde ;
	}

	@Override
	public String toString() {
		return "il est " + heure + ":" + minute + ":" + seconde + "      Le " + this.getJour() +"/"
	+  this.getMois() +"/" + this.getAnnee() ;
	}
	
	public static void main(String[]args) {
		Horloge h1= new Horloge (10,54,58, 5, 6, 2019);
	
		h1.increment();
		
		System.out.println(h1.formatHMS());		
	}
}
