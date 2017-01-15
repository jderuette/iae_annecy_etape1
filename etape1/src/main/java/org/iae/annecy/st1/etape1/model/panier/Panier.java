package org.iae.annecy.st1.etape1.model.panier;

import java.io.Serializable;
import java.util.ArrayList;

import org.iae.annecy.st1.etape1.model.person.Person;
import org.iae.annecy.st1.etape1.model.produit.Produit;

@SuppressWarnings("serial")
public class Panier implements Serializable{

    private ArrayList<Produit> panier = new ArrayList<Produit>();
    private Person client = new Person();

    public ArrayList<Produit> getPanier() {
	return panier;
    }

    public void setPanier(ArrayList<Produit> panier) {
	this.panier = panier;
    }

    public void add(Produit produit){
	this.panier.add(produit);
    }

    public Person getClient() {
	return this.client;
    }

    public void setClient(Person client) {
	this.client = client;
    }

    public void supprimerProduit(Produit produit){
	this.panier.remove(produit);
    }

}
