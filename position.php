package data;
// Classe qui s'occupe des coordonnées
public class Position {

	public int x ; // i
	public int y; // j
	
	
	public Position(int x, int y) {
		super();
		this.y = x;
		this.x = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString () {
		return "Je suis en x: " + this.y +" et y: "+this.x;
	}
	
	public void monter() {
		this.y--;
	}
	
	public void descendre() {
		this.y++;
	}
	
	public void droite() {
		this.x++;
	}
	
	public void gauche() {
		this.x--;
	}
}
