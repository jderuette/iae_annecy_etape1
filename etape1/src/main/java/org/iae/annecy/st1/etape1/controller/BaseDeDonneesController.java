package org.iae.annecy.st1.etape1.controller;

import java.io.Serializable;

import org.iae.annecy.st1.etape1.model.person.BaseDeDonnees;
import org.iae.annecy.st1.etape1.view.BaseDeDonneesView;

public class BaseDeDonneesController implements Serializable{

    BaseDeDonnees bdd = new BaseDeDonnees();
    BaseDeDonneesView bddView = new BaseDeDonneesView(this);

    public BaseDeDonnees getBdd() {
        return bdd;
    }

    public void setBdd(BaseDeDonnees bdd) {
        this.bdd = bdd;
    }

    public BaseDeDonneesView getBddView() {
        return bddView;
    }

    public void setBddView(BaseDeDonneesView bddView) {
        this.bddView = bddView;
    }
    
    public String get(){
	return bddView.afficherBdd(bdd);
    }
    
    public void sauvegarder(){
	bdd.saveBdd();
    }
    
}
