package org.iae.annecy.st1.etape1.model.produit;

public class Produit implements java.io.Serializable{

    private String reference, descritpion, nom, descripLongue;
    private double prix;

    public Produit(){
	
    }
    public Produit(String reference,String nom, String description, double prix){
	this.reference = reference;
	this.nom = nom;
	this.descritpion = description;
	this.prix = prix;
    }
    public Produit(String reference,String nom, String description, String descL, double prix){
	this.reference = reference;
	this.nom = nom;
	this.descritpion = description;
	this.descripLongue = descL;
	this.prix = prix;
    }
    
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
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
    
    
    
    
    
    
}
