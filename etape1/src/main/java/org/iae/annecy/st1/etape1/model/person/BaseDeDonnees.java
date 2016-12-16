package org.iae.annecy.st1.etape1.model.person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public class BaseDeDonnees implements Serializable{

    private ArrayList<Person> baseClients = new ArrayList<Person>();

    public ArrayList<Person> getBaseClients() {
	return baseClients;
    }

    public void setBaseClients(ArrayList<Person> baseClients) {
	this.baseClients = baseClients;
    }

    public void ajouterClient(Person p){	
	this.baseClients.add(p);
	saveBdd();
    }

    public void supprimerClient(Person p){
	this.baseClients.remove(p);
	saveBdd();
    }

    /*
     * Permet de retrouver un client à partir de son ID
     * 
     * @param id
     * 		id du client à retrouver
     * @return Un client
     */
    public Person retrieveClient (String id){
	Iterator<Person> it = this.getBaseClients().iterator();
	Person client = new Person();
	while(it.hasNext()){
	    Person current = it.next();
	    if(current.getId().equals(id)){
		client = current;
		break;
	    }
	}
	return client;
    }

    /*
     * Permet de retrouver un client à partir de ses nom et prénom
     * 
     * @param nom, prenom
     * 		nom du client à retrouver
     * 		prénom du client à retrouver
     * 
     * @return Un client 
     */
    public Person retrieveClient (String nom, String prenom){
	Iterator<Person> it = this.getBaseClients().iterator();
	Person client = new Person();
	while(it.hasNext()){
	    Person current = it.next();
	    if(current.getNom().equals(nom) && current.getPrenom().equals(prenom)){
		client = current;
		break;
	    }
	}
	return client;
    }

    /*
     * Sérialise la base de données clients
     */
    @SuppressWarnings("resource")
    public void saveBdd(){
	try{
	    FileOutputStream fos = new FileOutputStream("clients.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(this);
	}catch (IOException ioe){
	    ioe.printStackTrace();
	}
    }

}
