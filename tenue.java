package elements;

public class Tenue {
	private String haut;
	private String bas;
	private String chaussure;
	
	public Tenue (String haut, String bas, String chaussure) {
		this.haut=haut;
		this.bas=bas;
		this.chaussure=chaussure;
	}
	
	
	public String getHaut() {
		return haut;
	}
	public void setHaut(String haut) {
		this.haut = haut;
	}
	public String getBas() {
		return bas;
	}
	public void setBas(String bas) {
		this.bas = bas;
	}
	public String getChaussure() {
		return chaussure;
	}
	public void setChaussure(String chaussure) {
		this.chaussure = chaussure;
	}
}
