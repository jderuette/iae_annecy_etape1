package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.controller.BaseDeDonneesController;
import org.iae.annecy.st1.etape1.model.person.BaseDeDonnees;
import org.iae.annecy.st1.etape1.model.person.Person;

public class BaseDeDonneesView{

    private PersonView personV = new PersonView();
    
    public BaseDeDonneesView(BaseDeDonneesController bddController){
	super();
    }
    
    public String afficherBdd(BaseDeDonnees bdd){
	String text = "";
	for (Person client : bdd.getBaseClients()) {
	    text += personV.affichageClients(client)+ "\n";
	}
	return text;
    }
}
