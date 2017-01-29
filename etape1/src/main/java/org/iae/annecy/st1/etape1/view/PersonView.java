package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.etape1.model.person.Person;

public class PersonView{

    /**
     * Affiche toutes les caractéristiques d'un client
     * @param p
     * 		le client concerné
     * @return une description du client sous forme de chaine de texte
     */
    public String affichageClients(Person person){
	StringBuffer sb = new StringBuffer("id : ");
	sb.append(person.getId()) .append(", Nom : ") .append(person.getNom()) .append(", Prénom : ") .append(person.getPrenom())
		.append(", Numéro Client :") .append(person.getNumero()) .append(", Code promotionnel : ") .append(person.getCodePromo()) .append("%");
	return sb.toString();
    }
}
