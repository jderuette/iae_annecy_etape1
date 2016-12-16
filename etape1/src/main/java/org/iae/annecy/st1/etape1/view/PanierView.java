package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.controller.PanierController;
import org.iae.annecy.st1.etape1.model.person.Person;
import org.iae.annecy.st1.etape1.model.produit.Produit;

public class PanierView{
    
    public PanierView(PanierController panierCont){
	super();
    }
    
    /*
     * Affiche le panier avant validation
     * 
     * @param p
     * 		le client à qui appartient le panier
     * @return La liste des produits du panier 
     */
    public String afficherPanier(Person p){
	String text = "Réf :\t\tNom :\t\tPrix :\t\tQté :\t\tPrix total par produit :\n";
	double total = 0;
	for (Produit produit : p.getPanier()) {
	    text += produit.getReference() + "\t\t" + produit.getNom() + "\t\t" + produit.getPrix() + "€\t\t" + produit.getQuantité() + "\t\t" + 
		    + produit.getQuantité()*produit.getPrix() + "€\n";
	    total += produit.getQuantité()*produit.getPrix();
	}
	text += "\nMontant total du panier avant réduction : " + total + "€";
	return text;
    }
    /*
     * Affiche le panier qui a été validé
     * 
     * @param p
     * 		Le client à qui appartient la commande
     * @return La liste des produits qu'il a commandé
     */
    public String afficherCommandes(Person p){
	String text = "Réf :\t\tNom :\t\tPrix :\t\tQté :\t\tPrix total par produit :\n";
	for (Produit produit : p.getPanier()) {
	    text += produit.getReference() + "\t\t" + produit.getNom() + "\t\t" + produit.getPrix() + "€\t\t" + produit.getQuantité() + "\t\t" + 
		    + produit.getQuantité()*produit.getPrix() + "€\n";
	}
	return text;
    }
    
    
}
