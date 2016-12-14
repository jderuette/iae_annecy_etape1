/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.iae.annecy.st1.common.mvc.BasicDataParam;
import org.iae.annecy.st1.common.mvc.ConsoleInputView;
import org.iae.annecy.st1.common.mvc.DataParam;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;
import org.iae.annecy.st1.etape1.controller.BaseDeDonneesController;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.controller.PanierController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.panier.Panier;
import org.iae.annecy.st1.etape1.model.person.BaseDeDonnees;
import org.iae.annecy.st1.etape1.model.person.Person;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.MenuView;
import org.iae.annecy.st1.etape1.view.PersonView;
import org.iae.annecy.st1.etape1.view.UserTextFrenchView;
import org.iae.annecy.st1.etape1.view.person.PersonAddFrenchView;
import org.iae.annecy.st1.etape1.view.person.PersonCreateFrenchView;
import org.iae.annecy.st1.etape1.view.person.PersonGetFrenchView;
import org.iae.annecy.st1.tools.ConsoleHelper;

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
	//initCustomerModel();

	Scanner scan = new Scanner(System.in, "UTF-8");

	MenuView menu = new MenuView();

	final Produit p1 = new Produit("aaaa", "chaise", "blabla", 3.00);
	final Produit p2 = new Produit("bbbb", "bureau", "nduezbf", 4.05);
	p1.setDescripLongue("Cette chaise est la toute nouvelle chaise hyper ergonomique qui vous permet de ne plus avoir mal aux fesses quand vous restez assis pendant des heures");
	p2.setDescripLongue("Ce bureau rendra tous vos collègues jaloux, croyez-nous sur parole!");
	Person pers1 = new Person("1", "Chanrion", "Skivana");
	Person pers2 = new Person("2", "Barjoux", "Mélodie");

	BaseDeDonnees bdd = null;

	Catalogue catalogue = null;

	try {
	    FileInputStream fis = new FileInputStream("etape1.ser");
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("etape1.ser"));
	    catalogue = (Catalogue) ois.readObject();
	    bdd = (BaseDeDonnees) ois.readObject();
	    fis.close();
	    ois.close();
	}catch(Exception e){
	    catalogue = new Catalogue();
	    catalogue.ajouterProduit(p1);
	    catalogue.ajouterProduit(p2);
	    bdd = new BaseDeDonnees();
	    bdd.ajouterClient(pers1);
	    bdd.ajouterClient(pers2);
	}

//	try {
//	    FileInputStream fis2 = new FileInputStream("clients.ser");
//	    ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("clients.ser"));
//	    bdd = (BaseDeDonnees) ois2.readObject();
//	    fis2.close();
//	    ois2.close();
//	}catch(IOException ioe){
//	    bdd = new BaseDeDonnees();
//	    bdd.ajouterClient(pers1);
//	    bdd.ajouterClient(pers2);
//	}	    

	CatalogueController catController = new CatalogueController();
	catController.setCat(catalogue);
	//final CatalogueView catView = new CatalogueView(catController);
	BaseDeDonneesController bddCont = new BaseDeDonneesController();
	bddCont.setBdd(bdd);
	PanierController panierCont = new PanierController();
	


	Integer choixMenu = 0;
	Integer choixCat = 0;
	Integer choixAttribut = 0;
	Integer rep = 0;
	String retour = "";
	String str = "";
	String refProduit = "";
	String idCl = "";

	Integer qteProd = 0;
	String nom = "";
	String prenom = "";
	String id = "";
	Panier panier = new Panier();

	Integer numeroClient = null;
	Double codePromo = null;
	String idClient = "";
	String nomClient = "";
	String prenomClient = "";
	String numClient = "";
	String codeP = "";

	String clientId = "";
	Integer choixModif = 0;
	
	Integer choixDes = 0;

	String ref = "";
	String desc = "";
	String descL = "";
	Double prix = 0.0;
	
	Double newPrix = (double) 0;
	
	
	boolean erreur = true;
	
	menu.afficherCatégorie();
		 
	//Gestion des erreurs de saisie 
	while(choixCat < 1 || choixCat > 4){
	    erreur = true;
	    while(erreur){ 
		try{
		    choixCat = scan.nextInt();
		    if(choixCat < 1 || choixCat > 4){
			menu.messageErreur();
			erreur = true;
		    }else
			erreur = false;
		}catch(InputMismatchException e){
		    menu.messageErreur();
		    str = scan.next();
		}
	    }
	}
	
	//Si choix: responsable produit
	switch(choixCat){
	    case 1:		
		
		//Gestion de demande de retour au menu principal
		while(!retour.equals("n")){
		    menu.affichageMenu(choixCat);
		    		    
		    //Gestion des erreurs de saisie 
		    while(choixMenu < 1 || choixMenu > 4){
			erreur = true;
			while(erreur){ 

			    try{
				choixMenu = scan.nextInt();
				if(choixMenu < 1 || choixMenu > 4){
				    menu.messageErreur();
				    erreur = true;
				}else
				    erreur = false;
			    }catch(InputMismatchException e){
				menu.messageErreur();
				str = scan.next();
			    }
			}
		    }	
		    
		    switch (choixMenu) {
			//Choix : modification d'un produit
			case 1:
			    			    
			    ConsoleHelper.display(catController.get());
			    ConsoleHelper.display("Veuillez rentrer la référence du produit à modifier : ");
			    refProduit = scan.next();
			    			    
			    //Gestion des erreurs: mauvaise référence produit
			    while(!refProduit.equals(catController.getCat().retrieveProduit(refProduit).getReference())){				
				ConsoleHelper.display("Cette référence n'existe pas, veuillez recommencer :");
				refProduit = scan.next();
			    }
			    
			    menu.affichageCaracProduits();
			    
			    //Gestion des erreurs de saisie 
			    while(choixAttribut < 1 || choixAttribut > 4){
				erreur = true;
				while(erreur){ 

				    try{
					choixAttribut = scan.nextInt();
					if(choixAttribut < 1 || choixAttribut > 4){
					    menu.messageErreur();
					    erreur = true;
					}else
					    erreur = false;
				    }catch(InputMismatchException e){
					menu.messageErreur();
					str = scan.next();
				    }
				}
			    }

			    //Choix : caractéristique du produit à modifier
			    switch(choixAttribut){
				
				case 1:
				    ConsoleHelper.display("Veuillez rentrer le nouveau nom :");
				    catController.getCat().retrieveProduit(refProduit).setNom(scan.next());
				    break;
				case 2:
				    ConsoleHelper.display("Veuillez rentrer la nouvelle description :");
				    catController.getCat().retrieveProduit(refProduit).setDescritpion(scan.next());
				    break;
				case 3:
				    ConsoleHelper.display("Veuillez rentrer la nouvelle description longue :");
				    scan.nextLine();	//vider le Scanner
				    catController.getCat().retrieveProduit(refProduit).setDescripLongue(scan.nextLine());
				    break;
				case 4:
				    
				    ConsoleHelper.display("Veuillez rentrer le nouveau prix :");
//				    newPrix = scan.nextDouble();
				    //Gestion des erreurs de saisie 
				    while(newPrix <= 0 ){
					erreur = true;
					while(erreur){ 
					    try{
						newPrix = scan.nextDouble();
						if(newPrix < 0 ){
						    ConsoleHelper.display("Veuillez rentrer un prix positif :");
						    erreur = true;
						}else
						    erreur = false;
					    }catch(InputMismatchException e){
						menu.messageErreur();
						str = scan.next();
					    }
					}
				    }
				    catController.getCat().retrieveProduit(refProduit).setPrix(newPrix);
				    ConsoleHelper.display("Le nouveau prix du produit référence : " + catController.getCat().retrieveProduit(refProduit).getReference() +
					    " est : " + newPrix + "€");
				    break;
				default:
				    menu.messageErreur();
				    break;
			    }  
			    catController.sauvegarder();
			    break;

			case 2:
			    			    
			    ConsoleHelper.display("Veuillez rentrer la référence du produit : ");
			    ref = scan.next();
			    
			    while(ref.equals(catalogue.retrieveProduit(ref).getReference())){				
				ConsoleHelper.display("Cette référence existe déjà, veuillez choisir une autre référence");
				ref = scan.next();
			    }

			    ConsoleHelper.display("Veuillez rentrer le nom du produit : ");
			    nom = scan.next();
			    scan.nextLine();	//vider le scanner
			    ConsoleHelper.display("Veuillez rentrer la description du produit : ");
			    desc = scan.nextLine();
			    ConsoleHelper.display("Veuillez rentrer le prix du produit : (ex : 9,99)");			   

			    //Gestion des erreurs de saisie 
			    while(prix <= 0 ){
				erreur = true;
				while(erreur){ 
				    try{
					prix = scan.nextDouble();
					if(prix < 0 ){
					    ConsoleHelper.display("Veuillez rentrer un prix positif :");
					    erreur = true;
					}else
					    erreur = false;
				    }catch(InputMismatchException e){
					menu.messageErreur();
					str = scan.next();
				    }
				}
			    }

			    scan.nextLine();
			    ConsoleHelper.display("Veuillez rentrer la description longue du produit : ");
			    descL = scan.nextLine();			    
			    catalogue.ajouterProduit(new Produit(ref, nom, desc, descL, prix));
			    ConsoleHelper.display("Récapitulatif du produit ajouté => référence :" + ref + "| Nom : " + nom + "| Description : " + desc + "| Prix : " + prix + "€| Description longue : " + descL);
			    break;
			case 3:	
			    			    
			    ConsoleHelper.display(catController.get());
			    ConsoleHelper.read(scan, "Veuillez rentrer la référence du produit à supprimer :");
			    refProduit = scan.next();
			    while(!refProduit.equals(catController.getCat().retrieveProduit(refProduit).getReference())){
				ConsoleHelper.display("Cette référence produit n'existe pas, veuillez recommencer :");
				refProduit = scan.next();
			    }
			    catController.getCat().supprimerProduit(catController.getCat().retrieveProduit(refProduit));
			    ConsoleHelper.display("Le produit référence : " + refProduit + " a bien été supprimé.");
			    break;
			case 4:
			    			
			    menu.afficherDescription();

			  //Gestion des erreurs de saisie 
			    while(choixDes < 1 || choixDes > 2){
				erreur = true;
				while(erreur){ 

				    try{
					choixDes = scan.nextInt();
					if(choixDes < 1 || choixDes > 2){
					    menu.messageErreur();
					    erreur = true;
					}else
					    erreur = false;
				    }catch(InputMismatchException e){
					menu.messageErreur();
					str = scan.next();
				    }
				}
			    }	

			    if(choixDes == 1)
				ConsoleHelper.display(catController.get());
			    else
				ConsoleHelper.display(catController.getCatComplet());			
			    break;
			default:
			    menu.messageErreur();
			    break;
		    }
		    catController.sauvegarder();
		    menu.afficherRetour();
		    retour = scan.next();
		}
		
		break;

	    case 2:
		retour = "";
		while(!retour.equals("n")){
		    menu.affichageMenu(choixCat);

		    //Gestion des erreurs de saisie 
		    while(choixMenu < 1 || choixMenu > 4){
			erreur = true;
			while(erreur){ 

			    try{
				choixMenu = scan.nextInt();
				if(choixMenu < 1 || choixMenu > 4){
				    menu.messageErreur();
				    erreur = true;
				}else
				    erreur = false;
			    }catch(InputMismatchException e){
				menu.messageErreur();
				str = scan.next();
			    }
			}
		    }	

		    switch (choixMenu) {
			case 1:
			    			    
			    ConsoleHelper.display(bddCont.get());
			    ConsoleHelper.display("Quel est l'ID du client que vous souhaitez modifier ?");
			    clientId = scan.next();
			    while(!clientId.equals(bdd.retrieveClient(clientId).getId())){
				ConsoleHelper.display("ID inconnu, veuillez recommencer");
				clientId = scan.next();
			    }
			    menu.affichageCaracClients();
			    
			    //Gestion des erreurs de saisie 
			    while(choixModif < 1 || choixModif > 4){
				erreur = true;
				while(erreur){ 

				    try{
					choixModif = scan.nextInt();
					if(choixModif < 1 || choixModif > 4){
					    menu.messageErreur();
					    erreur = true;
					}else
					    erreur = false;
				    }catch(InputMismatchException e){
					menu.messageErreur();
					str = scan.next();
				    }
				}
			    }
			    
			    switch(choixModif){
				case 1:
				    ConsoleHelper.display("Veuillez rentrer le nouveau nom :");
				    bdd.retrieveClient(clientId).setNom(scan.next());
				    break;
				case 2:
				    ConsoleHelper.display("Veuillez rentrer le nouveau prénom :");
				    bdd.retrieveClient(clientId).setPrenom(scan.next());
				    break;
				case 3:
				    ConsoleHelper.display("Veuillez rentrer le nouveau numéro client :");
				    bdd.retrieveClient(clientId).setNumero(scan.nextInt());
				    break;
				case 4:
				    ConsoleHelper.display("Veuillez rentrer le nouveau code promotionnel :");
				    bdd.retrieveClient(clientId).setCodePromo(scan.nextDouble());
				    break;
				default:
				    menu.messageErreur();
				    break;
			    }
			    break;

			case 2:
			    			    
			    scan.nextLine();
			    idClient = ConsoleHelper.read(scan, "Quel est l'ID du client ?");
			    nomClient = ConsoleHelper.read(scan, "Quel est le nom du client ?");
			    prenomClient = ConsoleHelper.read(scan, "Quel est le prénom du client ?");
			    numClient = ConsoleHelper.read(scan, "Quel est le numéro du client ?");
			    if(numClient.isEmpty())
				numeroClient = null;
			    else
				numeroClient = Integer.parseInt(numClient);
			    codeP = ConsoleHelper.read(scan, "Quel est le code promotionnel du client ?");
			    if(codeP.isEmpty())
				codePromo = 0.0;
			    else
				codePromo = Double.parseDouble(codeP);
			    bdd.ajouterClient(new Person(idClient, nomClient, prenomClient, numeroClient, codePromo));
			    ConsoleHelper.display("Récapitulatif du client ajouté => ID : " + idClient + 
				    "\n Nom : " + nomClient	+ 
				    "\n Prénom : " + prenomClient + 
				    "\n Numéro Client : " + numeroClient + 
				    "\n Code Promotionnel : " + codePromo);
			    break;
			case 3:
			    			    
			    ConsoleHelper.display(bddCont.get());
			    ConsoleHelper.display("Veuillez rentrer l'ID du client à supprimer :");
			    id = scan.next();
			    while(!id.equals(bddCont.getBdd().retrieveClient(id).getId())){
				ConsoleHelper.display("Cet ID n'existe pas, veuillez recommencer :");
				id = scan.next();
			    }
			    bddCont.getBdd().supprimerClient(bddCont.getBdd().retrieveClient(id));
			    break;
			case 4:
			    ConsoleHelper.display(bddCont.get());
			    break;
			default:
			    menu.messageErreur();
			    break;
		    }
		    bddCont.sauvegarder();
		    menu.afficherRetour();
		    retour = scan.next();
		}
		break;

	    case 3:
		retour = "";
				
		panierCont.setPanier(panier);		
		ConsoleHelper.read(scan, "Veuillez rentrer votre nom :");
		nom = scan.nextLine();
		ConsoleHelper.display("Veuillez rentrer votre prénom :");	
		prenom = scan.next();
		
		//Retrouve le compte d'un client à partir de ses nom et prénom
		if(nom.equals(bddCont.getBdd().retrieveClient(nom, prenom).getNom()) 
			|| prenom.equals(bddCont.getBdd().retrieveClient(nom, prenom).getPrenom())){
		    ConsoleHelper.display(prenom + " " + nom + ", vous allez accéder à votre panier ....");
		    bddCont.getBdd().retrieveClient(nom, prenom).setPanier(panier);
		    
		}
		//Crée un compte pour le nouveau client
		else{
		    ConsoleHelper.display("Bienvenue " + prenom + " " + nom + ", votre compte vient d'être créé ...");
		    id = String.valueOf(bddCont.getBdd().getBaseClients().size() + 1);
		    bddCont.getBdd().ajouterClient(new Person(id, nom, prenom));
		    bddCont.getBdd().retrieveClient(nom, prenom).setPanier(panier);
		}
		while(!retour.equals("n")){
		    menu.affichageMenu(choixCat);
		    
		    //Gestion des erreurs de saisie 
		    while(choixMenu < 1 || choixMenu > 4){
			erreur = true;
			while(erreur){ 

			    try{
				choixMenu = scan.nextInt();
				if(choixMenu < 1 || choixMenu > 4){
				    menu.messageErreur();
				    erreur = true;
				}else
				    erreur = false;
			    }catch(InputMismatchException e){
				menu.messageErreur();
				str = scan.next();
			    }
			}
		    }
		    
		    switch(choixMenu){
			case 1:
			    			    
			    ConsoleHelper.display("Veuillez rentrer la référence du produit sélectionné :");
			    ConsoleHelper.display(catController.get());
			    refProduit = scan.next();
			    while(!refProduit.equals(catalogue.retrieveProduit(refProduit).getReference())){				
				ConsoleHelper.display("Cette référence n'existe pas, veuillez recommencer :");
				refProduit = scan.next();
			    }
			    ConsoleHelper.display("Veuillez rentrer la quantité souhaitée :");
			    qteProd = scan.nextInt();
			    while(qteProd < 1){
				ConsoleHelper.display("Erreur quantité, veuillez rentrer une quantité positive :");
				qteProd = scan.nextInt();
			    }
			    if(!panier.getPanier().contains(catalogue.retrieveProduit(refProduit))){
				panier.add(catalogue.retrieveProduit(refProduit));
				catalogue.retrieveProduit(refProduit).setQuantité(qteProd);
			    }
			    else{
				catalogue.retrieveProduit(refProduit).setQuantité(catalogue.retrieveProduit(refProduit).getQuantité() + qteProd);
			    }
			    ConsoleHelper.display("Montant de votre réduction :" + (catalogue.retrieveProduit(refProduit).getPrixTotal()
				    * bddCont.getBdd().retrieveClient(nom, prenom).getCodePromo()/100));
			    break;
			case 2:
			    
			    break;
			case 3:
			    ConsoleHelper.display(panierCont.get());			    
			    ConsoleHelper.display("Montant de votre réduction :" +
				    bddCont.getBdd().retrieveClient(nom, prenom).montantPanier(panier)* 
				    bddCont.getBdd().retrieveClient(nom, prenom).getCodePromo()/100 + "€");
			    ConsoleHelper.display("Montant total de votre panier après réduction :" +
				    (bddCont.getBdd().retrieveClient(nom, prenom).montantPanier(panier)
				    - (bddCont.getBdd().retrieveClient(nom, prenom).montantPanier(panier)* 
				    bddCont.getBdd().retrieveClient(nom, prenom).getCodePromo()/100)) + "€");
			    break;
			case 4:
			    ConsoleHelper.read(scan, "Souhaitez-vous vraiment valider votre commande ? (1:OUI/2:NON)");
			    			    
			    //Gestion des erreurs de saisie 
			    while(rep < 1 || rep > 2){
				erreur = true;
				while(erreur){ 

				    try{
					rep = scan.nextInt();
					if(rep < 1 || rep > 2){
					    menu.messageErreur();
					    erreur = true;
					}else
					    erreur = false;
				    }catch(InputMismatchException e){
					menu.messageErreur();
					str = scan.next();
				    }
				}
			    }
			    
			    if(rep == 1){
				ConsoleHelper.display("Commande validée");
				panierCont.getPanier().valider(bddCont.getBdd().retrieveClient(nom, prenom));
				bddCont.sauvegarder();
//				bddCont.getBdd().retrieveClient(nom, prenom).setPanier(panier);
			    }
			    break;
			default:
			    menu.messageErreur();
			    break;
		    }
		    menu.afficherRetour();
		    retour = scan.next();
		}
		bddCont.sauvegarder();
		break;
		
	    case 4:
		retour = "";
		while(!retour.equals("n")){
		    ConsoleHelper.display(bddCont.get());
		    ConsoleHelper.display("Veuillez rentrer l'identifiant client à traiter :");
		    idCl = scan.next();
		    while(!idCl.equals(bdd.retrieveClient(idCl).getId())){
			ConsoleHelper.display("ID inconnu, veuillez recommencer");
			idCl = scan.next();
		    }
		    menu.affichageMenu(choixCat);
		    
		    //Gestion des erreurs de saisie 
		    while(choixMenu < 1 || choixMenu > 2){
			erreur = true;
			while(erreur){ 

			    try{
				choixMenu = scan.nextInt();
				if(choixMenu < 1 || choixMenu > 2){
				    menu.messageErreur();
				    erreur = true;
				}else
				    erreur = false;
			    }catch(InputMismatchException e){
				menu.messageErreur();
				str = scan.next();
			    }
			}
		    }
		    
		    switch(choixMenu){
			case 1:
			    ConsoleHelper.display(catController.get());
			    ConsoleHelper.read(scan, "Veuillez rentrer la référence du produit sélectionné :");
			    refProduit = scan.next();
			    while(!refProduit.equals(catalogue.retrieveProduit(refProduit).getReference())){				
				ConsoleHelper.display("Cette référence n'existe pas, veuillez recommencer :");
				refProduit = scan.next();
			    }
			    ConsoleHelper.display("Veuillez rentrer la quantité souhaitée :");
			    qteProd = scan.nextInt();
			    while(qteProd < 1){
				ConsoleHelper.display("Erreur quantité, veuillez rentrer une quantité positive :");
				qteProd = scan.nextInt();
			    }
			    if(!bdd.retrieveClient(idCl).getPanier().contains(catalogue.retrieveProduit(refProduit))){
				bdd.retrieveClient(idCl).getPanier().add(catalogue.retrieveProduit(refProduit));
				catalogue.retrieveProduit(refProduit).setQuantité(qteProd);
			    }
			    else{
				catalogue.retrieveProduit(refProduit).setQuantité(catalogue.retrieveProduit(refProduit).getQuantité() + qteProd);
			    }
			    break;
			case 2:
			    ConsoleHelper.display(panierCont.getPanierView().afficherCommandes(bddCont.getBdd().retrieveClient(idCl)));			    
			    break;
			default:
			    menu.messageErreur();
			    break;
		    }	
		    bddCont.sauvegarder();
		    catController.sauvegarder();
		    menu.afficherRetour();
		    retour = scan.next();
		}
		break;
	    default:
		menu.messageErreur();
		break;
	}
    }


//    public static void jDer(){
//
//	final DataView userData = mainController.get("user:display");
//	final StringView userView = new UserTextFrenchView();
//	ConsoleHelper.display(userView.build(userData));
//
//	//Demande l'ajout d'une personne en une seul fois
//	final ConsoleInputView customerCreateView = new PersonCreateFrenchView();
//	customerCreateView.ask(scan);
//	DataParam newCustomer = new BasicDataParam();
//	final DataView customerAddDataBulk = mainController.get("person:add", newCustomer);
//	final StringView customerAddViewBulk = new PersonAddFrenchView();
//
//	ConsoleHelper.display(customerAddViewBulk.build(customerAddDataBulk));
//
//
//	// get a Person
//	DataParam searchPersonParam = new BasicDataParam();
//	searchPersonParam.add("id", "10"); //0-5 inconu, 5-10 TEST, >10 DERUETTE
//	final DataView customerData = mainController.get("person:get", searchPersonParam);
//	final StringView customerGetView = new PersonGetFrenchView();
//
//	ConsoleHelper.display(customerGetView.build(customerData));
//
//	//demande l'ajout d'une personne attribut/attribut
//	String personId = ConsoleHelper.read(scan, "Quel est l'ID du client ?");
//	newCustomer.add("id", personId); // <100 = OK, sinon KO
//	String personNom = ConsoleHelper.read(scan, "Quel est le nom du client ?");
//	newCustomer.add("nom", personNom);
//	String personPrenom = ConsoleHelper.read(scan, "Quel est le prénom du client ?");
//	newCustomer.add("prenom", personPrenom);
//
//	final DataView customerAddData = mainController.get("person:add", newCustomer);
//	final StringView customerAddView = new PersonAddFrenchView();
//
//	ConsoleHelper.display(customerAddView.build(customerAddData));
//
//    }
//
//

    private static void initUserModel() {
	final UserModel userModel = new UserModel();
	userModel.register(mainController);
    }

    //	private static void initCustomerModel() {
    //	    final PersonGetModel customerGetModel = new PersonGetModel();
    //	    customerGetModel.register(mainController);
    //
    //	    final PersonAddModel customerAddModel = new PersonAddModel();
    //	    customerAddModel.register(mainController);
    //	}
    
}
