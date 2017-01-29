package org.iae.annecy.st1.etape1.model.produit;

import org.iae.annecy.st1.etape1.model.panier.Item;

public class Produit implements java.io.Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 685930115586177076L;
    private String reference, descritpion, nom, descripLongue;
    private Double prix;
    private Integer quantite;
    private Item item;

    public Produit(){	
    }

    public Produit(String reference,String nom, String description, Double prix){
	this.reference = reference;
	this.nom = nom;
	this.descritpion = description;
	this.prix = prix;
    }

    public Produit(String reference,String nom, String description, String descL, Double prix){
	this.reference = reference;
	this.nom = nom;
	this.descritpion = description;
	this.descripLongue = descL;
	this.prix = prix;
    }

    public Double getPrix() {
	return prix;
    }

    public void setPrix(Double prix) {
	this.prix = prix;
    }

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public String getDescritpion() {
	return descritpion;
    }

    public void setDescritpion(String descritpion) {
	this.descritpion = descritpion;
    }

    public String getDescripLongue() {
	return descripLongue;
    }

    public void setDescripLongue(String descripLongue) {
	this.descripLongue = descripLongue;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }
    public Integer getQuantite() {
	return quantite;
    }
       
    public Item getItem(){
	return item;
    }

}
