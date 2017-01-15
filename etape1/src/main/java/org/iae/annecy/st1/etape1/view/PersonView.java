package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.model.person.Person;

public class PersonView{

    /**
     * Affiche toutes les caractéristiques d'un client
     * @param p
     * 		le client concerné
     * @return une description du client sous forme de chaine de texte
     */
    public String affichageClients(Person p){
	String text = "id : " + p.getId() + ", Nom : " + p.getNom() + ", Prénom : " + p.getPrenom()
		+ ", Numéro Client :" + p.getNumero() + ", Code promotionnel : " + p.getCodePromo() + "%";
	return text;
    }
}
