/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.UserTextFrenchView;

/**
 * Classe permetant de tester le MVC.
 * 
 * @author Djer1013
 */
public class Main {

	/**
	 * COntroller pemetant le traitement des actions d'exemple.
	 */
	private static MainController mainController;
	private static Scanner sc = new Scanner(System.in);

	static {
		Main.mainController = new MainController();
	}

	/**
	 * Lance l'application.
	 * 
	 * @param args
	 *            command line parameters
	 * @throws ClassNotFoundException 
	 */
	public static void main(final String[] args) throws IOException, ClassNotFoundException {
	    initUserModel();

	    final DataView userData = mainController.get("user:display");
	    final StringView userView = new UserTextFrenchView();

	    //ConsoleHelper.display(userView.build(userData));
	    Produit p1 = new Produit("aaaa", "chaise", "blabla", 3.00);
	    Produit p2 = new Produit("bbbb", "bureau", "nduezbf", 4.05);
	    p1.setDescripLongue("Cette chaise est la toute nouvelle chaise hyper ergonomique qui vous permet de ne plus avoir mal aux fesses quand vous restez assis pendant des heures");
	    p2.setDescripLongue("Ce bureau rendra tous vos collègues jaloux, croyez-nous sur parole!");
	    	 
	    
	    Catalogue c = null;
	    
	    try {
		FileInputStream fis = new FileInputStream("file");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file"));
		c = (Catalogue) ois.readObject();
	    }catch(IOException ioe){
		c = new Catalogue();
	    }
	    
	    
	    CatalogueController catController = new CatalogueController();
	    catController.setCat(c);
	    int choixMenu = 0;
	    String retour = null;
	    do{
		do{
		    affichageMenu();
		    choixMenu = sc.nextInt();
		 
		    switch (choixMenu) {
			case 1:
			    String choixProduit = " ";
			    
			    //c.afficherCatalogue();
//			    CatalogueController catController = new CatalogueController();
//			    catController.setCat(c);
			    System.out.println(catController.get());
			    System.out.print("Veuillez rentrer la référence du produit à modifier : ");
			    choixProduit = sc.next();
			    int choixAttribut = 0;
			    do{
				affichageCaracProduits();
				choixAttribut = sc.nextInt();
				switch(choixAttribut){
				    case 1:
					System.out.println("Veuillez rentrer le nouveau nom :");
					c.retrieveProduit(choixProduit).setNom(sc.next());
					break;
				    case 2:
					System.out.print("Veuillez rentrer la nouvelle description :");
					c.retrieveProduit(choixProduit).setDescritpion(sc.next());
					break;
				    case 3:
					System.out.println("Veuillez rentrer la nouvelle description longue :");
					sc.nextLine();	//vider le Scanner
					c.retrieveProduit(choixProduit).setDescripLongue(sc.nextLine());
					break;
				    case 4:
					System.out.print("Veuillez rentrer le nouveau prix :");
					Double np = sc.nextDouble();
					while(np < 0){
					    System.out.print("Veuillez rentrer un prix positif :");
					    np = sc.nextDouble();
					}
					c.retrieveProduit(choixProduit).setPrix(np);
					break;
				    default:
					messageErreur();
					break;
				}  
			    }while(choixAttribut < 1 || choixAttribut > 4); 
			    break;
			case 2:
			    System.out.print("Veuillez rentrer la référence du produit : ");
			    String ref = sc.next();
			    while(ref.equals(c.retrieveProduit(ref).getReference())){				
				System.out.println("Cette référence existe déjà, veuillez choisir une autre référence");
				ref = sc.next();
			    }
			    System.out.print("Veuillez rentrer le nom du produit : ");
			    String nom = sc.next();
			    sc.nextLine();
			    System.out.print("Veuillez rentrer la description du produit : ");
			    String desc = sc.nextLine();
			    System.out.print("Veuillez rentrer le prix du produit : ");
			    double prix = sc.nextDouble();
			    while(prix < 0){
				System.out.print("Veuillez rentrer un prix positif :");
				prix = sc.nextDouble();
			    }
			    sc.nextLine();
			    System.out.print("Veuillez rentrer la description longue du produit : ");
			    String descL = sc.nextLine();			    
			    c.ajouterProduit(new Produit(ref, nom, desc, descL, prix));
			    System.out.println("Récapitulatif du produit ajouté => référence :" + ref + "| Nom : " + nom + "| Description : " + desc + "| Prix : " + prix + "€| Description longue : " + descL);
			    
			    break;
			case 3:
			    
			    int choixDes = 0;
			    do{
				System.out.println("vous souhaitez afficher le catalogue...\n"
				    	+ "1. Avec description courte\n"
				    	+ "2. Avec description longue");
				choixDes = sc.nextInt();
				if(choixDes == 1){
				    //c.afficherCatalogue();
				    
				    System.out.println(catController.get());
				}else if(choixDes == 2){
				    System.out.println(catController.getCatComplet());
				}else
				    messageErreur();				
			    }while(choixDes != 1 && choixDes != 2);
			    break;
			default:
			    messageErreur();
			    break;
		    }
		    c.save();
		    System.out.println("Voulez-vous retourner au Menu Principal ? (O/N)");
		    retour = sc.next();
		}while(retour.equals("o"));
	    }while(!(choixMenu == 1 || choixMenu == 2));
	}

	private static void initUserModel() {
		final UserModel userModel = new UserModel();
		userModel.register(mainController);
	}
	
	public static void affichageMenu(){
		System.out.println("**************MENU PRINCIPAL**************\n"
			+ "1. Modifier un produit\n"
			+ "2. Ajouter un produit\n"
			+ "3. Afficher le catalogue");
	}
	
	public static void affichageCaracProduits(){
	    System.out.println("Vous souhaitez ..........\n"
	    	+ "1. Modifier le nom\n"
	    	+ "2. Modifier la description\n"
	    	+ "3. Modifier la description longue\n"
	    	+ "4. Modifier le prix");  
	}
	
	public static void messageErreur(){
	    System.out.println("Commande invalide");
	}
	
	
	
		

}
