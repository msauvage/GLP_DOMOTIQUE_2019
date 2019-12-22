package elements.cuisine;

import java.util.ArrayList;

// la Classe ReferenceProduit serait utilisée pour "vérifier" le Contenu du Refrigerateur
public class ReferenceProduit {
  private ArrayList<Produit> produits2;
	
	// Création de la "Liste des Références"
	public ReferenceProduit() {
		produits2 = new ArrayList<Produit>();
		Produit banane = new Produit("Banane",1, "2�");
		Produit lait = new Produit("Lait",1, "5�");
		Produit tomate = new Produit("Tomate",1, "4�");
		

		produits2.add(banane);
		produits2.add(lait);
		produits2.add(tomate);
	}
	
	// Ajout d'un Produit dans la "Liste des Références"
	public void add(Produit produit) {
		produits2.add(produit);	// add() est une Méthode "Standard"  Intégrée à JAVA, pour les ArrayList
	}

	public Produit searchByName(String name) {
		Produit result = null;
		//Using "for" each
		for (Produit produit : produits2) {		
			if (produit.getName().equals(name)) {
				result = produit;
			}
		}
		return result;
	}
	
	/*
	public Produit searchByAmount(String amount) {
		Produit result = null;
		//Using an Iterator
		Iterator<Produit> iterator = produits.iterator();
		while (iterator.hasNext()) {
			Produit produit = iterator.next();
			if (produit.getAmount().equals(amount)) {
				result = produit;
			}
		}
		return result;
	}
	*/
	
	/*
	public Produit searchByPrice(String price) {
		Produit result = null;
		//Using element index
		for (int index = 0; index < produitCount(); index++) {
			Produit produit = produits.get(index);	// "contact" l'�l�ment d'indice "index" dans la Collection "contacts"
			if (produit.getPrice().equals(price)) {
				result = produit;
			}
		}
		return result;
	}
	*/
	
	/*
	public void remove(Produit produit) {
		//This works because equals has been redefined (override) in Contact class.
		produits.remove(produit);
	}
	*/
	
	public int produitCount() {
		return produits2.size();
	}
	
	public String toString() {
        String result = "Liste des R�f�rences:\n";
        for (int index = 0; index < produitCount(); index++) {
			Produit produit = produits2.get(index);	// "contact" l'�l�ment d'indice "index" dans la Collection "contacts"
			result+= produit+"\n";
		}
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-- Test phonebook implemented by an array list --");
		ReferenceProduit reference = new ReferenceProduit();
		testOperations(reference);
	}
		
	private static void testOperations(ReferenceProduit reference) {
		/*
		Produit banane = new Produit("Banane", "2", "2�");
		Produit lait = new Produit("Lait", "4", "5�");
		Produit tomate = new Produit("Tomate", "5", "4�");

		reference.add(banane);
		reference.add(lait);
		reference.add(tomate);
		*/
		
		Produit foundBanane = reference.searchByName("Banane");
		if (foundBanane != null) {
			System.out.println(foundBanane.toString());
		}
			
		/*
		Produit foundLait = reference.searchByAmount("4");
		if (foundLait != null) {
			System.out.println(foundLait.toString());
		}
		*/

		System.out.println(reference.toString());
	}
}
