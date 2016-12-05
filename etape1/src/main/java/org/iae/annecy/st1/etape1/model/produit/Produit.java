package org.iae.annecy.st1.etape1.model.produit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    
    public String affichageProduit(){
	String text = "Produit de référence : " + getReference() + "| Nom : " + getNom() + "| Description : " + getDescritpion() + "| Prix : " + getPrix() + "€ ";
	return text;
    }
    
    public String affichageProdComplet(){
	String text = "Produit de référence : " + getReference() + "| Nom : " + getNom() + "| Description : " + getDescritpion() + "| Prix : " + getPrix() +
		"€ | Description longue : " + getDescripLongue();
	return text;
    }
    
//    private  void writeObject(ObjectOutputStream oos)throws IOException {
//	oos.writeUTF(reference);
//	oos.writeUTF(descritpion);
//	oos.writeUTF(nom) ;
//	oos.writeUTF(descripLongue);
//	oos.writeDouble(prix);
//    }
//    
//    private  void readObject(ObjectInputStream ois)throws IOException, ClassNotFoundException {
//
//	       // l'ordre de lecture doit être le même que l'ordre d'écriture d'un objet
//	       this.reference = ois.readUTF() ;
//	       this.descritpion = ois.readUTF() ;
//	       this.nom = ois.readUTF();
//	       this.descripLongue = ois.readUTF();
//	       this.prix = ois.readDouble();
//    }
    
    public Produit deserialize(){
	Produit p = new Produit();
	    try{
		FileInputStream fis = new FileInputStream("file");
		ObjectInputStream ois = new ObjectInputStream(fis);
		p = (Produit) ois.readObject();
		ois.close();
		fis.close();
	    }catch(IOException ioe){
		ioe.printStackTrace();
		return p;
	    }catch(ClassNotFoundException c){
		System.out.println("Class not found");
		c.printStackTrace();
		return p;
	    }
	    return p;
	}
    
    
    
    
}
