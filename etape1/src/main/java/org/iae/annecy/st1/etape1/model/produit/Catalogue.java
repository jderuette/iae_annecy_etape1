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
    
    public String afficherCatalogue(){
	String text = "";
	int i = 1;
	for (Produit produit : listeProduits) {
	    text += i + ": " + produit.affichageProduit()+ "\n";
	    i++;
	}
	return text;
    }
    
    public String afficherCatComplet(){
	String text = "";
	int i = 1;
	for (Produit produit : listeProduits) {
	    text += i + ": " + produit.affichageProdComplet()+ "\n";
	    i++;
	}
	return text;
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
    
    public void save(){
	try{
		FileOutputStream fos = new FileOutputStream("file");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
	}catch (IOException ioe){
		ioe.printStackTrace();
	    }
    }
    
  
    
//    @SuppressWarnings("unchecked")
//    public ArrayList<Produit> deserialize(){
//	ArrayList<Produit> listeP = new ArrayList<Produit>();    
//	this.listeProduits = listeP;
//	    try{
//		FileInputStream fis = new FileInputStream("file");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		listeP = (ArrayList<Produit>) ois.readObject();
//		ois.close();
//		fis.close();
//	    }catch(IOException ioe){
//		ioe.printStackTrace();
//		return listeP;
//	    }catch(ClassNotFoundException c){
//		System.out.println("Class not found");
//		c.printStackTrace();
//		return listeP;
//	    }
//	    return listeP;
//	}
    
}
