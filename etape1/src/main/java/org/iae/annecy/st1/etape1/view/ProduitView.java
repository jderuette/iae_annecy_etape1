package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.model.produit.Produit;

public class ProduitView{
    
    /**
     * Affiche la description courte d'un produit
     * 
     * @param p
     * 		le produit concerné
     * @return une chaine de texte
     */
    public String affichageProduit(Produit p){
	String text = "Produit de référence : " + p.getReference() + "| Nom : " + p.getNom() + "| Description : " + p.getDescritpion() + "| Prix : " + p.getPrix() + "€ ";
	return text;
    }
    
    /**
     * Affiche la description longue d'un produit
     * 
     * @param p
     * 		le produit concerné
     * @return une chaine de texte
     */
    public String affichageProdComplet(Produit p){
	String text = "Produit de référence : " + p.getReference() + "| Nom : " + p.getNom() + "| Description : " + p.getDescritpion() + "| Prix : " + p.getPrix() +
		"€ | Description longue : " + p.getDescripLongue();
	return text;
    }

}
