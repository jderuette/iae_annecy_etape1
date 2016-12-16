/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.iae.annecy.st1.etape1.controller.BaseDeDonneesController;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.PanierController;
import org.iae.annecy.st1.etape1.model.person.BaseDeDonnees;
import org.iae.annecy.st1.etape1.model.person.Person;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.MenuView;
import org.iae.annecy.st1.tools.ConsoleHelper;

/**
 * Classe permetant de tester le MVC.
 * 
 * @author Djer1013
 */
public class Main {   

    /**
     * Lance l'application.
     * 
     * @param args
     *            command line parameters
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static void main(final String[] args) throws ClassNotFoundException, IOException {

	Scanner scan = new Scanner(System.in, "UTF-8");	

	final Produit p1 = new Produit("aaaa", "chaise", "blabla", 3.00);
	final Produit p2 = new Produit("bbbb", "bureau", "nduezbf", 4.05);
	p1.setDescripLongue("Cette chaise est la toute nouvelle chaise hyper ergonomique qui vous permet de ne plus avoir mal aux fesses quand vous restez assis pendant des heures");
	p2.setDescripLongue("Ce bureau rendra tous vos collègues jaloux, croyez-nous sur parole!");
	Person pers1 = new Person("1", "Chanrion", "Skivana");
	Person pers2 = new Person("2", "Barjoux", "Mélodie");

	BaseDeDonnees bdd = null;
	Catalogue catalogue = null;
	MenuView menu = new MenuView();

	/**
	 * Désérialisation du catalogue
	 */
	try {
	    FileInputStream fis = new FileInputStream("catalogue.ser");
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("catalogue.ser"));
	    catalogue = (Catalogue) ois.readObject();
	    fis.close();
	    ois.close();
	}catch(FileNotFoundException e){
	    catalogue = new Catalogue();
	    catalogue.ajouterProduit(p1);
	    catalogue.ajouterProduit(p2);
	}

	/**
	 * Désérialisation de la base de données clients
	 */
	try {
	    FileInputStream fis2 = new FileInputStream("clients.ser");
	    ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("clients.ser"));
	    bdd = (BaseDeDonnees) ois2.readObject();
	    fis2.close();
	    ois2.close();
	}catch(FileNotFoundException ioe){
	    bdd = new BaseDeDonnees();
	    bdd.ajouterClient(pers1);
	    bdd.ajouterClient(pers2);
	}	    

	CatalogueController catController = new CatalogueController();
	catController.setCat(catalogue);
	BaseDeDonneesController bddCont = new BaseDeDonneesController();
	bddCont.setBdd(bdd);
	PanierController panierCont = new PanierController();

	Integer choixMenu = 0;
	Integer choixCat = 0;	
	String retour = "";	
	boolean erreur = true;


	menu.afficherCategorie();

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
		    scan.next();
		}
	    }
	}


	switch(choixCat){	    
	    //Si choix: responsable produit
	    case 1:	
		//Gestion de demande de retour au menu principal
		while(!retour.equals("n")){
		    menu.affichageMenu(choixCat);
		    choixMenu = 0;

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
				scan.next();
			    }
			}
		    }	
		    //Choix : produit à modifier
		    switch (choixMenu) {			
			case 1:	
			    Integer choixAttribut = 0;
			    String choixProduit = "";

			    ConsoleHelper.display(catController.get());
			    ConsoleHelper.display("Veuillez rentrer la référence du produit à modifier : ");
			    choixProduit = scan.next();

			    //Gestion des erreurs: mauvaise référence produit
			    while(!choixProduit.equals(catController.getCat().retrieveProduit(choixProduit).getReference())){				
				ConsoleHelper.display("Cette référence n'existe pas, veuillez recommencer :");
				choixProduit = scan.next();
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
					scan.next();
				    }
				}
			    }

			    //Choix : caractéristique du produit à modifier
			    switch(choixAttribut){

				case 1:
				    ConsoleHelper.display("Veuillez rentrer le nouveau nom :");
				    catController.getCat().retrieveProduit(choixProduit).setNom(scan.next());
				    break;
				case 2:				    
				    ConsoleHelper.display("Veuillez rentrer la nouvelle description :");
				    scan.nextLine();
				    catController.getCat().retrieveProduit(choixProduit).setDescritpion(scan.nextLine());				    
				    break;
				case 3:
				    ConsoleHelper.display("Veuillez rentrer la nouvelle description longue :");
				    scan.nextLine();	//vider le Scanner
				    catController.getCat().retrieveProduit(choixProduit).setDescripLongue(scan.nextLine());
				    break;
				case 4:	
				    double newPrix = 0.0;
				    ConsoleHelper.display("Veuillez rentrer le nouveau prix :");

				    //Gestion des erreurs de saisie 
				    while(newPrix <= 0 ){
					erreur = true;
					while(erreur){ 
					    try{
						newPrix = scan.nextDouble();
						if(newPrix <= 0 ){
						    ConsoleHelper.display("Veuillez rentrer un prix positif :");
						    erreur = true;
						}else
						    erreur = false;
					    }catch(InputMismatchException e){
						menu.messageErreur();
						scan.next();
					    }
					}
				    }
				    catController.getCat().retrieveProduit(choixProduit).setPrix(newPrix);
				    ConsoleHelper.display("Le nouveau prix du produit référence : " + catController.getCat().retrieveProduit(choixProduit).getReference() +
					    " est : " + newPrix + "€");
				    break;
				default:
				    menu.messageErreur();
				    break;
			    }			    
			    catController.sauvegarder();
			    break;

			    //Choix : ajout d'un nouveau produit
			case 2:
			    String ref = "";
			    String nom = "";
			    String desc = "";
			    String descL = "";
			    double prix = 0.0;

			    ConsoleHelper.display("Veuillez rentrer la référence du produit : ");
			    ref = scan.next();

			    while(ref.equals(catController.getCat().retrieveProduit(ref).getReference())){				
				ConsoleHelper.display("Cette référence existe déjà, veuillez choisir une autre référence");
				ref = scan.next();
			    }

			    ConsoleHelper.display("Veuillez rentrer le nom du produit : ");
			    nom = scan.next();
			    scan.nextLine();	//vide le scanner
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
					scan.next();
				    }
				}
			    }

			    scan.nextLine(); //Vide le scanner
			    ConsoleHelper.display("Veuillez rentrer la description longue du produit : ");
			    descL = scan.nextLine();			    
			    catController.getCat().ajouterProduit(new Produit(ref, nom, desc, descL, prix));
			    ConsoleHelper.display("Récapitulatif du produit ajouté => référence :" + ref + "| Nom : " + nom + "| Description : " + desc + "| Prix : " + prix + "€| Description longue : " + descL);
			    break;

			    //Choix : supprimer un produit
			case 3:				    
			    ConsoleHelper.display(catController.get());
			    ConsoleHelper.display("Veuillez rentrer la référence du produit à supprimer :");
			    choixProduit = scan.next();
			    while(!choixProduit.equals(catController.getCat().retrieveProduit(choixProduit).getReference())){
				ConsoleHelper.display("Cette référence produit n'existe pas, veuillez recommencer :");
				choixProduit = scan.next();
			    }
			    catController.getCat().supprimerProduit(catController.getCat().retrieveProduit(choixProduit));
			    ConsoleHelper.display("Le produit référence : " + choixProduit + " a bien été supprimé.");
			    break;

			    //Choix : affichage du catalogue
			case 4:
			    Integer choixDes = 0;			
			    menu.afficherDescription();

			    //Gestion des erreurs de saisie 
			    while(choixDes  < 1 || choixDes > 2){
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
					scan.next();
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

		//Si choix: responsable clientèle
	    case 2:				
		retour = "";
		while(!retour.equals("n")){	
		    Integer choixMenu2 = 0;
		    menu.affichageMenu(choixCat );

		    //Gestion des erreurs de saisie 
		    while(choixMenu2 < 1 || choixMenu2 > 4){
			erreur = true;
			while(erreur){ 
			    try{
				choixMenu2 = scan.nextInt();
				if(choixMenu2 < 1 || choixMenu2 > 4){
				    menu.messageErreur();
				    erreur = true;
				}else
				    erreur = false;
			    }catch(InputMismatchException e){
				menu.messageErreur();
				scan.next();
			    }
			}
		    }	

		    switch (choixMenu2) {			
			//Choix : modification d'un client
			case 1:	
			    String clientId = "";
			    Integer choixModif = 0;

			    ConsoleHelper.display(bddCont.get());
			    ConsoleHelper.display("Quel est l'ID du client que vous souhaitez modifier ?");
			    clientId = scan.next();
			    while(!clientId.equals(bddCont.getBdd().retrieveClient(clientId).getId())){
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
					scan.next();
				    }
				}
			    }

			    //Choix : caractéristique à modifier
			    switch(choixModif){
				case 1:
				    ConsoleHelper.read(scan, "Veuillez rentrer le nouveau nom :");
				    bddCont.getBdd().retrieveClient(clientId).setNom(scan.next());
				    break;
				case 2:
				    ConsoleHelper.read(scan, "Veuillez rentrer le nouveau prénom :");
				    bddCont.getBdd().retrieveClient(clientId).setPrenom(scan.next());
				    break;
				case 3:
				    ConsoleHelper.display("Veuillez rentrer le nouveau numéro client :");
				    bddCont.getBdd().retrieveClient(clientId).setNumero(scan.nextInt());
				    break;
				case 4:
				    ConsoleHelper.display("Veuillez rentrer le nouveau code promotionnel :");
				    bddCont.getBdd().retrieveClient(clientId).setCodePromo(scan.nextDouble());
				    break;
				default:
				    menu.messageErreur();
				    break;
			    }			    
			    break;			    
			    //Choix : ajouter un client
			case 2:
			    String idClient = "";
			    String nomClient = "";
			    String prenomClient = "";
			    String numClient = "";
			    String codeP = "";
			    Integer numeroClient = 0;
			    Double codePromo = null;

			    scan.nextLine();	//Vide le scanner
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
			    else{
				//Gestion des erreurs de saisie 
				erreur = true;
				while(erreur){ 
				    try{
					codePromo = Double.parseDouble(codeP);					
					erreur = false;
				    }catch(NumberFormatException e){
					menu.messageErreur();
					codeP = scan.next();
				    }
				}
			    }

			    bddCont.getBdd().ajouterClient(new Person(idClient, nomClient, prenomClient, numeroClient, codePromo));
			    ConsoleHelper.display("Récapitulatif du client ajouté => ID : " + idClient + 
				    "\n Nom : " + nomClient	+ 
				    "\n Prénom : " + prenomClient + 
				    "\n Numéro Client : " + numeroClient + 
				    "\n Code Promotionnel : " + codePromo);
			    break;			    
			    //Choix : supprimer un client
			case 3:			    			    
			    ConsoleHelper.display(bddCont.get());
			    ConsoleHelper.display("Veuillez rentrer l'ID du client à supprimer :");
			    idClient = scan.next();
			    while(!idClient.equals(bddCont.getBdd().retrieveClient(idClient).getId())){
				ConsoleHelper.display("Cet ID n'existe pas, veuillez recommencer :");
				idClient = scan.next();
			    }
			    bddCont.getBdd().supprimerClient(bddCont.getBdd().retrieveClient(idClient));
			    break;			    
			    //Choix : afficher la liste des clients
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

		//Si choix: Client
	    case 3:
		String nomClient = "";
		String prenomClient = "";
		String clientId = "";
		retour = "";
		ConsoleHelper.read(scan, "Veuillez rentrer votre nom :");
		nomClient = scan.nextLine();
		ConsoleHelper.display("Veuillez rentrer votre prénom :");	
		prenomClient = scan.next();

		/*
		 * Retrouve le compte d'un client à partir de ses nom et prénom
		 */
		if(nomClient.equals(bddCont.retrouveClient(nomClient, prenomClient).getNom()) 
			|| prenomClient.equals(bddCont.retrouveClient(nomClient, prenomClient).getPrenom())){
		    ConsoleHelper.display(prenomClient + " " + nomClient + ", vous allez accéder à votre panier ....");
		    panierCont.getPanier().setClient(bddCont.retrouveClient(nomClient, prenomClient));

		}
		/*
		 * Crée un compte pour le nouveau client
		 */
		else{
		    ConsoleHelper.display("Bienvenue " + prenomClient + " " + nomClient + ", votre compte vient d'être créé ...");
		    clientId = String.valueOf(bddCont.getBdd().getBaseClients().size() + 1);
		    bddCont.getBdd().ajouterClient(new Person(clientId, nomClient, prenomClient));
		    panierCont.getPanier().setClient(bddCont.retrouveClient(nomClient, prenomClient));
		}
		while(!retour.equals("n")){		   
		    menu.affichageMenu(choixCat );
		    Integer choixPanier = 0;

		    //Gestion des erreurs de saisie 
		    while(choixPanier  < 1 || choixPanier > 4){
			erreur = true;
			while(erreur){ 

			    try{
				choixPanier = scan.nextInt();
				if(choixPanier < 1 || choixPanier > 4){
				    menu.messageErreur();
				    erreur = true;
				}else
				    erreur = false;
			    }catch(InputMismatchException e){
				menu.messageErreur();
				scan.next();
			    }
			}
		    }
		    String refP = "";
		    Integer qteProd = 0;

		    //Choix : gestion du panier
		    switch(choixPanier){
			//Choix : ajout d'un produit avec quantité
			case 1:			    			    
			    ConsoleHelper.display("Veuillez rentrer la référence du produit sélectionné :");
			    ConsoleHelper.display(catController.get());
			    refP = scan.next();
			    while(!refP.equals(catController.getCat().retrieveProduit(refP).getReference())){				
				ConsoleHelper.display("Cette référence n'existe pas, veuillez recommencer :");
				refP = scan.next();
			    }
			    ConsoleHelper.display("Veuillez rentrer la quantité souhaitée :");
			    qteProd = scan.nextInt();
			    while(qteProd < 1){				
				//Gestion des erreurs de saisie 
				erreur = true;
				while(erreur){ 
				    try{
					qteProd = scan.nextInt();
					if(qteProd < 1){
					    ConsoleHelper.display("Erreur quantité, veuillez rentrer une quantité positive :");
					    erreur = true;
					}
					else{					
					    erreur = false;
					}					
				    }catch(InputMismatchException e){
					menu.messageErreur();
					scan.next();
				    }
				}
			    }
			    if(!(bddCont.retrouveClient(nomClient, prenomClient).getPanier()).contains(catalogue.retrieveProduit(refP))){
				bddCont.retrouveClient(nomClient, prenomClient).getPanier().add(catController.getCat().retrieveProduit(refP));
				catController.getCat().retrieveProduit(refP).setQuantite(qteProd);
			    }
			    else{
				catController.getCat().retrieveProduit(refP).setQuantite(catController.getCat().retrieveProduit(refP).getQuantite() + qteProd);
			    }
			    break;
			    //Choix : supprimer un produit avec quantité
			case 2:
			    Integer qteP = 1000;
			    String refProd = "";

			    ConsoleHelper.display("Veuillez rentrer la référence du produit à supprimer :");
			    ConsoleHelper.display(catController.get());
			    refProd = scan.next();
			    while(!refProd.equals(catController.getCat().retrieveProduit(refProd).getReference())){				
				ConsoleHelper.display("Cette référence n'existe pas, veuillez recommencer :");
				refProd = scan.next();
			    }
			    ConsoleHelper.display("Veuillez rentrer le nombre de produits à supprimer :");
			    while(qteP > catController.getCat().retrieveProduit(refProd).getQuantite()){

				//Gestion des erreurs de saisie 
				erreur = true;
				while(erreur){ 
				    try{
					qteP = scan.nextInt();
					if(qteP > catController.getCat().retrieveProduit(refProd).getQuantite()){
					    ConsoleHelper.display("Erreur, veuillez rentrer une quantité valide :");
					    erreur = true;
					}
					else{					
					    erreur = false;
					}					
				    }catch(InputMismatchException e){
					menu.messageErreur();
					scan.next();
				    }
				}
			    }
			    catController.getCat().retrieveProduit(refProd).setQuantite(catController.getCat().retrieveProduit(refProd).getQuantite() - qteP);			    
			    break;
			    //Choix : afficher le panier avec la réduction et montant total
			case 3:
			    ConsoleHelper.display(panierCont.get());			    
			    ConsoleHelper.display("Montant de votre réduction :" +
				    bddCont.retrouveClient(nomClient, prenomClient).montantPanier()* 
				    bddCont.retrouveClient(nomClient, prenomClient).getCodePromo()/100 + "€");
			    ConsoleHelper.display("Montant total de votre panier après réduction :" +
				    (bddCont.retrouveClient(nomClient, prenomClient).montantPanier()
					    - (bddCont.retrouveClient(nomClient, prenomClient).montantPanier()* 
						    bddCont.retrouveClient(nomClient, prenomClient).getCodePromo()/100)) + "€\n");
			    break;
			    //Choix : valider son panier
			case 4:
			    Integer validation = 0;

			    ConsoleHelper.read(scan, "Souhaitez-vous vraiment valider votre commande ? (1:OUI/2:NON)");

			    //Gestion des erreurs de saisie 
			    while(validation  < 1 || validation > 2){
				erreur = true;
				while(erreur){ 

				    try{
					validation = scan.nextInt();
					if(validation < 1 || validation > 2){
					    menu.messageErreur();
					    erreur = true;
					}else
					    erreur = false;
				    }catch(InputMismatchException e){
					menu.messageErreur();
					scan.next();
				    }
				}
			    }

			    if(validation == 1){
				ConsoleHelper.display("Commande validée");				
				bddCont.retrouveClient(nomClient, prenomClient).getPanier().addAll(panierCont.getPanier().getPanier());
				bddCont.sauvegarder();				
			    }
			    else
				ConsoleHelper.display("Vous avez abandonné la validation de votre commande");
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
		//Si choix : Vendeur
	    case 4:
		retour = "";
		while(!retour.equals("n")){
		    Integer choixMenu4 = 0;		    
		    Integer qteProd = 0;
		    String refP = "";

		    ConsoleHelper.display(bddCont.get());
		    ConsoleHelper.display("Veuillez rentrer l'identifiant client à traiter :");
		    clientId = scan.next();
		    while(!clientId.equals(bdd.retrieveClient(clientId).getId())){
			ConsoleHelper.display("ID inconnu, veuillez recommencer");
			clientId = scan.next();
		    }		    
		    menu.affichageMenu(choixCat);

		    //Gestion des erreurs de saisie 
		    while(choixMenu4  < 1 || choixMenu4 > 2){
			erreur = true;
			while(erreur){ 
			    try{
				choixMenu4 = scan.nextInt();
				if(choixMenu4 < 1 || choixMenu4 > 2){
				    menu.messageErreur();
				    erreur = true;
				}else
				    erreur = false;
			    }catch(InputMismatchException e){
				menu.messageErreur();
				scan.next();
			    }
			}
		    }

		    switch(choixMenu4){
			//Choix : valider une commande
			case 1:

			    ConsoleHelper.display(catController.get());
			    ConsoleHelper.read(scan, "Veuillez rentrer la référence du produit sélectionné :");
			    refP = scan.next();
			    while(!refP.equals(catController.getCat().retrieveProduit(refP).getReference())){				
				ConsoleHelper.display("Cette référence n'existe pas, veuillez recommencer :");
				refP = scan.next();
			    }
			    ConsoleHelper.display("Veuillez rentrer la quantité souhaitée :");
			    qteProd = scan.nextInt();
			    while(qteProd < 1){
				ConsoleHelper.display("Erreur quantité, veuillez rentrer une quantité positive :");
				qteProd = scan.nextInt();
			    }
			    if(!bddCont.getBdd().retrieveClient(clientId).getPanier().contains(catController.getCat().retrieveProduit(refP))){
				bddCont.getBdd().retrieveClient(clientId).getPanier().add(catController.getCat().retrieveProduit(refP));
				catController.getCat().retrieveProduit(refP).setQuantite(qteProd);
			    }
			    else{
				catController.getCat().retrieveProduit(refP).setQuantite(catController.getCat().retrieveProduit(refP).getQuantite() + qteProd);
			    }
			    break;
			    //Choix : afficher liste des produits achetés par le client
			case 2:			    
			    ConsoleHelper.display(panierCont.getPanierView().afficherCommandes((bddCont.getBdd().retrieveClient(clientId))));
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
}
