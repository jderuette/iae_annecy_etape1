package org.iae.annecy.st1.etape1.model.panier;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.iae.annecy.st1.etape1.model.person.Person;
import org.iae.annecy.st1.etape1.model.produit.Produit;


public class Panier implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -3675148745754361110L;
    private List<Item> panier = new List<Item>(){

	public int size() {
	    // TODO Auto-generated method stub
	    return 0;
	}

	public boolean isEmpty() {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean contains(Object o) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public Iterator<Item> iterator() {
	    // TODO Auto-generated method stub
	    return null;
	}

	public Object[] toArray() {
	    // TODO Auto-generated method stub
	    return null;
	}

	public <T> T[] toArray(T[] a) {
	    // TODO Auto-generated method stub
	    return null;
	}

	public boolean add(Item e) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean remove(Object o) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean containsAll(Collection<?> c) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean addAll(Collection<? extends Item> c) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean addAll(int index, Collection<? extends Item> c) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean removeAll(Collection<?> c) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public boolean retainAll(Collection<?> c) {
	    // TODO Auto-generated method stub
	    return false;
	}

	public void clear() {
	    // TODO Auto-generated method stub
	    
	}

	public Item get(int index) {
	    // TODO Auto-generated method stub
	    return null;
	}

	public Item set(int index, Item element) {
	    // TODO Auto-generated method stub
	    return null;
	}

	public void add(int index, Item element) {
	    // TODO Auto-generated method stub
	    
	}

	public Item remove(int index) {
	    // TODO Auto-generated method stub
	    return null;
	}

	public int indexOf(Object o) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	public int lastIndexOf(Object o) {
	    // TODO Auto-generated method stub
	    return 0;
	}

	public ListIterator<Item> listIterator() {
	    // TODO Auto-generated method stub
	    return null;
	}

	public ListIterator<Item> listIterator(int index) {
	    // TODO Auto-generated method stub
	    return null;
	}

	public List<Item> subList(int fromIndex, int toIndex) {
	    // TODO Auto-generated method stub
	    return null;
	}
    };
    private Person client = new Person();

    public List<Item> getPanier() {
	return panier;
    }

    public void setPanier(List<Item> panier) {
	this.panier = panier;
    }

    public void add(Produit produit, Integer quantite){
	Item item = new Item(produit, quantite);
	this.panier.add(item);
    }

    public Person getClient() {
	return this.client;
    }

    public void setClient(Person client) {
	this.client = client;
    }

    public void supprimerProduit(Produit produit){
	this.panier.remove(produit);
    }

}
