package org.iae.annecy.st1.etape1.controller;

import org.iae.annecy.st1.etape1.model.panier.Panier;
import org.iae.annecy.st1.etape1.view.PanierView;

public class PanierController{

    private Panier panier = new Panier();
    private PanierView panierView = new PanierView(this);
    
    public String get(){
	return panierView.afficherPanier(panier.getClient());
    }

    public PanierView getPanierView() {
        return panierView;
    }

    public void setPanierView(PanierView panierView) {
        this.panierView = panierView;
    }

    public Panier getPanier() {
        return this.panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }  
}
