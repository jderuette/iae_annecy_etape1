package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.tools.ConsoleHelper;

public class MenuView{

    /*
     * Affiche les menus principaux suivant le rôle de la personne
     * 
     * @param cat
     * 		le nombre récupéré par le scanner
     * 		===> compris entre 1 et 4
     * 
     * @return Le menu principal sous forme de chaines de caractères
     */
    public void affichageMenu(Integer cat){
	String message = null;
	switch(cat){
	    case 1:
		message = "**************MENU PRINCIPAL**************\n"
			+ "\t1. Modifier un produit\n"
			+ "\t2. Ajouter un produit\n"
			+ "\t3. Supprimer un produit\n"
			+ "\t4. Afficher le catalogue\n";
		break;
	    case 2:
		message = "**************MENU PRINCIPAL**************\n"
			+ "\t1. Modifier un client\n"
			+ "\t2. Ajouter un client\n"
			+ "\t3. Supprimer un client\n"
			+ "\t4. Afficher la liste des clients\n";
		break;
	    case 3: 
		message = "**************MENU PRINCIPAL**************\n"
			+ "\t1. Ajouter un produit au panier\n"
			+ "\t2. Supprimer un produit du panier\n"
			+ "\t3. Voir le panier\n"
			+ "\t4. Valider la commande";
		break;
	    case 4:
		message = "**************MENU PRINCIPAL**************\n"
			+ "\t1. Valider une commande\n"
			+ "\t2. Consulter la liste des produits achetés";
		break;
	    default:
		this.messageErreur();
	}
	ConsoleHelper.display(message);
    }

    /*
     * Affiche le menu pour choisir la caractéristique du produit à modifier
     */
    public void affichageCaracProduits(){
	String message = ".............. Vous souhaitez ..........\n"
		+ "\t1. Modifier le nom\n"
		+ "\t2. Modifier la description\n"
		+ "\t3. Modifier la description longue\n"
		+ "\t4. Modifier le prix";
	ConsoleHelper.display(message);
    }

    /*
     * Affiche le menu de gestion du panier pour le client
     */
    public void affichagePanier(){
	String message = ".............. Vous souhaitez ..........\n"
		+ "\t1. Ajouter un produit au panier\n"
		+ "\t2. Supprimer un produit du panier\n"
		+ "\t3. Voir le panier\n"
		+ "\t4. Valider la commande";
	ConsoleHelper.display(message);
    }

    /*
     * Affiche le menu pour choisir entre l'affiche de la description
     * courte ou longue des produits
     */
    public void afficherDescription(){
	String message = "... vous souhaitez afficher le catalogue...\n"
		+ "\t1. Avec description courte\n"
		+ "\t2. Avec description longue";
	ConsoleHelper.display(message);
    }

    /*
     * Affiche le menu pour retourner au menu principal
     * ou quitter le programme
     */
    public void afficherRetour(){
	String message = "Voulez-vous retourner au Menu Principal ? (o/n)";
	ConsoleHelper.display(message);
    }

    /*
     * Affiche un message d'erreur
     */
    public void messageErreur(){
	String message = "Commande invalide, veuillez recommencer :";
	ConsoleHelper.display(message);
    }

    /*
     * Affiche le menu pour modifier une caractéristique d'un client pour
     * le responsable clientèle
     */
    public void affichageCaracClients(){
	String message = ".............. Vous souhaitez ..........\n"
		+ "\t1. Modifier le nom\n"
		+ "\t2. Modifier le prénom\n"
		+ "\t3. Modifier le numéro client\n"
		+ "\t4. Modifier le code promotionnel";
	ConsoleHelper.display(message);
    }

    /*
     * Affiche le menu de démarrage qui permet de préciser notre rôle
     */
    public void afficherCatégorie(){
	String message = "*********VOUS ETES***********\n"
		+ "\t1. Responsable produit\n"
		+ "\t2. Responsable clientèle\n"
		+ "\t3. Client\n"
		+ "\t4. Vendeur";
	ConsoleHelper.display(message);
    }

}
