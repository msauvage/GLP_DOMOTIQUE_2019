package elements;


public class Alarme {
		private String code;
		private Boolean etat=false;
		
	public Alarme(String code) {
			super();
			this.code=code;
	}
	public String Activer() {
		if (this.etat) {
			return"L'alarme est déjà Activée";
		}
		else {
			etat=true;
			return"L'alarme a été Activée";
		}
	}
	
	public String Desactiver(String codeT) {
		if (this.etat && VerifCode(codeT)) {			
			etat=false;
			return"L'alarme a été Désactivée";
		}
		else if(!VerifCode(codeT) && etat==true) {
			return"Mauvais Code";
		}
		else {
			return "l'alarme est dejà Désactivée";
		}
	}
	
	public boolean VerifCode(String codeT) {
		if (codeT.contentEquals(this.code)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getEtat() {
		if(this.etat==true) {
			return "l'alarme est Activée";
		}
		else {
			return "l'alarme est Désactivée";
		}
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public static void main(String[] args) {
		Alarme alarme = new Alarme("1111");
		
		alarme.Activer();
		alarme.Activer();
		
		System.out.println(alarme.Desactiver("1234"));
		System.out.println(alarme.Desactiver("1111"));
		System.out.println(alarme.Desactiver("1234"));
	
		alarme.Activer();
		System.out.println(alarme.getCode());
	}
}
