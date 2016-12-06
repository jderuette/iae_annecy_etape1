package org.iae.annecy.st1.etape1.view.produit;

import org.iae.annecy.st1.etape1.model.produit.Produit;

public class ProduitView{
    
    public String affichageProduit(Produit p){
	String text = "Produit de référence : " + p.getReference() + "| Nom : " + p.getNom() + "| Description : " + p.getDescritpion() + "| Prix : " + p.getPrix() + "€ ";
	return text;
    }
    
    public String affichageProdComplet(Produit p){
	String text = "Produit de référence : " + p.getReference() + "| Nom : " + p.getNom() + "| Description : " + p.getDescritpion() + "| Prix : " + p.getPrix() +
		"€ | Description longue : " + p.getDescripLongue();
	return text;
    }

}
