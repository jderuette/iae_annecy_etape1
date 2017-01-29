package org.iae.annecy.st1.etape1.model.person;

import java.io.Serializable;
import java.util.ArrayList;

import org.iae.annecy.st1.etape1.model.panier.Item;

public class Person implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6173027789716365962L;
    private String id;
    private String nom;
    private String prenom;
    private Integer numero;
    private Double codePromo;
    private ArrayList<Item> panier = new ArrayList<Item>();
    
    public Person(){
	super();
    }

    public Person(String id, String nom, String prenom){
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
    }

    public Person(String id, String nom, String prenom, Integer numero, Double codePromo){
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.numero = numero;
	this.codePromo = codePromo;
    }

    public String getId() {
	return id;
    }

    public void setId(final String id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(final String nom) {
	this.nom = nom;
    }

    public String getPrenom() {
	return prenom;
    }

    public void setPrenom(final String prenom) {
	this.prenom = prenom;
    }

    public Integer getNumero() {
	return numero;
    }

    public void setNumero(Integer numero) {
	this.numero = numero;
    }

    public Double getCodePromo() {
	return codePromo;
    }

    public void setCodePromo(double codePromo) {
	this.codePromo = codePromo;
    }

    public ArrayList<Item> getPanier() {
        return panier;
    }

    public void setPanier(ArrayList<Item> panier) {
        this.panier = panier;
    }

    /**
     * Calcule le montant total du panier
     * 
     * @return Un nombre (double)
     */
    public Double montantPanier(){
	Double total = 0.0;
	for (Item item : this.getPanier()) {
	    total += item.getQuantite()*item.getProduit().getPrix();
	}
	return total;
    }    
 
}
