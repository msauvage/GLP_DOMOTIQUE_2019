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
			return"L'alarme est d�j� activ�e";
		}
		else {
			etat=true;
			return"L'alarme � �t� activ�e";
		}
	}
	
	public String Desactiver(String codeT) {
		if (this.etat && VerifCode(codeT)) {			
			etat=false;
			return"L'alarme a �t� d�sactiv�e";
		}
		else if(!VerifCode(codeT) && etat==true) {
			return"Mauvais Code";
		}
		else {
			return "l'alarme est deja desactiv�e";
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
			return "l'alarme est activ�e";
		}
		else {
			return "l'alarme est d�sactiv�e";
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
