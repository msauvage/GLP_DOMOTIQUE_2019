package elements.cuisine;

public class Produit {
	private String name;
	private int amount;
	private String price;
	
	/**
	 * 
	 * @param name: le Nom du Produit
	 * @param amount: la Quantit� du Produit dans le R�frig�rateur
	 * @param price: le Prix � l'Unit�e du Produit
	 * 
	 */
	public Produit(String name, int amount, String price) {
		this.name = name;
		this.amount = amount;
		this.price = price;
	}
/*
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null) {
			if (obj instanceof Produit) {
				Produit produit = (Produit) obj;
				//Two contacts are equal when they have the same name, number and email.
				if (produit.getName() != null && produit.getAmount() != 0 && produit.getPrice() != 0.0f) {
					if (produit.getName().equals(produit) && produit.getAmount().equals(amount) && produit.getPrice().equals(price)) {
						return true;
					}
				}
			}
		}
		return false;
	}
*/
	public String toString() {
		return "Produit [name=" + name + ", amount=" + amount + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public int getAmount() {
		return amount;
	}
	
	public void AmountIncrement() {
		this.amount++;
	}
	public void AmountDecrement() {
		this.amount--;
	}

	public String getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price: Modifier le Prix du Produit
	 * 
	 */
	public void setPrice(String price) {
		this.price = price;
	}
}
