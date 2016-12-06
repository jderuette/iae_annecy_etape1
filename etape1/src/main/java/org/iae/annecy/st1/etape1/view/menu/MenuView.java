package org.iae.annecy.st1.etape1.view.menu;

public class MenuView{
    
    
    public void affichageMenu(){
	String message = "**************MENU PRINCIPAL**************\n"
		+ "\t1. Modifier un produit\n"
		+ "\t2. Ajouter un produit\n"
		+ "\t3. Afficher le catalogue";
	utilAff(message);
    }
    
    public void affichageCaracProduits(){
        String message = ".............. Vous souhaitez ..........\n"
        	+ "\t1. Modifier le nom\n"
        	+ "\t2. Modifier la description\n"
        	+ "\t3. Modifier la description longue\n"
        	+ "\t4. Modifier le prix";
	utilAff(message);
    }
    
    public void afficherDescription(){
	String message = "... vous souhaitez afficher le catalogue...\n"
		+ "\t1. Avec description courte\n"
		+ "\t2. Avec description longue";
	utilAff(message);
    }
    
    public void afficherRetour(){
	String message = "Voulez-vous retourner au Menu Principal ? (o/n)";
	utilAff(message);
    }
    
    public void messageErreur(){
        String message = "............... Commande invalide ...............";
	utilAff(message);
    }
    
    public void utilAff(String message){
	System.out.println(message);
    }

}
