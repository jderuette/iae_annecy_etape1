package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.model.panier.Item;
import org.iae.annecy.st1.etape1.model.person.Person;

public class PanierView{
    
    public PanierView(){
	super();
    }
    
    /**
     * Affiche le panier avant validation
     * 
     * @param p
     * 		le client à qui appartient le panier
     * @return La liste des produits du panier 
     */    
    public String afficherPanier(Person person){
	StringBuffer sb = new StringBuffer("Réf :\t\tNom :\t\tPrix :\t\tQté :\t\tPrix total par produit :");
	System.getProperty("line.separator");
	Double total = 0.0;
	for (Item item : person.getPanier()) {
	    sb.append(item.getProduit().getReference()) .append("\t\t") .append(item.getProduit().getNom()) .append("\t\t") .append(item.getProduit().getPrix()) .append("€\t\t") .append(item.getQuantite()) .append("\t\t")  
	    .append(item.getQuantite()*item.getProduit().getPrix());
	    System.getProperty("line.separator");
	    total += item.getQuantite()*item.getProduit().getPrix();
	}
	sb.append("\nMontant total du panier avant réduction : ") .append(total) .append("€");
	return sb.toString();
    }
    /**
     * Affiche le panier qui a été validé
     * 
     * @param p
     * 		Le client à qui appartient la commande
     * @return La liste des produits qu'il a commandé
     */
    public String afficherCommandes(Person person){
	StringBuffer sb = new StringBuffer("Réf :\t\tNom :\t\tPrix :\t\tQté :\t\tPrix total par produit");
	System.getProperty("line.separator");
	for (Item item : person.getPanier()) {
	    sb.append(item.getProduit().getReference()) .append("\t\t") .append(item.getProduit().getNom()) .append("\t\t") .append(item.getProduit().getPrix()) .append("€\t\t") 
	    .append(item.getQuantite()) .append("\t\t") .append(item.getQuantite()*item.getProduit().getPrix()) .append("€");
	    System.getProperty("line.separator");
	}
	return sb.toString();
    }
    
    
}
