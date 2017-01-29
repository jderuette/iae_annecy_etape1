package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.model.person.BaseDeDonnees;
import org.iae.annecy.st1.etape1.model.person.Person;

public class BaseDeDonneesView{

    private PersonView personV = new PersonView();
    
    public BaseDeDonneesView(){
	super();
    }
    
    /**
     * Affiche la liste des clients avec leurs caractéristiques
     * 
     * @param bdd
     * 		la base de données dans laquelle sont enregistrés les clients
     * @return la liste des clients avec leurs caractéristiques sous forme de chaine de texte
     */
    public String afficherBdd(BaseDeDonnees bdd){
	String text = "";
	for (Person client : bdd.getBaseClients()) {
	    text += personV.affichageClients(client)+ "\n";
	}
	return text;
    }
}
