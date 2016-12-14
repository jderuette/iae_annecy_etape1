package org.iae.annecy.st1.etape1.model.produit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Catalogue implements java.io.Serializable{

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
    
    @SuppressWarnings("resource")
    public void save(){
	try{
	    FileOutputStream fos = new FileOutputStream("etape1.ser");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(this);
	}catch (IOException ioe){
	    ioe.printStackTrace();
	}
    }
    
  
    
    
}
