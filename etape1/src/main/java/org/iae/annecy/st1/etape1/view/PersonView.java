package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.model.person.Person;

public class PersonView{

    public String affichageClients(Person p){
	String text = "id : " + p.getId() + ", Nom : " + p.getNom() + ", Prénom : " + p.getPrenom()
		+ ", Numéro Client :" + p.getNumero() + ", Code promotionnel : " + p.getCodePromo() + "%";
	return text;
    }
}
