package elementsprocess;

public class Programmer  {
	
	public Programmer() {
		
	}

	public boolean Test(String htoday, String heureProg) {
		if(htoday.compareTo(heureProg)!=0) {
			System.out.println("Heure Programmée: "+heureProg);
			System.out.println("Heure Actuelle: "+htoday);
			return false;
		}else {
			return true;
		}
	}
	public static void main(String[] args) {
		Programmer j = new Programmer();
		j.Test("14-14-14", "14-14-15");
	}
}
