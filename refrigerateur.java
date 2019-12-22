package elements.cuisine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import elements.cuisine.ReferenceProduit;

public class Refrigerateur {
	
	// Usage d'une ArrayList	

/*
 * In this class, we show 3 ways for traversal of an array list :
 * 1) by for 2) by iterator 3) by element index
 */
	private ArrayList<Produit> produits;
	
	public Refrigerateur() {
		produits = new ArrayList<Produit>();
	}
	
	/**
	 * 
	 * @param produit: Ajouter le "produit" au contenu du Réfrigerateur
	 */
	public void add(Produit produit) {
		String name = produit.getName();
		Produit result = null;
		for (Produit produit1 : produits) {	
			if (produit1.getName().equals(name)) {
				result = produit1;
			}
		}if(result!=null) {
			result.AmountIncrement();
		}else{
			produits.add(produit);	// add() est une Méthode "Standard"  Intégrée à JAVA, pour les ArrayList
		}
	}
	
	/**
	 * 
	 * @param name: Rechercher le Produit à partir de son Nom
	 * @return: retourner le Produit trouvé (name, amount, price)
	 */
	public Produit searchByName(String name) {
		Produit result = null;
		//Using "for" each
		for (Produit produit : produits) {	
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
	
	public Produit searchByPrice(String price) {
		Produit result = null;
		//Using element index
		for (int index = 0; index < produitCount(); index++) {
			Produit produit = produits.get(index);	
			if (produit.getPrice().equals(price)) {
				result = produit;
			}
		}
		return result;
	}
	*/

	public void remove(Produit produit) {
		produit.AmountDecrement();
		if(produit.getAmount()==0) {
			produits.remove(produit);
		}
	}

	public int produitCount() {
		return produits.size();
	}
	
	public String toString() {
        String result = "Contenu du R�frigerateur:\n";
        for (int index = 0; index < produitCount(); index++) {
			Produit produit = produits.get(index);
			result+= produit+"\n";
		}
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("-- Test phonebook implemented by an array list --");
		Refrigerateur refrigerateur = new Refrigerateur();
		CourseList courseList = new CourseList();
		ReferenceProduit reference = new ReferenceProduit();
		testOperations(refrigerateur, courseList, reference);
	}
		
	private static void testOperations(Refrigerateur refrigerateur,CourseList courseList,
			ReferenceProduit reference) {
		System.out.println(reference.toString());
		Produit banane = new Produit("Banane",2, "2�");
		Produit lait = new Produit("Lait",1, "5�");

		refrigerateur.add(banane);
		// refrigerateur.add(lait);

		
		Produit foundLait = reference.searchByName("Lait");
		// refrigerateur.add(foundLait);
		// courseList.add(foundLait);
		
		System.out.println(refrigerateur.toString());
		System.out.println(courseList.toString());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Quel produit cherchez-vous? ");
		String produitFound=sc.next();
		
		try {
			Produit foundProduitRef = reference.searchByName(produitFound);
			Produit foundProduitRefrig = refrigerateur.searchByName(produitFound);
			Produit foundProduitC = courseList.searchByName(produitFound);
			
			
			if(foundProduitRefrig != null) {
				System.out.println("Le "+foundProduitRefrig+" se trouve dans le Refrigerateur");
				if(foundProduitC != null) {
					System.out.println("Le "+foundProduitC+" se trouve sur la Liste des Courses");
					System.out.println("Suppression du "+foundProduitC+" de la Liste des Courses\n");
					courseList.remove(foundProduitC);
					System.out.println(courseList.toString());
				}
			}
			else if(foundProduitRefrig == null) {
				System.out.println("Le "+foundProduitRef+" ne se trouve pas dans le Refrigerateur");
				// Produit foundLait2 = reference.searchByName("Lait");
				if(foundProduitC == null) {
					System.out.println("Le "+foundProduitRef+" ne se trouve pas sur la Liste des Courses");
					System.out.println("Ajout du "+foundProduitRef+" � la Liste des Courses\n");
					courseList.add(foundProduitRef);
					System.out.println(courseList.toString());
				}
				else if(foundProduitC != null) {
					System.out.println("Le "+foundProduitC+" se trouve sur la Liste des Courses");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("Non trouv�");
		}
		
		Scanner sc2 = new Scanner(System.in);
		System.out.print("\nQuel produit voulez-vous Retirer? ");
		String produitRemove=sc2.next();
		
		Produit ProduitR=refrigerateur.searchByName(produitRemove);
		System.out.println("Suppression d'une portion du "+ProduitR+" de la Liste du Refrigerateur \n");
		refrigerateur.remove(ProduitR);
				
		System.out.println(refrigerateur.toString());
	}
}
