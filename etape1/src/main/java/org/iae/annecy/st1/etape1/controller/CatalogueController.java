package org.iae.annecy.st1.etape1.controller;

import org.iae.annecy.st1.etape1.model.produit.Catalogue;

public class CatalogueController implements java.io.Serializable{

    Catalogue cat = new Catalogue();
    
    public String get(){
	return cat.afficherCatalogue();
    }
    
    public String getCatComplet(){
	return cat.afficherCatComplet();
    }

    public Catalogue getCat() {
        
	return cat;
    }

    public void setCat(Catalogue cat) {
        this.cat = cat;
    }
    
    
}
