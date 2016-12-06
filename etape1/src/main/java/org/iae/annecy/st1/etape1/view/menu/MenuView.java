package org.iae.annecy.st1.etape1.view.menu;

public class MenuView{
    
    
    public void affichageMenu(){
	String message = "**************MENU PRINCIPAL**************\n"
		+ "1. Modifier un produit\n"
		+ "2. Ajouter un produit\n"
		+ "3. Afficher le catalogue";
	utilAff(message);
    }
    
    public void affichageCaracProduits(){
        String message = "Vous souhaitez ..........\n"
        	+ "1. Modifier le nom\n"
        	+ "2. Modifier la description\n"
        	+ "3. Modifier la description longue\n"
        	+ "4. Modifier le prix";
	utilAff(message);
    }
    
    public void afficherDescription(){
	String message = "vous souhaitez afficher le catalogue...\n"
		+ "1. Avec description courte\n"
		+ "2. Avec description longue";
	utilAff(message);
    }
    
    public void afficherRetour(){
	String message = "Voulez-vous retourner au Menu Principal ? (o/n)";
	utilAff(message);
    }
    
    public void messageErreur(){
        String message = "Commande invalide";
	utilAff(message);
    }
    
    public void utilAff(String message){
	System.out.println(message);
    }

}
