package org.iae.annecy.st1.etape1.model.panier;

import java.io.Serializable;
import java.util.ArrayList;

import org.iae.annecy.st1.etape1.model.person.Person;
import org.iae.annecy.st1.etape1.model.produit.Produit;

public class Panier implements Serializable{

    private ArrayList<Produit> panier = new ArrayList<Produit>();

    public ArrayList<Produit> getPanier() {
        return panier;
    }

    public void setPanier(ArrayList<Produit> panier) {
	this.panier = panier;
    }

    public void add(Produit produit){
	this.panier.add(produit);
    }
    
    public void valider(Person p){
	p.setPanier(panier);
    }
    
//    public void save(Person p){
//	this.client = p;
//	p.setPanier(this);
//    }
    
}
