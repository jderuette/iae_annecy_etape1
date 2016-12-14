package org.iae.annecy.st1.etape1.controller;

import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.view.CatalogueView;

public class CatalogueController implements java.io.Serializable{

    Catalogue cat = new Catalogue();
    CatalogueView catV = new CatalogueView(this);
    
    public String get(){
	return catV.afficherCatalogue(cat);
    }
    
    public String getCatComplet(){
	return catV.afficherCatComplet(cat);
    }

    public CatalogueView getCatV() {
        
	return catV;
    }

    public void setCatV(CatalogueView catV) {
        this.catV = catV;
    }

    public Catalogue getCat() {
        return this.cat;
    }

    public void setCat(Catalogue cat) {
        this.cat = cat;
    }
    
    public void sauvegarder(){
	cat.save();
    }
    
}
