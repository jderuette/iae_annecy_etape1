package org.iae.annecy.st1.etape1.model.panier;

import org.iae.annecy.st1.etape1.model.produit.Produit;

public class Item{

    private Produit produit;
    private Integer quantite;
    
    public Item(Produit produit, Integer quantite){
	this.produit = produit;
	this.quantite = quantite;
    }
    public Produit getProduit() {
	return produit;
    }
    public void setProduit(Produit produit) {
	this.produit = produit;
    }
    public Integer getQuantite() {
	return quantite;
    }
    public void setQuantite(Integer quantite) {
	this.quantite = quantite;
    }
    
    
}
