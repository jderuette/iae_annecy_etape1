package org.iae.annecy.st1.etape1.model.produit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Catalogue implements java.io.Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -5818676778770348692L;
    private ArrayList<Produit> listeProduits = new ArrayList<Produit>();   
    
    public ArrayList<Produit> getListeProduits() {
        return this.listeProduits;
    }
    public void setListeProduits(ArrayList<Produit> listeProduits) {
        this.listeProduits = listeProduits;
    }
    
    public void ajouterProduit(Produit p){	
	this.listeProduits.add(p);
	save();
    }
    
    public void supprimerProduit(Produit p){
	this.listeProduits.remove(p);
	save();
    }
    
    /**
     * Permet de retrouver un produit à partir de sa référence
     * 
     * @param reference
     * 		la référence du produit à retrouver
     * @return Un produit
     */
    public Produit retrieveProduit (String reference){
	Iterator<Produit> it = this.getListeProduits().iterator();
	Produit prod = new Produit();
	while(it.hasNext()){
	    Produit current = it.next();
	    if(current.getReference().equals(reference)){
		prod = current;
		break;
	    }
	}
	return prod;
    }
    
    /**
     * Sérialise le catalogue
     */
  
    public void save(){
	ObjectOutputStream oos = null;
	try{
	    FileOutputStream fos = new FileOutputStream("catalogue.ser");
	    oos = new ObjectOutputStream(fos);
	    oos.writeObject(this);
	}catch (IOException ioe){
	    ioe.printStackTrace();
	}finally {
	    try {
		oos.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }    
    
}
