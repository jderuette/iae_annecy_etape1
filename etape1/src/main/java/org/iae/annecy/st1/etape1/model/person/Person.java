package org.iae.annecy.st1.etape1.model.person;

import java.io.Serializable;
import java.util.ArrayList;

import org.iae.annecy.st1.common.mvc.AbstractDataView;
import org.iae.annecy.st1.etape1.model.panier.Panier;
import org.iae.annecy.st1.etape1.model.produit.Produit;

public class Person extends AbstractDataView implements Serializable{

    private String id;
    private String nom;
    private String prenom;
    private Integer numero;
    private double codePromo;
    private ArrayList<Produit> panier = new ArrayList<Produit>();
    private Panier panier2;

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

    // public Person(DataView datas){
    // this.id = datas.getData("id");
    // this.prenom = datas.getData("prenom");
    // this.nom = datas.getData("nom");
    // }

    // public DataView asDataView() {
    // DataView datas = new BasicDataView();
    // datas.add("id", id.toString());
    // datas.add("nom", nom);
    // datas.add("prenom", prenom);
    //
    // return datas;
    // }

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

    public double montantPanier(Panier panier){
	double total = 0;
	for (Produit produit : panier.getPanier()) {
	    total += produit.getQuantité()*produit.getPrix();
	}
	return total;
    }

    public void setPanier(Panier panier) {
	// TODO Auto-generated method stub
	this.panier2 = panier;
    }
}
