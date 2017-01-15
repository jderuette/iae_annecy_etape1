package org.iae.annecy.st1.etape1.model.person;

import java.io.Serializable;
import java.util.ArrayList;

import org.iae.annecy.st1.etape1.model.produit.Produit;

@SuppressWarnings("serial")
public class Person implements Serializable{

    private String id;
    private String nom;
    private String prenom;
    private Integer numero;
    private double codePromo;
    private ArrayList<Produit> panier = new ArrayList<Produit>();
    
    public Person(){
	super();
    }

    public Person(String id, String nom, String prenom){
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
    }

    public Person(String id, String nom, String prenom, Integer numero, double codePromo){
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

    public double getCodePromo() {
	return codePromo;
    }

    public void setCodePromo(double codePromo) {
	this.codePromo = codePromo;
    }

    public ArrayList<Produit> getPanier() {
        return panier;
    }

    public void setPanier(ArrayList<Produit> panier) {
        this.panier = panier;
    }

    /**
     * Calcule le montant total du panier
     * 
     * @return Un nombre (double)
     */
    public double montantPanier(){
	double total = 0;
	for (Produit produit : this.getPanier()) {
	    total += produit.getQuantite()*produit.getPrix();
	}
	return total;
    }    
 
}
