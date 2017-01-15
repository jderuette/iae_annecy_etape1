package org.iae.annecy.st1.etape1.controller;

import java.io.Serializable;

import org.iae.annecy.st1.etape1.model.person.BaseDeDonnees;
import org.iae.annecy.st1.etape1.model.person.Person;
import org.iae.annecy.st1.etape1.view.BaseDeDonneesView;

@SuppressWarnings("serial")
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

    /**
     * Permet de retrouver un client à partir de ses nom et prénom 
     * 		===> sensible à la casse
     * 
     * @param nom, prenom
     * 		nom du client à retrouver
     * 		prénom du client à retrouver
     * 
     * @return le client à retrouver
     */
    public Person retrouveClient(String nom, String prenom){
	Person p = new Person();
	p = this.getBdd().retrieveClient(nom, prenom);
	return p;
    }

}
