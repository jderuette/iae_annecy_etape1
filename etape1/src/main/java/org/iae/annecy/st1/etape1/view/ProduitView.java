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
    public String affichageProduit(Produit produit){
	StringBuffer sb = new StringBuffer("Produit de référence : ");
	sb.append(produit.getReference()) .append("| Nom : ") .append(produit.getNom()) .append("| Description : ") .append(produit.getDescritpion()) .append("| Prix : " + produit.getPrix()) .append("€ ");
	return sb.toString();
    }
    
    /**
     * Affiche la description longue d'un produit
     * 
     * @param p
     * 		le produit concerné
     * @return une chaine de texte
     */
    public String affichageProdComplet(Produit produit){
	StringBuffer sb = new StringBuffer("Produit de référence : ");
	sb.append(produit.getReference()) .append("| Nom : ") .append(produit.getNom()) .append("| Description : ") .append(produit.getDescritpion()) .append("| Prix : ") .append(produit.getPrix())
		.append("€ | Description longue : ") .append(produit.getDescripLongue());
	return sb.toString();
    }

}
