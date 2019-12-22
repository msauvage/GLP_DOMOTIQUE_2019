package elements.cuisine;

import java.util.ArrayList;

public class CourseList {
	private ArrayList<Produit> produits1;
	
	public CourseList() {
		produits1 = new ArrayList<Produit>();
	}
	
	/**
	 * 
	 * @param produit: Ajouter le "produit" au contenu du Réfrigerateur
	 */
	public void add(Produit produit) {
		String name = produit.getName();
		Produit result = null;
		
		for (Produit produit1 : produits1) {	// pour chaque contact de type Contact contenu dans la Liste "contacts"
			if (produit1.getName().equals(name)) {
				result = produit1;
			}
		}if(result!=null) {
			result.AmountIncrement();
		}else{
			produits1.add(produit);	// add() est une M�thode "Standard"  Int�gr�e � JAVA, pour les ArrayList
		}
	}
	
	/**
	 * 
	 * @param name: Recherche d'un produit sur la Liste des Course, � partir du Nom
	 * @return: Renvoie le produit du nom "name"
	 */

	public Produit searchByName(String name) {
		Produit result = null;
		//Using "for" each
		for (Produit produit : produits1) {		// pour chaque contact de type Contact contenu dans la Liste "contacts"
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
		Iterator<Produit> iterator = produits1.iterator();
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
			Produit produit = produits1.get(index);	// "contact" l'�l�ment d'indice "index" dans la Collection "contacts"
			if (produit.getPrice().equals(price)) {
				result = produit;
			}
		}
		return result;
	}
	*/
	
	/**
	 * 
	 * @param produit: Retirer le Produit de la Liste des Courses (si il est d�j� pr�sent dans le R�frigerateur)
	 */

	public void remove(Produit produit) {
		//This works because equals has been redefined (override) in Contact class.
		produits1.remove(produit);
	}

	public int produitCount() {
		return produits1.size();
	}
	
	public String toString() {
        String result = "Liste des Courses:\n";
        for (int index = 0; index < produitCount(); index++) {
        	// "contact" l'élément d'indice "index dans la Collection "contacts"
			Produit produit = produits1.get(index);
			result+= produit+"\n";
		}
        // result+="\n";
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-- Test phonebook implemented by an array list --");
		Refrigerateur refrigerateur = new Refrigerateur();
		CourseList courseList = new CourseList();
		ReferenceProduit reference = new ReferenceProduit();

		testOperations(refrigerateur, courseList, reference);
	}
		
	private static void testOperations(Refrigerateur refrigerateur,CourseList courseList,
			ReferenceProduit reference) {
		Produit banane = new Produit("Banane",2, "2�");
		Produit lait = new Produit("Lait", 4, "5�");

		refrigerateur.add(banane);
		refrigerateur.add(lait);

		Produit foundBanane = reference.searchByName("Banane");
		Produit foundBanane1 = refrigerateur.searchByName("Banane");
		
		if (foundBanane1 != null) {
			System.out.println(foundBanane1.toString());
			courseList.add(foundBanane1);
		}
		else {
			courseList.add(foundBanane1);
		}
		
		/*
		Produit foundLait = refrigerateur.searchByName("Lait");
		if (foundLait != null) {
			System.out.println(foundLait.toString());
			courseList.add(foundLait);
		}
		else {
			courseList.add(foundLait);
		}
		*/
			
		/*
		Produit foundBanane2 = refrigerateur.searchByPrice("2�");
		if (foundBanane2 != null) {
			System.out.println(foundBanane2.toString());
			courseList.add(foundBanane2);
		}
		 */

		System.out.println(refrigerateur.toString());
		// refrigerateur.remove(banane);
		System.out.println(courseList.toString());
	}
}
