package org.iae.annecy.st1.etape1.view.catalogue;

import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.produit.ProduitView;

public class CatalogueView{
    
    private ProduitView prodV = new ProduitView();
    public CatalogueView(CatalogueController catCont){
	super();
    }
    
    public String afficherCatalogue(Catalogue catalogue){
	String text = "";
	int i = 1;
	for (Produit produit : catalogue.getListeProduits()) {
	    text += i + ": " + prodV.affichageProduit(produit)+ "\n";
	    i++;
	}
	return text;
    }
    
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
