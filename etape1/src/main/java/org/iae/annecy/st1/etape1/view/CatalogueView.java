package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;

public class CatalogueView{
    
    private ProduitView prodV = new ProduitView();
    public CatalogueView(CatalogueController catCont){
	super();
    }
    
    /**
     * Affiche le catalogue avec toutes les caractéristiques des produits sauf 
     * la description longue
     * 
     * @param catalogue
     * 		le catalogue qui contient la liste des produits
     * @return La liste des produits contenus dans le catalogue
     */
    public String afficherCatalogue(Catalogue catalogue){
	String text = "";
	int i = 1;
	for (Produit produit : catalogue.getListeProduits()) {
	    text += i + ": " + prodV.affichageProduit(produit)+ "\n";
	    i++;
	}
	return text;
    }
    
    /**
     * Affiche le catalogue avec toutes les caractéristiques des produits
     * 
     * @param catalogue
     * 		le catalogue qui contient la liste des produits
     * @return La liste des produits contenus dans le catalogue
     */
    public String afficherCatComplet(Catalogue catalogue){
	String text = "";
	int i = 1;
	for (Produit produit : catalogue.getListeProduits()) {
	    text += i + ": " + prodV.affichageProdComplet(produit)+ "\n";
	    i++;
	}
	return text;
    }

}
