/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.UserTextFrenchView;
import org.iae.annecy.st1.etape1.view.catalogue.CatalogueView;
import org.iae.annecy.st1.etape1.view.menu.MenuView;

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
	private static Scanner scan = new Scanner(System.in);

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

	    /*final DataView userData = mainController.get("user:display");
	    final StringView userView = new UserTextFrenchView();*/

	    MenuView menu = new MenuView();
	    //ConsoleHelper.display(userView.build(userData));
	    final Produit p1 = new Produit("aaaa", "chaise", "blabla", 3.00);
	    final Produit p2 = new Produit("bbbb", "bureau", "nduezbf", 4.05);
	    p1.setDescripLongue("Cette chaise est la toute nouvelle chaise hyper ergonomique qui vous permet de ne plus avoir mal aux fesses quand vous restez assis pendant des heures");
	    p2.setDescripLongue("Ce bureau rendra tous vos collègues jaloux, croyez-nous sur parole!");
	    	 
	    
	    Catalogue catalogue = null;
	    
	    try {
		FileInputStream fis = new FileInputStream("file");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file"));
		catalogue = (Catalogue) ois.readObject();
		fis.close();
		ois.close();
	    }catch(IOException ioe){
		catalogue = new Catalogue();		
	    }
	    
	    
	    CatalogueController catController = new CatalogueController();
	    catController.setCat(catalogue);
	    //final CatalogueView catView = new CatalogueView(catController);
	    
	    
	    
	    int choixMenu = 0;
	    
	    String retour =" ";	
	    
	    while(!retour.equals("n")){
		menu.affichageMenu();
		choixMenu = scan.nextInt();
		
		while(choixMenu < 1 || choixMenu > 3){
			menu.messageErreur();
			menu.affichageMenu();
			choixMenu = scan.nextInt();
		    }	
		
		switch (choixMenu) {
		    case 1:
			String choixProduit = " ";
			menu.utilAff(catController.get());
			menu.utilAff("Veuillez rentrer la référence du produit à modifier : ");
			choixProduit = scan.next();
			int choixAttribut = 0;
			menu.affichageCaracProduits();
			choixAttribut = scan.nextInt();
			
			while(choixAttribut < 1 || choixAttribut > 4){
			    menu.messageErreur();
			    menu.affichageCaracProduits();
			    choixAttribut = scan.nextInt();
			}
			    
			switch(choixAttribut){
			    case 1:
				menu.utilAff("Veuillez rentrer le nouveau nom :");
				catalogue.retrieveProduit(choixProduit).setNom(scan.next());
				break;
			    case 2:
				menu.utilAff("Veuillez rentrer la nouvelle description :");
				catalogue.retrieveProduit(choixProduit).setDescritpion(scan.next());
				break;
			    case 3:
				menu.utilAff("Veuillez rentrer la nouvelle description longue :");
				scan.nextLine();	//vider le Scanner
				catalogue.retrieveProduit(choixProduit).setDescripLongue(scan.nextLine());
				break;
			    case 4:
				menu.utilAff("Veuillez rentrer le nouveau prix :");
				Double np = scan.nextDouble();
				while(np < 0){
				    menu.utilAff("Veuillez rentrer un prix positif :");
				    np = scan.nextDouble();
				}
				catalogue.retrieveProduit(choixProduit).setPrix(np);
				break;
			    default:
				menu.messageErreur();
				break;
			}  			 
			break;
			
		    case 2:
			menu.utilAff("Veuillez rentrer la référence du produit : ");
			String ref = scan.next();
			
			while(ref.equals(catalogue.retrieveProduit(ref).getReference())){				
			    menu.utilAff("Cette référence existe déjà, veuillez choisir une autre référence");
			    ref = scan.next();
			}
			
			menu.utilAff("Veuillez rentrer le nom du produit : ");
			String nom = scan.next();
			scan.nextLine();
			menu.utilAff("Veuillez rentrer la description du produit : ");
			String desc = scan.nextLine();
			menu.utilAff("Veuillez rentrer le prix du produit : ");
			double prix = scan.nextDouble();
			
			while(prix < 0){
			    menu.utilAff("Veuillez rentrer un prix positif :");
			    prix = scan.nextDouble();
			}
			
			scan.nextLine();
			menu.utilAff("Veuillez rentrer la description longue du produit : ");
			String descL = scan.nextLine();			    
			catalogue.ajouterProduit(new Produit(ref, nom, desc, descL, prix));
			menu.utilAff("Récapitulatif du produit ajouté => référence :" + ref + "| Nom : " + nom + "| Description : " + desc + "| Prix : " + prix + "€| Description longue : " + descL);
			break;
			
		    case 3:
			int choixDes = 0;			
			menu.afficherDescription();
			choixDes = scan.nextInt();
			
			while(choixDes < 1 || choixDes > 2){
			    menu.messageErreur();
			    menu.afficherDescription();
			    choixDes = scan.nextInt();
			}	
			
			if(choixDes == 1)
			    menu.utilAff(catController.get());
			else
			    menu.utilAff(catController.getCatComplet());			
			break;
			
		    default:
			menu.messageErreur();
			break;
		}
		catalogue.save();
		menu.afficherRetour();
		retour = scan.next();
	    }
	}

	private static void initUserModel() {
		final UserModel userModel = new UserModel();
		userModel.register(mainController);
	}
	
	
	
	
	
		

}
